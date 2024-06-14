import { QueenProblem } from "./queen";

test("testing", () => {
  const queen = new QueenProblem();
  const result = queen.solve();
  const expected = 
    ". . Q . \n" + 
    "Q . . . \n" + 
    ". . . Q \n" + 
    ". Q . . \n";

  expect(expected).toBe(result);
});
