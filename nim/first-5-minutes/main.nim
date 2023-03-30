# single-line comment here

#[
Multiline 
comment
]#

discard """
this also works as multiline comment,
because compiler will ignore discard block
"""

import strformat

var
  letter: char = 'i'
  lang = "N" & letter & "m"
  lenght = len(lang)
  boat: float
  truth: bool = false

echo fmt"my string -> {lang}"
echo fmt"my int -> {lenght}"
lenght = 25
echo fmt"my int changed -> {lenght}"

let
  legs = 400

echo fmt"immutable legs -> {legs}"
