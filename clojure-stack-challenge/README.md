# Challenge: Maximum and Minimum Sums of At Most Size K Subarrays

Given an array of integers `numbers` and an integer `k`, calculate the difference between:
- The sum of maximum elements across all subarrays of size at most `k`
- The sum of minimum elements across all subarrays of size at most `k`

## Constraints
- Subarray length must be between 1 and `k` (inclusive)
- Must use stack data structure
- Implementation in Clojure

## Example 1

Input: `numbers = [1, 2, 3]`, `k = 3`

All valid subarrays: `[1]`, `[1,2]`, `[1,2,3]`, `[2]`, `[2,3]`, `[3]`

Maximum elements: `1 + 2 + 3 + 2 + 3 + 3 = 14`

Minimum elements: `1 + 1 + 1 + 2 + 2 + 3 = 10`

Output: `14 - 10 = 4`

## Example 2

Input: `numbers = [3, 1, 5, 4]`, `k = 2`

All valid subarrays: `[3]`, `[3,1]`, `[1]`, `[1,5]`, `[5]`, `[5,4]`, `[4]`

Maximum elements: `3 + 3 + 1 + 5 + 5 + 5 + 4 = 26`

Minimum elements: `3 + 1 + 1 + 1 + 5 + 4 + 4 = 19`

Output: `26 - 19 = 7`

## Running Tests

```bash
clojure -M:test
```

## Implementation Strategy

**Naive Approach (What we DON'T do)**

For each subarray:
- Find the max element
- Find the min element
- Add to respective sums

This would be O(n² × k) - very slow for large arrays.

**Our Strategy: Contribution-Based Approach**

Key Insight: Instead of iterating through subarrays, iterate through elements and ask: "How many subarrays use THIS element as their max/min?"

### 1. Find Boundaries (Using Monotonic Stack)
For each element at position i, find:
- prev[i]: Position of the previous element that's greater/smaller
- next[i]: Position of the next element that's greater/smaller

### 2. Count Contributions
For each element, count how many valid subarrays (length ≤ k) include it as the max/min.

Formula: For each possible left boundary, calculate how many valid right boundaries exist.

### 3. Calculate Total Sum
sum = Σ (element_value × count_of_subarrays)