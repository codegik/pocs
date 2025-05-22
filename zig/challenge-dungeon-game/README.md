# Scala Challenge - Adventure in a Maze

## Count paths with maximum sum from top-left to bottom-right cell in a maze

Given a 2D grid maze[][] of size N * N containing numbers 1, 2 or 3 where: 

1 means we can go Right from that cell only

2 means we can go Down from that cell only 

3 means we can go Right and Down to both paths from that cell. 

We cannot go out of the maze at any time. 

Find the total number of paths from cell (0, 0) to cell (N - 1, N - 1). 

There may be many paths, but we need to select that path which contains the maximum number of Adventure. 

The Adventure on a path is calculated by taking the sum of all the cell values that lies in the path.

## Example
```
Input: {
  {1, 1, 3, 2, 1}, 
  {3, 2, 2, 1, 2}, 
  {1, 3, 3, 1, 3}, 
  {1, 2, 3, 1, 2}, 
  {1, 1, 1, 3, 1}
}
Output: 4 18
Explanation: There are total 4 paths available: 18, 17, 17, 16 out of which the Max Adventure is 18.

Input: {
  {2, 1, 3, 2, 1}, 
  {3, 3, 1, 1, 2}, 
  {1, 3, 2, 1, 3}, 
  {1, 2, 3, 1, 2}, 
  {1, 1, 3, 3, 1}
}
Output: 7 23
Explanation: There are total 7 paths available out of which the max adventure is 23.
```


## Approach
The idea is to use Dynamic Programming to efficiently compute the total number of paths and maximum adventure in a maze. 

Starting from the cell (N-1, N-1), iterate through the maze in reverse, considering different movement cases (Right, Down, Both). 

Update the number of paths and maximum adventure at each cell based on the movement constraints. 

This backward traversal ensures that the answer for the right cell and the down cell which is needed for the current cell is already computed. 

Iterate throughout the grid to get the total number of paths and the maximum adventure.

## MOD
The variable MOD is set to 1000000007 because it is a large prime number commonly used in competitive programming and algorithm design to prevent integer overflow and ensure results fit within standard data types.

Using a prime number helps in reducing the chances of collisions in hash functions and ensures better distribution of values when performing modular arithmetic.

Reference: https://www.geeksforgeeks.org/modulo-1097-1000000007/