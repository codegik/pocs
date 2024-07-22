import {QueenProblem} from "./queen";

test("testing", () => {
    const queen = new QueenProblem(
        [
            [0, 0, 0, 0],
            [0, 0, 0, 0],
            [0, 0, 0, 0],
            [0, 0, 0, 0],
        ]);
    const result = queen.solve();
    const expected =
        ". . Q . \n" +
        "Q . . . \n" +
        ". . . Q \n" +
        ". Q . . \n";

    expect(expected).toBe(result);
});
