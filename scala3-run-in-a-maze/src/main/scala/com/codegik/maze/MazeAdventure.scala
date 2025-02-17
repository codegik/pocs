package com.codegik.maze

class MazeAdventure {

  def findPathsAndMaxAdventure(maze: Array[Array[Int]]): List[Int] = {
    val MOD = 1000000007
    val mazeSize = maze.length
    val paths = Array.ofDim[Int](mazeSize + 1, mazeSize + 1)
    val adventure = Array.ofDim[Int](mazeSize + 1, mazeSize + 1)
    adventure(mazeSize - 1)(mazeSize - 1) = maze(mazeSize - 1)(mazeSize - 1)

    for (i <- (0 until mazeSize).reverse) {
      for (j <- (0 until mazeSize).reverse) {
        if i == mazeSize - 1 && j == i then
          paths(i)(j) = 1
        else
          maze(i)(j) match
            case 1 =>
              paths(i)(j) = paths(i)(j + 1)
              adventure(i)(j) = maze(i)(j) + adventure(i)(j + 1)

            case 2 =>
              paths(i)(j) = paths(i + 1)(j)
              adventure(i)(j) = maze(i)(j) + adventure(i + 1)(j)

            case 3 =>
              paths(i)(j) = (paths(i + 1)(j) + paths(i)(j + 1)) % MOD
              adventure(i)(j) = maze(i)(j) + math.max(adventure(i + 1)(j), adventure(i)(j + 1))
      }
    }

    List(paths(0)(0), adventure(0)(0))
  }
}