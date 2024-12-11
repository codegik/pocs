const uuid = require('uuid');
const express = require('express');
const app = express();
const port = process.argv[2] || 3000

app.listen(port, () => {
 console.log("Server running on port " + port);
});

app.get("/", (req, res, next) => {
 res.json({"port": port, "uuid": uuid.v4()});
});
