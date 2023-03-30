import strFormat
import tables


proc mapToString() =
  let myMap = {"a": "apple", "b": "banana"}.toTable

  for key, value in myMap:
    result.add(fmt"key: {key}, value: {value}\n")

echo mapToString()
