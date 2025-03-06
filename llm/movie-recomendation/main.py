from sentence_transformers import SentenceTransformer
import pandas as pd
import chromadb
import os
import shutil
import time

print("\n📥 Cleaning data...")
shutil.rmtree("./chroma_db", ignore_errors = True)
os.mkdir("./chroma_db")

print("\n📥 Loading data...")
movies_df = pd.read_csv("./movies.csv")
ratings_df = pd.read_csv("./ratings.csv")
tags_df = pd.read_csv("./tags.csv")

# Merge ratings with movie details
# movie_preferences_df = movies_df.merge(tags_df, on="movieId", how="left")
# print(movie_preferences_df)
#
# movie_preferences_df = movie_preferences_df.merge(ratings_df, on="movieId", how="left")
# print(movie_preferences_df)

movie_preferences_df = ratings_df.merge(movies_df, on="movieId", how="left")
print(movie_preferences_df)

# Aggregate data to create a movie profile
print("🔄 Processing movie profiles...\n")
movie_title_input_profiles = movie_preferences_df.groupby("movieId").agg({
    "title": lambda x: x.drop_duplicates() if not x.isnull().all() else "Unknown",
    "genres": lambda x: " | ".join(set("|".join(x.dropna()).split("|"))) if not x.isnull().all() else "Unknown",
    "rating": "mean"
}).reset_index()
print(movie_title_input_profiles)

print("🔍 Loading AI model...\n")
model = SentenceTransformer('sentence-transformers/all-MiniLM-L6-v2')

print("💾 Connecting to ChromaDB...\n")
chroma_client = chromadb.PersistentClient(path="./chroma_db")
collection = chroma_client.get_or_create_collection(name="user_preferences")

print("🚀 Saving embeddings to ChromaDB...\n")

for index, row in movie_title_input_profiles.iterrows():
    movie_id = str(row["movieId"])
    movie_description = f"Movie: {row['title']} | Id: {row['movieId']} | Genres: {row['genres']} | Average Rating: {row['rating']:.2f}"
    print(movie_description)
    embedding_movie = model.encode(movie_description).tolist()

    collection.add(
        ids=[movie_id],
        embeddings=[embedding_movie],
        metadatas=[{"description": movie_description, "rating": row["rating"]}]
    )

print("✅ Embeddings successfully stored in ChromaDB!\n")

while True:
    question = input("\n🎬 Ask me something: ")
    query_embedding = model.encode(question)
    results = collection.query(query_embeddings=query_embedding, n_results=1)
    print(results)
