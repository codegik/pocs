package com.codegik.poc.string

class MyString(private val value: String) {
    // foreach,reverse,equals,replace,substring,trim,toJson,hashCode

    private var length: Int = -1;

    fun length(): Int {
        if (length < 0) {
            length++
            for (i in value) {
                length++
            }
        }
        return length;
    }

    fun toArray(): CharArray {
        var values = CharArray(length())

        value.forEachIndexed { index, element ->
            values[index] = element
        }

        return values
    }

    fun charAt(index: Int): Char {
        assert(index >= 0)
        assert(index < length())

        value.forEachIndexed { i, element ->
            if (i == index) {
                return element
            }
        }

        throw RuntimeException("IndexOutOfBound")
    }

    fun indexOf(char: Char): Int {
        value.forEachIndexed { i, element ->
            if (element == char) {
                return i
            }
        }

        throw RuntimeException("Char not found")
    }

    fun isEmpty(): Boolean {
        if (length() <= 0) {
            return true
        }

        var countSpaces = 0
        for (i in value) {
            if (' ' == i) {
                countSpaces++
            }
        }

        return countSpaces == length()
    }

    fun iterator(): MyStringIterator {
        return MyStringIterator(this)
    }
}


class MyStringIterator(private val string: MyString) {
    private var currentIndex = 0

    fun hasNext(): Boolean {
        return currentIndex < string.length()
    }

    fun next(): Char {
        val currentValue = string.charAt(currentIndex)
        currentIndex++
        return currentValue
    }
}