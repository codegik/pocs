# Length of Longest Increasing Subsequences (LIS) using Segment Tree

Solution for counting the number of longest increasing subsequences in an array using [Nim Lang](https://nim-lang.org/).

## Longest Increasing Subsequence (LIS)

LIS is a classic algorithmic problem where you find the longest subsequence of a given sequence where elements are in strictly increasing order.

Subsequence means you can skip elements but must maintain the original order. You don't need to take consecutive elements.

Example:
```
Array: [10, 9, 2, 5, 3, 7, 101, 18]
LIS: [2, 3, 7, 101] (length = 4)
```

Other valid increasing subsequences exist like `[2, 5, 7, 18]`, but we want the longest one.

## Segment Tree
A Segment Tree is a binary tree data structure used for storing intervals or segments, allowing efficient range queries and updates.

It divides an array into segments and stores aggregate information (sum, min, max, etc.) for each segment. This enables O(log n) query and update operations instead of O(n).

Example:
```
  Array: [1, 3, 5, 7, 9, 11]

  Segment Tree (for sum):
                    36 [0-5]
                  /           \
            9 [0-2]            27 [3-5]
           /      \           /        \
      4 [0-1]   5 [2-2]   16 [3-4]   11 [5-5]
      /    \              /     \
  1 [0-0] 3 [1-1]     7 [3-3]  9 [4-4]

  Each node stores the aggregate value for its range.
```

## Problem

Given an array arr[] of size N, the task is to count the number of longest increasing subsequences present in the given array.

Example 1:

```
Input: arr[] = {2, 2, 2, 2, 2}
Output: 5
Explanation: The length of the longest increasing subsequence is 1, i.e. {2}. Therefore, count of longest increasing subsequences of length 1 is 5.
```

Example 2:

```
Input: arr[] = {1, 3, 5, 4, 7}
Output: 2
Explanation: The length of the longest increasing subsequence is 4, and there are 2 longest increasing subsequences of length 4, i.e. {1, 3, 4, 7} and {1, 3, 5, 7}.
```


## Implementation

Segment tree approach with coordinate compression:
- Time complexity: O(n log n)
- Space complexity: O(n)

The segment tree stores pairs of (length, count) for each range. For each element, we query for the maximum LIS length from all smaller values, then update the tree with the new length and count.


## Requirements

- Nim compiler (tested with 2.2.4)

## Installation

Install Nim from https://nim-lang.org/ or via package manager:

```bash
brew install nim
```

## Usage

Compile and run:

```bash
nim c -r lis.nim
```


