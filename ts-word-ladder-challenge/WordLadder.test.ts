import {WordLadder} from "./WordLadder";

test("test case 1", () => {
    const wordLadder = new WordLadder()
    const result = wordLadder.length("hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"])
    const expected = 5;

    expect(expected).toBe(result);
});

test("test case 2", () => {
    const wordLadder = new WordLadder()
    const result = wordLadder.length("hit", "cog", ["hot","dot","dog","lot","log"])
    const expected = 0;

    expect(expected).toBe(result);
});

test("test case 3", () => {
    const wordLadder = new WordLadder()
    const result = wordLadder.length("be", "ko", ["ce", "mo", "ko", "me", "co"])
    const expected = 4;

    expect(expected).toBe(result);
});