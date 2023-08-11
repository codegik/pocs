package com.codegik.poc.island

class Island {

    val ROW = 5
    val COL = 5

    // A utility function to find min
    // of two integers
    fun min(a: Int, b: Int): Int {
        return if (a < b) a else b
    }

    // A utility function to find min
    // of three integers
    fun min(a: Int, b: Int, c: Int): Int {
        return min(min(a, b), c)
    }

    // A utility function to find max
    // of two integers
    fun max(a: Int, b: Int): Int {
        return if (a > b) a else b
    }

    // The main function that prints given
    // matrix in diagonal order
    fun diagonalOrder(matrix: Array<Array<Int>>): Int {
        var counter = 0

        // There will be ROW+COL-1 lines in the output
        for (line in 1..ROW + COL - 1) {
            var values = 0

            // Get column index of the first
            // element in this line of output.
            // The index is 0 for first ROW
            // lines and line - ROW for remaining lines
            val start_col = max(0, line - ROW)

            // Get count of elements in this line.
            // The count of elements is equal to
            // minimum of line number, COL-start_col and ROW
            val count = min(line, COL - start_col, ROW)

            // Print elements of this line
            for (j in 0 until count) {
                values += matrix[min(ROW, line) - j - 1][start_col + j]
                print(
                    matrix[min(ROW, line) - j - 1][start_col + j].toString() + " "
                )

                val value = matrix[min(ROW, line) - j - 1][start_col + j]

                if (value == 1) {
                    val left = start_col + j - 1
                    if (left >= 0) {
                        val leftValue = matrix[left][min(ROW, line) - j - 1]
                        if (leftValue == 0) {
                            val top = start_col + j
                            if (top >= 0) {
                                val topValue = matrix[top][start_col + j]
                                if (topValue == 0) {
                                    counter++
                                }
                            }
                        }
                    }

                }
            }

            // Print elements of next diagonal on next line
            println()
//            counter += if (values == 0) 1 else 0
        }

        return counter
    }

    fun count(grid: Array<Array<Int>>): Int {
        var rows = grid.size
        var cols = grid[0].size
        var curr = 0
        var groupSize = 1
        var counter = 0
        val iterations = grid.size + grid[0].size - 1

        for (i in (0..iterations)) {
            val row = groupSize + i
            val col = groupSize + 1

            val values = arrayListOf<Int>()
            for (j in (0 until groupSize)) {
                values += grid[0][1]
                values += grid[1][0]
                values += grid[i][groupSize]
            }

            var value = grid[row][col]

            if (value > 0) {
                counter++
            }

            if (i < rows) {
                groupSize++
            } else {
                groupSize--
            }

        }

        return counter
    }

}
