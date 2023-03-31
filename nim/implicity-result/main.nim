import strFormat
import tables


proc mapToString(): string =
  let myMap = {"a": "apple", "b": "banana"}.toTable

  for key, value in myMap:
    result.add(fmt"{key} -> {value}; ")

proc sum(): int =
  result = 5 + 5


echo mapToString()
echo sum()
