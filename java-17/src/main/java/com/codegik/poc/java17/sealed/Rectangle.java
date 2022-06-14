package com.codegik.poc.java17.sealed;

public sealed class Rectangle extends Form permits TransparentRectangle {
    @Override
    public String print() {
        return "rectangle";
    }
}
