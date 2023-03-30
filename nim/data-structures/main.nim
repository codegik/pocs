# Data Structures 

# tuples
import strFormat
import tables

var
  child: tuple[name: string, age: int]
  today: tuple[sun: string, temp: float]

child = (name: "Inacio", age: 23)
today.sun = "Sunny"
today.temp = 32.45

echo fmt"tuple -> {child}"
echo fmt"tuple -> {today}"


var
  drinks: seq[string] = @["water", "juice"]

drinks.add("milk")

echo fmt"sequence -> {drinks}"

for index, drink in drinks:
  echo fmt"index: {index}, drink: {drink}"


let myMap = {"a": "apple", "b": "banana"}.toTable

for key, value in myMap:
  echo fmt"key: {key}, value: {value}"
