package com.codegik.poc.converter;

import java.math.BigDecimal;

public class JniConverter {
    private Object from;

    static {
        System.loadLibrary("native");
    }

    private native String sayHello();

    public JniConverter from(Object from)  {
        this.from = from;
        return this;
    }

    public <T> T to(Class<T> klass) {
        System.out.println("from c++ -> " + sayHello());
        return (T)"heloooo";
    }

    public static void main(String[] args) {
        System.out.println("started!");
        final JniConverter jniConverter = new JniConverter();
        final String converted = jniConverter.from(BigDecimal.TEN).to(String.class);

        System.out.println(converted);
    }
}
