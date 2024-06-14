# Challenge: N Queen Problem

The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other.

<img src="https://media.geeksforgeeks.org/wp-content/uploads/20230814111654/Solution-Of-4-Queen-Problem.png" width="400" height="400" />

The expected output is in the form of a matrix that has ‘Q‘s for the blocks where queens are placed and the empty spaces are represented by ‘.’.

For example, the following is the output matrix for the above 4-Queen solution.


```
    . Q . .
    . . . Q 
    Q . . .
    . . Q . 
```

## Solution

We can solve this challenge using backtrack algorithm.

### What is Backtracking?

Backtracking is a problem-solving algorithmic technique that involves finding a solution incrementally by trying different options and undoing them if they lead to a dead end.
It is commonly used in situations where you need to explore multiple possibilities to solve a problem, like searching for a path in a maze or solving puzzles like Sudoku.

When a dead end is reached, the algorithm backtracks to the previous decision point and explores a different path until a solution is found or all possibilities have been exhausted.


### Basic Terminologies

- **Candidate:** A candidate is a potential choice or element that can be added to the current solution.
- **Solution:** The solution is a valid and complete configuration that satisfies all problem constraints.
- **Partial Solution:** A partial solution is an intermediate or incomplete configuration being constructed during the backtracking process.
- **Decision Space:** The decision space is the set of all possible candidates or choices at each decision point.
- **Decision Point:** A decision point is a specific step in the algorithm where a candidate is chosen and added to the partial solution.
- **Feasible Solution:** A feasible solution is a partial or complete solution that adheres to all constraints.
- **Dead End:** A dead end occurs when a partial solution cannot be extended without violating constraints.
- **Backtrack:** Backtracking involves undoing previous decisions and returning to a prior decision point.
- **Search Space:** The search space includes all possible combinations of candidates and choices.
- **Optimal Solution:** In optimization problems, the optimal solution is the best possible solution.

