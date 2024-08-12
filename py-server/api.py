from fastapi import FastAPI

app = FastAPI()


@app.get("/hello")
def hello():
    return {"hello budy"}


@app.post("/api/user/v2")
def createUser():
    return {
        "name": "John"
    }
