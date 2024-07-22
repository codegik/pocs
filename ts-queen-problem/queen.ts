export class QueenProblem {
    board: number[][];

    constructor(board: number[][]) {
        this.board = board;
    }

    private boardAsString(): String {
        let columns = this.board.length;
        let lines = this.board[0].length
        let result = "";

        for (let i = 0; i < columns; i++) {
            for (let j = 0; j < lines; j++) {
                if (this.board[i][j] == 1) result += "Q ";
                else result += ". ";
            }
            result += "\n";
        }
        return result;
    }

    private isSafe(row: number, col: number): Boolean {
        for (let i = 0; i < col; i++) {
            if (this.board[row][i]) {
                return false;
            }
        }

        for (let i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (this.board[i][j]) {
                return false;
            }
        }

        for (let i = row, j = col; j >= 0 && i < this.board.length; i++, j--) {
            if (this.board[i][j]) {
                return false;
            }
        }

        return true;
    }

    private search(col: number): Boolean {
        if (col == this.board.length) return true;

        for (let i = 0; i < this.board.length; i++) {
            if (this.isSafe(i, col)) {
                this.board[i][col] = 1;

                if (this.search(col + 1)) {
                    return true;
                }

                this.board[i][col] = 0;
            }
        }

        return false;
    }

    solve(): String {
        if (this.search(0)) {
            return this.boardAsString();
        }

        return "Solution does not exist";
    }
}
