const { addSeconds } = require("./sum-date");
let assert = require("assert");

// + 60 secs
var result = addSeconds("2014-03-04 00:00:00", 60);
assert.equal("2014-03-04 00:01:00", result);

// + 2 mins and 5 secs
result = addSeconds("2014-03-04 00:00:00", 125);
assert.equal("2014-03-04 00:02:05", result);

// + 1 hour
result = addSeconds("2014-03-04 00:00:00", 60 * 60);
assert.equal("2014-03-04 01:00:00", result);

// + 3 hours
result = addSeconds("2014-03-04 00:00:00", 3 * 60 * 60);
assert.equal("2014-03-04 03:00:00", result);

// + 30 hours
result = addSeconds("2014-03-04 00:00:00", 30 * 60 * 60);
assert.equal("2014-03-05 06:00:00", result);

// + 3 days
result = addSeconds("2014-03-04 00:00:00", 3 * 24 * 60 * 60);
assert.equal("2014-03-07 00:00:00", result);

// + 4 months
result = addSeconds("2014-03-04 00:00:00", 4 * 30 * 24 * 60 * 60);
assert.equal("2014-07-04 00:00:00", result);

// + 8 years
result = addSeconds("2014-03-04 00:00:00", 8 * 12 * 30 * 24 * 60 * 60);
assert.equal("2022-03-04 00:00:00", result);

// + 8 years
result = addSeconds("2014-03-04 00:00:00", 8 * 12 * 30 * 24 * 60 * 60);
assert.equal("2022-03-04 00:00:00", result);

console.log("All tests passed");
