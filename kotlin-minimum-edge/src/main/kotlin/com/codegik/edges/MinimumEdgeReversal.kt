package com.codegik.edges

import java.util.ArrayDeque


class MinimumEdgeReversal {

    fun calculate(edges: Array<IntArray>, source: Int, destine: Int): Int {
        // calculate the number of vertices from the edges
        // vertices are numbered from 0 to max vertex number
        val vertices = edges.size + edges[0].size

        // Creating adjacency list for the given graph
        val adjacent = mutableListOf<MutableList<IntArray>>()
        for (i in 0 until vertices) {
            adjacent.add(mutableListOf())
        }

        // Adds the original directed edge with weight 0, no cost because it is already directed
        // Adds the reverse direction with weight 1, cost 1 because it needs to be reversed
        // 0->1 cost 0
        // 1<-0 cost 1, 1<-2 cost 1, 1<-5 cost 1
        // 2<-1 cost 1, 2->3 cost 0
        for (i in 0 until edges.size) {
            val fromNode = edges[i][0]
            val toNode = edges[i][1]
            adjacent[fromNode].add(intArrayOf(toNode, 0))
            adjacent[toNode].add(intArrayOf(fromNode, 1))
        }

        // adjacent[0] = [[1,0]]                    // 0→1 (cost 0)
        // adjacent[1] = [[0,1], [2,1], [5,1]]      // 1→0,2,5 (all cost 1, reversals)
        // adjacent[2] = [[1,0], [3,0]]             // 2→1,3 (cost 0)
        // adjacent[3] = [[2,1], [6,1]]             // 3→2,6 (all cost 1, reversals)
        // adjacent[4] = [[5,0], [6,1]]             // 4→5 (cost 0), 4→6 (cost 1, reversal)
        // adjacent[5] = [[1,0], [4,1]]             // 5→1 (cost 0), 5→4 (cost 1, reversal)
        // adjacent[6] = [[3,0], [4,0]]             // 6→3,4 (cost 0)

        val distance = IntArray(vertices) { Int.MAX_VALUE }
        distance[source] = 0

        val dequeue = ArrayDeque<Int>()
        dequeue.addLast(source) // The position where you add doesn't matter for initialization because the deque is empty.

        while (dequeue.isNotEmpty()) {
            val nodeFrom = dequeue.pollFirst()

            // Iterating over the neighbors of the current vertex
            for (neighbor in adjacent[nodeFrom]) {
                val nodeTo = neighbor[0]
                val weight = neighbor[1]

                // Only process a node if we found a better (shorter) path to it
                // This condition implements relaxation - a core concept in shortest path algorithms.
                if (distance[nodeFrom] + weight < distance[nodeTo]) {
                    distance[nodeTo] = distance[nodeFrom] + weight

                    // Inserting the neighbor into the deque
                    if (weight == 0) {
                        dequeue.addFirst(nodeTo)
                    } else {
                        dequeue.addLast(nodeTo)
                    }
                }
            }
        }

        // If the distance of the destination vertex is Int.MAX_VALUE
        // then there is no path from src to dst
        return if (distance[destine] == Int.MAX_VALUE) -1 else distance[destine]
    }
}
