import pandas as pd
import argparse
from sentence_transformers import SentenceTransformer
import chromadb
import os

parser = argparse.ArgumentParser(description="Movie Recommendation System with ChromaDB")
parser.add_argument("--force-save", action="store_true", help="Force saving embeddings to ChromaDB")
args = parser.parse_args()

# 1️⃣ Load CSV files
print("\n📥 Loading data...")
movies_df = pd.read_csv("./movies.csv")
ratings_df = pd.read_csv("./ratings.csv")
tags_df = pd.read_csv("./tags.csv")

# 2️⃣ Merge ratings with movie details
user_preferences_df = ratings_df.merge(movies_df, on="movieId", how="left")

# 3️⃣ Aggregate data to create a user profile
print("🔄 Processing user profiles...\n")
user_profiles = user_preferences_df.groupby("userId").agg({
    "title": lambda x: " | ".join(x) if not x.isnull().all() else "Unknown",
    "genres": lambda x: " | ".join(set("|".join(x.dropna()).split("|"))) if not x.isnull().all() else "Unknown",
    "rating": "mean"
}).reset_index()

# 4️⃣ Load the model for generating embeddings
print("🔍 Loading AI model...\n")
model = SentenceTransformer('sentence-transformers/all-MiniLM-L6-v2')

# 5️⃣ Create a vector database in ChromaDB
print("💾 Connecting to ChromaDB...\n")
chroma_client = chromadb.PersistentClient(path="./chroma_db")
collection = chroma_client.get_or_create_collection(name="user_preferences")

# 6️⃣ Process and store embeddings **only if --force-save is used**
if args.force_save:
    print("🚀 Force saving embeddings to ChromaDB...\n")
    collection.delete(where={})  # Apagar os dados antigos antes de salvar novamente

    for index, row in user_profiles.iterrows():
        user_id = str(row["userId"])
        user_description = f"Movies: {row['title']} | Genres: {row['genres']} | Average Rating: {row['rating']:.2f}"
        
        # Generate embedding
        embedding = model.encode(user_description).tolist()
        
        # Add to ChromaDB
        collection.add(
            ids=[user_id],  
            embeddings=[embedding],
            metadatas=[{"description": user_description, "rating": row["rating"]}]
        )

    print("✅ User embeddings successfully stored in ChromaDB!\n")
else:
    print("🔄 Using existing ChromaDB embeddings without saving...\n")

# 7️⃣ Function to recommend movies for a specific user
def recommend_movies(user_id):
    user_id = str(user_id)
    
    # Retrieve user metadata
    user_data = collection.get([user_id])
    if not user_data["metadatas"]:
        print("❌ User not found.")
        return

    query_description = user_data["metadatas"][0]["description"]

    # Convert description into an embedding
    query_embedding = model.encode([query_description]).tolist()

    # Find the 10 most similar users
    results = collection.query(
        query_embeddings=query_embedding,
        n_results=10
    )

    print("\n🔍 🔥 Top 10 recommendations based on similar users:\n")
    
    for idx, res in enumerate(results["metadatas"][0], start=1):
        description = res.get("description", "Unknown")

        # Ensure expected data is present
        movies = "Unknown"
        genres = "Unknown"
        rating = "N/A"

        # Extract movies
        if "| Genres:" in description:
            movies = description.split("| Genres:")[0].replace("Movies: ", "").strip()
        else:
            movies = description.replace("Movies: ", "").strip()

        # Extract genres
        if "| Genres:" in description and "| Average Rating:" in description:
            genres = description.split("| Genres:")[1].split("| Average Rating:")[0].strip()

        # Extract rating
        if "| Average Rating:" in description:
            try:
                rating = float(description.split("| Average Rating:")[1].strip())
            except ValueError:
                rating = "N/A"

        print(f"🔹 **Recommendation {idx}:**\n")
        print(f"🎬 Movies: {movies}")
        print(f"📌 Genres: {genres}")
        print(f"⭐ Average Rating: {rating}")
        print("-" * 60)
        print("\n")

def recommend_similar_movies(movie_title):
    # Verify if movie is present in dataset
    movie_data = movies_df[movies_df["title"].str.lower() == movie_title.lower()]
    
    if movie_data.empty:
        print("❌ Movie not found.")
        return
    
    movie_genres = movie_data["genres"].values[0]
    
    # Create a description based on movie description
    query_description = f"Genres: {movie_genres}"
    
    # Generate movie embedding
    query_embedding = model.encode([query_description]).tolist()

    # Search on ChromaDB the 10 movies more similars
    results = collection.query(
        query_embeddings=query_embedding,
        n_results=10
    )

    print("\n🔍 🔥 Top 10 recommended movies based on genre similarity:\n")
    
    for idx, res in enumerate(results["metadatas"][0], start=1):
        description = res.get("description", "Unknown")

        # Extrair filmes e gêneros
        movies = description.split("| Genres:")[0].replace("Movies: ", "").strip() if "| Genres:" in description else "Unknown"
        genres = description.split("| Genres:")[1].split("| Average Rating:")[0].strip() if "| Genres:" in description and "| Average Rating:" in description else "Unknown"

        print(f"🔹 **Recommendation {idx}:**\n")
        print(f"🎬 Movies: {movies}")
        print(f"📌 Genres: {genres}")
        print("-" * 60)
        print("\n")

#  # 9️⃣ Exemple of consult for a specific movie
movie_title_input = input("\n🎬 Enter the movie title for recommendations: ")
recommend_similar_movies(movie_title_input)

# Exemple of consult for a specific user
user_id_input = input("\n👤 Enter the user ID for recommendations: ")
recommend_movies(user_id_input)
