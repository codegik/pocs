package com.codegik.poc.java17;

public record RecordData(int age, String name) {
    public RecordData() {
        this(3, "Mary");
    }

    public String toString() {
        return  """
                    
                    {
                        age: %s,
                        name: %s
                    }
                """.formatted(age, name);
    }
}
