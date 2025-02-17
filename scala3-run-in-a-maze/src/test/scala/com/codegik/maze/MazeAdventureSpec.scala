package com.codegik.maze

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class MazeAdventureSpec extends AnyFlatSpec with should.Matchers {

  it should "have 4 paths and top path has 18 adventures" in {
    val maze = Array(
      Array(1, 1, 3, 2, 1),
      Array(3, 2, 2, 1, 2),
      Array(1, 3, 3, 1, 3),
      Array(1, 2, 3, 1, 2),
      Array(1, 1, 1, 3, 1)
    )

    val adventure = MazeAdventure()
    val result = adventure.findPathsAndMaxAdventure(maze)

    result(0) should be (4)
    result(1) should be (18)
  }


  it should "have 7 paths and top path has 23 adventures" in {
    val maze = Array(
      Array(2, 1, 3, 2, 1),
      Array(3, 3, 1, 1, 2),
      Array(1, 3, 2, 1, 3),
      Array(1, 2, 3, 1, 2),
      Array(1, 1, 3, 3, 1)
    )

    val adventure = MazeAdventure()
    val result = adventure.findPathsAndMaxAdventure(maze)

    result(0)  should be (7)
    result(1) should be (23)
  }

}


