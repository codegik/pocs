package com.codegik.poc.java17.sealed;

public abstract sealed class Form permits Circle, Rectangle {

    public abstract String print();

}
