package com.codegik.poc.converter;

public class JniConverter {
    private Object from;

    static {
        System.loadLibrary("native");
    }

    private native String sayHello();

    private native String convertType(Object from, Class klass);

    public JniConverter from(Object from)  {
        this.from = from;
        return this;
    }

    public String to(Class klass) {
        klass.getDeclaredFields();
        return convertType(from, klass);
    }

    public String getStringFromJNI() {
        return sayHello();
    }
}
