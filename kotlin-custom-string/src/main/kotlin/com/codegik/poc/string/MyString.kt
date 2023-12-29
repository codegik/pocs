package com.codegik.poc.string

class MyString(private val value: String) {
    // substring,trim,toJson

    val size = length()

    private fun length(): Int {
        var length = 0
        for (i in value) {
            length++
        }
        return length;
    }

    fun toArray(): CharArray {
        var values = CharArray(size)
        var i = 0

        for (c in value) {
            values[i] = c
            i++
        }

        return values
    }

    fun charAt(index: Int): Char {
        assert(index >= 0)
        assert(index < size)

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
        if (size <= 0) {
            return true
        }

        var countSpaces = 0
        for (i in value) {
            if (' ' == i) {
                countSpaces++
            }
        }

        return countSpaces == size
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

    fun trim(): MyString {
        if (size == 0) {
            return this
        }

        var string = ""
        var stringLeft = ""
        var stringRight = ""
        var startAt = 0
        var endAt = size - 1

        for (i in 0.until(size)) {
            if (' ' != value[startAt]) {
                stringLeft += value[startAt]
            }
            if (' ' != value[endAt]) {
                stringRight = value[endAt] + stringRight
            }
            startAt++
            endAt--
        }

        for (i in 0.until(size)) {
            if (' ' == value[i]) {
                continue;
            }
            startAt = i
            break
        }

        for (i in (size-1).downTo(0)) {
            if (' ' == value[i]) {
                continue;
            }
            endAt = i
            break
        }

        for (i in startAt..endAt) {
            string += value[i]
        }

        return MyString(string)
    }
}


class MyStringIterator(private val string: MyString) {
    private var currentIndex = 0

    fun hasNext(): Boolean {
        return currentIndex < string.size
    }

    fun next(): Char {
        val currentValue = string.charAt(currentIndex)
        currentIndex++
        return currentValue
    }
}