import chromadb
from sentence_transformers import SentenceTransformer

student_info = """
Alexandra Thompson, a 19-year-old computer science sophomore with a 3.7 GPA
"""

club_info = """
The university chess club provides an outlet for students to come together and enjoy playing
the classic strategy game of chess
"""

university_info = """
The University of Washington, founded in 1861 in Seattle
"""

client = chromadb.HttpClient(host='localhost', port=8000)
model = SentenceTransformer('sentence-transformers/all-MiniLM-L6-v2')
embeddings = model.encode([student_info, club_info, university_info])

collection = client.get_or_create_collection(name="Students")

collection.add(
    embeddings=embeddings,
    documents=[student_info, club_info, university_info],
    metadatas=[{"source": "student info"}, {"source": "club info"}, {'source': 'university info'}],
    ids=["id1", "id2", "id3"]
)

query_embedding = model.encode("Give me student id1")
results = collection.query(query_embeddings=query_embedding, n_results=1)

print(results)

query_embedding = model.encode("What is the student name?")
results = collection.query(query_embeddings=query_embedding, n_results=1)

print(results)

collection.delete(ids=["id1", "id2", "id3"])
