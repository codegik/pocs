package com.codegik.edges

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class MinimumEdgeReversalTest {

    private val minimumEdgeReversal = MinimumEdgeReversal()

    @Test
    fun `test simple graph with one reversal needed`() {
        // Graph: 0 -> 1 -> 2 -> 3 <- 4
        //               ^
        //               |
        //               5
        val edges: Array<IntArray> = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(4, 3),
            intArrayOf(5, 2)
        )

        // Path from 0 to 4: Need to reverse edge (4,3) to (3,4)
        assertEquals(1, minimumEdgeReversal.calculate(edges,  0, 4))
    }

    @Test
    fun `test disconnected graph`() {
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        )

        // No path from 0 to 4 even with reversals
        assertEquals(-1, minimumEdgeReversal.calculate(edges, 0, 4))
    }

    @Test
    fun `test cyclic graph`() {
        // Graph with a cycle: 0 -> 1 -> 2 -> 0
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 0),
            intArrayOf(0, 3)
        )

        // Path from 3 to 1: Need to reverse edge (0,3) to (3,0), then follow 3->0->1
        assertEquals(1, minimumEdgeReversal.calculate(edges, 3, 1))
    }

    @Test
    fun `test complex graph with multiple possible paths`() {
        // A more complex graph with multiple path options
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(1, 3),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(3, 5),
            intArrayOf(6, 4),
            intArrayOf(5, 7)
        )

        // Path from 0 to 7: Best path is 0->2->3->5->7 with no reversals
        assertEquals(0, minimumEdgeReversal.calculate(edges, 0, 7))

        // Path from 7 to 0: Need to reverse 0->2->3->5->7 to 7->5->3->2->0
        assertEquals(4, minimumEdgeReversal.calculate(edges, 7, 0))

        // Path from 6 to 7: Need to reverse (6,4) to (4,6), then follow 6->4->3->5->7
        assertEquals(1, minimumEdgeReversal.calculate(edges, 6, 7))
    }

    @Test
    fun `test graph with same edge weight options`() {
        // Graph with multiple paths with the same number of reversals
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(1, 3),
            intArrayOf(2, 4),
            intArrayOf(3, 5),
            intArrayOf(4, 5)
        )

        // Path from 5 to 0: Can reverse either 5->3->1->0 or 5->4->2->0 (both need 3 reversals)
        assertEquals(3, minimumEdgeReversal.calculate(edges, 5, 0))
    }

    @Test
    fun `test complex graph with two possible paths`() {
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(2, 1),
            intArrayOf(2, 3),
            intArrayOf(6, 3),
            intArrayOf(6, 4),
            intArrayOf(4, 5),
            intArrayOf(5, 1)
        )

        // Paths from 0 to 6:
        // 0->1->2->3->6 (need two reverse)
        // 0->1->5->4->6 (need tree reverse)
        assertEquals(2, minimumEdgeReversal.calculate(edges, 0, 6))
    }
}
