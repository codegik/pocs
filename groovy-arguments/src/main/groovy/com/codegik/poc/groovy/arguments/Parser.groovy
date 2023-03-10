package com.codegik.poc.groovy.arguments

class Parser {

    def List<String> args
    def flags = [
            "-l": Void.class,
            "-dir": String.class,
            "-p": Long.class,
            "-v": Void.class,
            "-d": List<Long>.class,
            "-s": List<String>.class
    ]

    Parser(List<String> args) {
        this.args = args
    }

    Parser(List<String> args, Map<String, Class> flags) {
        this.args = args
        this.flags = this.flags + flags
    }

    boolean compile() {
        try {
            def iterator = args.iterator()
            while (iterator.hasNext()) {
                def flag = iterator.next()
                def klass = flags[flag]
                if (klass != Void.class) {
                    def value = iterator.next()
                    if (flags[value]) {
                        throw new IllegalStateException()
                    }
                    def parsed = switch (klass) {
                        case String.class: yield value
                        case Long.class: yield value.toLong()
                        case List<Long>.class: yield value.split(",")*.toLong()
                        case List<String>.class: yield value.split(",")
                        default: throw new IllegalStateException()
                    }
                    println("parsed value ${flag} -> ${parsed}")
                }
            }
            return true
        } catch (Exception e) {
            return false
        }
    }
}
