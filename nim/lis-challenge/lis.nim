import algorithm, strutils

# The Node type has both length and count because we need to track two things simultaneously:
# length: The maximum LIS length for elements in that segment
# count: How many distinct subsequences achieve that maximum length
type
  Node = object
    length: int
    count: int

proc printTree(tree: seq[Node], size: int) =
  echo "Segment Tree:"
  
  var depth = 0
  var temp = size
  while temp > 0:
    depth += 1
    temp = temp div 2
  
  var nodeIndex = 1
  for level in 0 ..< depth:
    let nodesInLevel = 1 shl level  # 2^level
    var line = ""
    
    # Add indentation based on level
    let indent = " ".repeat((1 shl (depth - level - 1)) - 1)
    let spacing = " ".repeat((1 shl (depth - level)) - 1)
    
    line.add(indent)
    
    for i in 0 ..< nodesInLevel:
      if nodeIndex < tree.len:
        if tree[nodeIndex].length > 0 or tree[nodeIndex].count > 0:
          line.add("[" & $nodeIndex & ":L" & $tree[nodeIndex].length & ",C" & $tree[nodeIndex].count & "]")
        else:
          line.add("[" & $nodeIndex & ":--]")
        nodeIndex += 1
      
      if i < nodesInLevel - 1:
        line.add(spacing)
    
    echo line


proc merge(a, b: Node): Node =
  if a.length > b.length:
    return a
  elif a.length < b.length:
    return b
  else:
    return Node(length: a.length, count: a.count + b.count)

proc update(tree: var seq[Node], nodeIndex, left, right, pos: int, node: Node) =
  if left == right:
    tree[nodeIndex] = merge(tree[nodeIndex], node)
    return

  let mid = (left + right) div 2
  if pos <= mid:
    tree.update(2 * nodeIndex, left, mid, pos, node)
  else:
    tree.update(2 * nodeIndex + 1, mid + 1, right, pos, node)

  tree[nodeIndex] = merge(tree[2 * nodeIndex], tree[2 * nodeIndex + 1])


# The query function recursively searches the segment tree to find the best LIS information in a given range.
# node = 1, It's a 1-indexed convention that makes the parent-child math simpler in segment trees.
# The tree[0] position in the array is simply unused with this convention.
# No edge case: With 0-indexed, 2*0 = 0
# Nim has this feature Method Call Syntax, which allows us to call methods on sequences like `tree.query(...)`.

# Level 0:                    [1]
#                            /    \
# Level 1:              [2]          [3]
#                      /    \        /    \
# Level 2:         [4]      [5]  [6]      [7]
#                 / \       / \   / \      / \
# Level 3:      [8] [9] [10][11][12][13][14][15]
proc query(tree: seq[Node], nodeIndex, left, right, qLeft, qRight: int): Node =
  # Query range doesn't intersect with current node's range. Return empty result.
  # Node range [5, 10]
  # Query range [12, 15]
  if qLeft > right or qRight < left:
    return Node(length: 0, count: 0)

  # Current node is completely inside query range. Return its stored value directly without further recursion.
  # Node range [5, 10]
  # Query range [3, 15]
  if qLeft <= left and right <= qRight:
    return tree[nodeIndex]

  # Node partially overlaps query. Split in half and recursively query both children, then merge results.
  # Node range [5, 10]
  # Query range [8, 20]
  let mid = (left + right) div 2
  # Why multiploy by 2? Because 2 * node is the left child's index in the 1-indexed segment tree array.
  let leftResult = tree.query(2 * nodeIndex, left, mid, qLeft, qRight)
  let rightResult = tree.query(2 * nodeIndex + 1, mid + 1, right, qLeft, qRight)

  return merge(leftResult, rightResult)


# Sample: arr = [1, 3, 5, 4, 7]
proc countLIS(arr: seq[int]): int =
  let size = arr.len
  if size == 0:
    return 0

  # Binary search to map each value to its rank
  var sorted = arr
  sorted.sort() # sorted becomes [1, 3, 4, 5, 7]
  var compressed = newSeq[int](size)

  for i in 0 ..< size:
    var left = 0
    var right = size - 1
    while left < right:
      let mid = (left + right) div 2
      if sorted[mid] < arr[i]:
        left = mid + 1
      else:
        right = mid
    compressed[i] = left # Maps array values to indices (0 to n-1)

  echo "Sorted: ", sorted
  echo "Compressed: ", compressed # compressed is [0, 1, 3, 2, 4]

  # The 4 * n is a safe upper bound for the segment tree size, based on how binary trees allocate memory.
  var tree = newSeq[Node](4 * size)

  for i in 0 ..< size:
    let pos = compressed[i]
    var current = Node(length: 1, count: 1)

    # Prevents querying an invalid range and handles the base case for the smallest element
    if pos > 0:
      let prev = tree.query(1, 0, size - 1, 0, pos - 1)
      # Check if we found any valid previous subsequence. 
      # If prev.length = 0, no smaller elements were processed yet (tree is empty at those positions).
      if prev.length > 0:
        current = Node(length: prev.length + 1, count: prev.count)

    tree.update(1, 0, size - 1, pos, current)
    printTree(tree, size)
    echo ""

  let final = tree.query(1, 0, size - 1, 0, size - 1)
  return final.count


when isMainModule:
  var arr1 = @[2, 2, 2, 2, 2]
  echo "Input: ", arr1
  echo "Output: ", countLIS(arr1)
  echo ""

  var arr2 = @[1, 3, 5, 4, 7]
  echo "Input: ", arr2
  echo "Output: ", countLIS(arr2)
  echo ""

  var arr3 = @[1, 2, 4, 3, 5, 4, 7, 2]
  echo "Input: ", arr3
  echo "Output: ", countLIS(arr3)

