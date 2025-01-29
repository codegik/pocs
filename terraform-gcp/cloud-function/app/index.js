const functions = require('@google-cloud/functions-framework');

functions.http('hello', (req, res) => {
    res.send('Hello World');
});