# Visual Guide to the Solution

## Example: [3, 1, 5, 4] with k=2

### Step 1: Finding Maximum Boundaries

```
Array:     [3,  1,  5,  4]
Indices:    0   1   2   3

For each element, find the range where it can be the MAXIMUM:

Element at index 0 (value=3):
    ◄──►
    3   1   5   4
    └─►         Can be max in range [0..1]
    prev=-1, next=2

Element at index 1 (value=1):
        ◄►
    3   1   5   4
        └──►    Can be max in range [1..1]
    prev=0, next=2

Element at index 2 (value=5):
    ◄───────────►
    3   1   5   4
            └─►  Can be max in range [2..3]
    prev=-1, next=4 (end)

Element at index 3 (value=4):
                ◄►
    3   1   5   4
                └► Can be max in range [3..3]
    prev=2, next=4 (end)
```

### Step 2: Count Contributions (with k=2)

```
For each element, count subarrays (length ≤ 2) where it's the max:

Element 3 (range [0..1]):
    [3]         ✓ length=1
    [3,1]       ✓ length=2
    Total: 2 subarrays → contribution = 3 × 2 = 6

Element 1 (range [1..1]):
    [1]         ✓ length=1
    Total: 1 subarray → contribution = 1 × 1 = 1

Element 5 (range [2..3]):
    [5]         ✓ length=1
    [1,5]       ✓ length=2 (starts outside range but includes 5)
    [5,4]       ✓ length=2
    Total: 3 subarrays → contribution = 5 × 3 = 15

Element 4 (range [3..3]):
    [4]         ✓ length=1
    Total: 1 subarray → contribution = 4 × 1 = 4

Max Sum = 6 + 1 + 15 + 4 = 26
```

### Step 3: Finding Minimum Boundaries

```
Array:     [3,  1,  5,  4]
Indices:    0   1   2   3

For each element, find the range where it can be the MINIMUM:

Element at index 0 (value=3):
    ◄►
    3   1   5   4
    └──►        Can be min in range [0..0]
    prev=-1, next=1

Element at index 1 (value=1):
    ◄───────────►
    3   1   5   4
        └──►    Can be min in range [1..3]
    prev=-1, next=4 (end)

Element at index 2 (value=5):
            ◄►
    3   1   5   4
            └──► Can be min in range [2..2]
    prev=1, next=3

Element at index 3 (value=4):
                ◄►
    3   1   5   4
                └► Can be min in range [3..3]
    prev=1, next=4 (end)
```

### Step 4: Count Min Contributions

```
Element 3 (range [0..0]):
    [3]         ✓ length=1
    Total: 1 subarray → contribution = 3 × 1 = 3

Element 1 (range [1..3]):
    [1]         ✓ length=1
    [3,1]       ✓ length=2 (starts outside but includes 1)
    [1,5]       ✓ length=2
    Total: 3 subarrays → contribution = 1 × 3 = 3

Element 5 (range [2..2]):
    [5]         ✓ length=1
    Total: 1 subarray → contribution = 5 × 1 = 5

Element 4 (range [3..3]):
    [4]         ✓ length=1
    [5,4]       ✓ length=2 (starts outside but includes 4)
    Total: 2 subarrays → contribution = 4 × 2 = 8

Min Sum = 3 + 3 + 5 + 8 = 19
```

### Result

```
Answer = Max Sum - Min Sum = 26 - 19 = 7
```

## Monotonic Stack Visualization

### Finding Max Boundaries for [3, 1, 5, 4]

```
Step 0: Process element 3
    Stack: []
    → No elements to pop
    → prev[0] = -1 (stack empty)
    → Push 0
    Stack: [0]

Step 1: Process element 1
    Stack: [0]
    → 3 > 1? Yes, keep it (monotonic decreasing for max)
    → prev[1] = 0 (top of stack)
    → Push 1
    Stack: [0, 1]

Step 2: Process element 5
    Stack: [0, 1]
    → 1 > 5? No! Pop 1, set next[1] = 2
    Stack: [0]
    → 3 > 5? No! Pop 0, set next[0] = 2
    Stack: []
    → prev[2] = -1 (stack empty)
    → Push 2
    Stack: [2]

Step 3: Process element 4
    Stack: [2]
    → 5 > 4? Yes, keep it
    → prev[3] = 2 (top of stack)
    → Push 3
    Stack: [2, 3]

Final boundaries:
    prev = [-1, 0, -1, 2]
    next = [2, 2, 4, 4]
```

## Key Insight Diagram

```
Traditional approach:          Contribution approach:
────────────────────          ────────────────────

For each subarray:            For each element:
  ┌─────────┐                   ┌─────────┐
  │ [3]     │                   │ Value:3 │
  │ max=3   │                   │ Appears │
  │ min=3   │                   │ as max  │
  └─────────┘                   │ in 2    │
       ↓                        │ arrays  │
  ┌─────────┐                   └─────────┘
  │ [3,1]   │                        ↓
  │ max=3   │                   3 × 2 = 6
  │ min=1   │
  └─────────┘
       ↓
  ┌─────────┐
  │ [1]     │
  │ max=1   │
  │ min=1   │
  └─────────┘
       ↓
     ...

O(n² × k) operations        O(n) operations
```
