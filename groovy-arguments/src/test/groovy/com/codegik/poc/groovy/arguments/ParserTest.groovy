package com.codegik.poc.groovy.arguments


import org.junit.jupiter.api.Test

import static org.junit.jupiter.api.Assertions.assertEquals

class ParserTest {

    @Test
    void noArgs(){
        def args = []
        def result = new Parser(args).compile()
        assertEquals(true, result)
    }


    @Test
    void oneArg(){
        def args = ["-l"]
        def result = new Parser(args).compile()
        assertEquals(true, result)
    }


    @Test
    void oneArgDoesntExists(){
        def args = ["-i"]
        def result = new Parser(args).compile()
        assertEquals(false, result)
    }


    @Test
    void oneArgWithValue(){
        def args = ["-dir", "/tmp"]
        def result = new Parser(args).compile()
        assertEquals(true, result)
    }


    @Test
    void oneArgWithoutItsValue(){
        def args = ["-dir", "-l"]
        def result = new Parser(args).compile()
        assertEquals(false, result)
    }


    @Test
    void oneArgWithoutItsValue2(){
        def args = ["-dir"]
        def result = new Parser(args).compile()
        assertEquals(false, result)
    }


    @Test
    void oneArgWithLongValue(){
        def args = ["-d", "3"]
        def result = new Parser(args).compile()
        assertEquals(true, result)
    }


    @Test
    void oneArgWithLongsValue(){
        def args = ["-d", "-3,6,7"]
        def result = new Parser(args).compile()
        assertEquals(true, result)
    }


    @Test
    void oneArgWithLongsInvalidValue(){
        def args = ["-d", "3,6,7f"]
        def result = new Parser(args).compile()
        assertEquals(false, result)
    }


    @Test
    void oneArgWithStringsValue(){
        def args = ["-s", "3,6,7f"]
        def result = new Parser(args).compile()
        assertEquals(false, result)
    }


    @Test
    void manyArgs(){
        def args = ["-s", "3,6,7f", "-v", "-l", "-p", "123"]
        def result = new Parser(args).compile()
        assertEquals(false, result)
    }


    @Test
    void setNewFlag(){
        def args = ["-k", "5"]
        def parser = new Parser(args, ["-k": Long.class])
        def result = parser.compile()
        assertEquals(true, result)
    }


    @Test
    void setNewFlagWithWrongValue(){
        def args = ["-k", "yow"]
        def parser = new Parser(args, ["-k": Long.class])
        def result = parser.compile()
        assertEquals(false, result)
    }
}
