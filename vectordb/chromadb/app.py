import chromadb
import os

from sentence_transformers import SentenceTransformer

os.environ['CURL_CA_BUNDLE'] = '<add cert here>'

student_info = """
Alexandra Thompson, a 19-year-old computer science sophomore with a 3.7 GPA,
is a member of the programming and chess clubs who enjoys pizza, swimming, and hiking
in her free time in hopes of working at a tech company after graduating from the University of Washington.
"""

club_info = """
The university chess club provides an outlet for students to come together and enjoy playing
the classic strategy game of chess. Members of all skill levels are welcome, from beginners learning
the rules to experienced tournament players. The club typically meets a few times per week to play casual games,
participate in tournaments, analyze famous chess matches, and improve members' skills.
"""

university_info = """
The University of Washington, founded in 1861 in Seattle, is a public research university
with over 45,000 students across three campuses in Seattle, Tacoma, and Bothell.
As the flagship institution of the six public universities in Washington state,
UW encompasses over 500 buildings and 20 million square feet of space,
including one of the largest library systems in the world.
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

query_embedding = model.encode("Give me students id1, id2 and id3")
results = collection.query(query_embeddings=query_embedding, n_results=3)

print(results)

query_embedding = model.encode("What is the student name?")
results = collection.query(query_embeddings=query_embedding, n_results=2)

print(results)

collection.delete(ids=["id1", "id2", "id3"])
