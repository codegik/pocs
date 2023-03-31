
case "john":
  of "mary":
    echo "M"
  of "inacio":
    echo "I"
  of "john":
    echo "J"


proc letter(l: char): string =
  case l:
    of 'a', 'e', 'i':
      "vowel"
    of '\127'..'\255':
      "unknow"
    else:
      "consoant"


echo letter('a')
echo letter('\208')
echo letter('g')
