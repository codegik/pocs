# Converter types

This is a Converter Types library where you can convert complex types.

The `Converter` interface is responsible to define the operations.

## Requirements
- Java 17
- Maven 3

## Compiling and Running

```
mvn clean install
```


## Code sample

This sample is converting list of Person to list of Friend type.

```kotlin
val converter = PersonConverter()
val personList = listOf(
    Person("Inacio", 38),
    Person("Gomes", 21),
    Person("Klassmann", 66))

converter.fromList(personList).onEach {
    println(it)
}
```


