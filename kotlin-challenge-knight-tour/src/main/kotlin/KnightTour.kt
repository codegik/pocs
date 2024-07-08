
class KnightTour {
    private var boardSize: Int = 8

    /* xMove[] and yMove[] define next move of Knight.
       xMove[] is for next value of x coordinate
       yMove[] is for next value of y coordinate */
    private val xMove = intArrayOf(2, 1, -1, -2, -2, -1,  1,  2)
    private val yMove = intArrayOf(1, 2,  2,  1, -1, -2, -2, -1)
    private val board = Array(boardSize) { IntArray(boardSize) }


    /* A utility function to check if x, y are valid indexes for N*N chessboard.
       Also, its checking if the coordinate x, y was never visited (sol[x][y] == -1) */
    private fun isSafe(x: Int, y: Int, sol: Array<IntArray>): Boolean {
        return x in 0..< boardSize && y in 0 ..< boardSize && sol[x][y] == -1
    }

    /* A recursive utility function to solve Knight Tour problem */
    private fun solveNextMove(x: Int, y: Int, movei: Int): Boolean {
        var nextX: Int
        var nextY: Int

        if (movei == boardSize * boardSize) {
            return true
        }

        /* Try all next moves from the current coordinate x, y */
        var k = 0
        while (k < boardSize) {
            nextX = x + xMove[k]
            nextY = y + yMove[k]
            if (isSafe(nextX, nextY, board)) {
                board[nextX][nextY] = movei
                if (solveNextMove(nextX, nextY, movei + 1)) {
                    return true
                } else {
                    board[nextX][nextY] = -1 // backtracking
                }
            }
            k++
        }

        return false
    }


    /* This function solves the Knight Tour problem using Backtracking  */
    fun solve(): String {

        /* Initialization of solution matrix */
        for (x in 0 until boardSize) {
            for (y in 0 until boardSize) {
                board[x][y] = -1
            }
        }

        // Since the Knight is initially at the first block
        board[0][0] = 0

        /* Start from 0,0 and explore all tours using solveKTUtil() */
        if (!solveNextMove(0, 0, 1)) {
            return "Solution does not exist"
        }

        return printSolution(board)
    }

    /* A utility function to print solution matrix sol[N][N] */
    private fun printSolution(sol: Array<IntArray>): String {
        var result = ""
        for (x in 0 until boardSize) {
            for (y in 0 until boardSize) {
                result += sol[x][y].toString() + " "
            }
            result += "\n"
        }

        return result
    }
}
