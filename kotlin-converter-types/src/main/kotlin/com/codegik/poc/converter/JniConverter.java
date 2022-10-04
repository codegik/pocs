package com.codegik.poc.converter;

public class JniConverter {
    private Object from;

    static {
        System.loadLibrary("native");
    }

    private native String sayHello();

    private native String convertType(Object from);

    public JniConverter from(Object from)  {
        this.from = from;
        return this;
    }

    public String to() {
        return convertType(from);
    }

    public String getStringFromJNI() {
        return sayHello();
    }
}
