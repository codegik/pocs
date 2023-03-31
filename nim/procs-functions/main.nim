# PROCS

proc fibonacci(n: int): int =
  if n < 2:
    result = n
  else:
    result = fibonacci(n - 1) + (n - 2).fibonacci


proc sum(a: int, b: int): int =
  a + b


proc `*`(a: char, b: int): string =
  for i in 0 .. b - 1:
    result.add(a)


echo fibonacci(4)
echo sum(4, 5)
echo 4.sum(5)
echo 'A' * 4


# FUNCTIONS
import sugar

proc map(str: string, fun: (char) -> int): int =
  for c in str:
    result += fun(c)


echo "inacio".map((c) => int(c))
echo "john".map((c) => int(c))


import sequtils

let numbers = @[1, 2, 3, 4, 5, 6, 7]

proc greaterThan5(n: int): bool = n > 5

echo numbers.filter(greaterThan5)
echo numbers.filter((n) => n > 3)
