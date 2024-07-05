export class QueenProblem {
  boardSize = 8;

  boardAsString(board: number[][]): String {
    let result = "";
    for (let i = 0; i < this.boardSize; i++) {
      for (let j = 0; j < this.boardSize; j++) {
        if (board[i][j] == 1) result += "Q ";
        else result += ". ";
      }
      result += "\n";
    }
    return result;
  }

  isSafe(board: number[][], row: number, col: number): Boolean {
    for (let i = 0; i < col; i++) {
      if (board[row][i] == 1) {
        return false;
      }
    }

    for (let i = row, j = col; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j]) {
        return false;
      }
    }

    for (let i = row, j = col; j >= 0 && i < this.boardSize; i++, j--) {
      if (board[i][j]) {
        return false;
      }
    }

    return true;
  }

  search(board: number[][], col: number): Boolean {
    if (col >= this.boardSize) return true;

    for (let i = 0; i < this.boardSize; i++) {
      if (this.isSafe(board, i, col) == true) {
        board[i][col] = 1;

        if (this.search(board, col + 1) == true) {
          return true;
        }

        board[i][col] = 0;
      }
    }

    return false;
  }

  solve(): String {
    let board = [
      [0, 0, 0, 0, 0, 0, 0, 0],
      [0, 0, 0, 0, 0, 0, 0, 0],
      [0, 0, 0, 0, 0, 0, 0, 0],
      [0, 0, 0, 0, 0, 0, 0, 0],
      [0, 0, 0, 0, 0, 0, 0, 0],
      [0, 0, 0, 0, 0, 0, 0, 0],
      [0, 0, 0, 0, 0, 0, 0, 0],
      [0, 0, 0, 0, 0, 0, 0, 0],
    ];

    if (this.search(board, 0) == false) {
      return "Solution does not exist";
    }

    return this.boardAsString(board);
  }
}
