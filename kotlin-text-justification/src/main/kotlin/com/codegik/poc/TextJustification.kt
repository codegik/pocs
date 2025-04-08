package com.codegik.poc

import kotlin.math.max


/**
 * The sentence "Extra spaces between words should be distributed as evenly as possible.
 * If the number of spaces on a line do not divide evenly between words,
 * the empty slots on the left will be assigned more spaces than the slots on the right"
 * was just a really long and awkward way to say round robin.
 *
 * Once you determine that there are only k words that can fit on a given line,
 * you know what the total length of those words is num_of_letters.
 * Then the rest are spaces, and there are (maxWidth - num_of_letters) of spaces.
 * The "or 1" part is for dealing with the edge case len(cur) == 1.
 */
class TextJustification {
    fun justify(words: List<String>, maxWidth: Int): List<String> {
        val result = mutableListOf<String>()
        var currentLine = mutableListOf<String>()
        var numOfLetters = 0

        for (word in words) {
            if ((numOfLetters + word.length + currentLine.size) > maxWidth) {
                val size = max(1, currentLine.size - 1)
                val leftSpaces = maxWidth - numOfLetters
                for (i in 0 until leftSpaces) {
                    currentLine[i % size] += " "
                }
                result.add(currentLine.joinToString(""))
                currentLine = mutableListOf()
                numOfLetters = 0
            }
            currentLine.add(word)
            numOfLetters += word.length
        }
        result.add(currentLine.joinToString(" ").padEnd(maxWidth))

        return result
    }
}