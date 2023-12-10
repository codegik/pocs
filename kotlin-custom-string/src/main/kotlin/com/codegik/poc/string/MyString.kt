package com.codegik.poc.string

class MyString(private val value: String) {
    // substring,trim,toJson

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
        var i = 0

        for (c in value) {
            values[i] = c
            i++
        }

        return values
    }

    fun charAt(index: Int): Char {
        assert(index >= 0)
        assert(index < length())

        var i = 0
        for (c in value) {
            if (index == i) {
                return c
            }
            i++
        }

        throw RuntimeException("IndexOutOfBound")
    }

    fun indexOf(char: Char): Int {
        var index = 0
        for (i in value) {
            if (char == i) {
                return index
            }
            index++
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

    fun foreach(action: (Char) -> Unit) {
        for (i in value) {
            action(i)
        }
    }

    fun reverse(): String {
        var reversed = ""

        for (c in value) {
            reversed = c + reversed
        }

        return reversed
    }

    override fun equals(other: Any?): Boolean {
        return this.hashCode() == other.hashCode()
    }

    override fun hashCode(): Int {
        var h = 0
        for (c in value) {
            h = 31 * h + (c.toInt() and 0xff)
        }
        return h
    }

    fun replace(oldChar: Char, newChar: Char): MyString {
        var result = ""
        for (c in value) {
            result += (if (c == oldChar) newChar else c)
        }
        return MyString(result)
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