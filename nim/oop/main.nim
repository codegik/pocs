
type Animal = ref object
  name: string
  age: int

proc speak(self: Animal, msg: string): string =
  self.name & " said " & msg

proc updateName(self: Animal, name: string) =
  self.name = name

let monkey = Animal(name: "Kong", age: 98)

echo monkey.speak("uuuaaa")
monkey.updateName("King")
echo speak(monkey, "hey man")

