#!/opt/homebrew/bin/bash

source scrabble.sh

testOneWord() {
    result=$(scrabble "cabbage")
    assertEquals "cabbage: 14" "$result"
}

testTwoLetters() {
    result=$(scrabble "a" "q")
    assertEquals "q: 10" "$result"
}

testMultipleWords() {
    result=$(scrabble "igk" "3423" "eeeee")
    assertEquals "igk: 8" "$result"
}

testMultipleWordsWithoutQuotes() {
    result=$(scrabble igk 3423 eeeee)
    assertEquals "igk: 8" "$result"
}

. shunit2