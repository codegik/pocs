# Converter types

This is a Converter Types library where you can convert complex types.

The `Converter` interface is responsible to define the operations.

## Requirements
- Java 17
- Maven 3

## Compiling and Running

```
./mvnw clean install
```


## GikConverter

This is a smart converter that create the converter class on runtime and cache the same.

### Requirement

To enable this feature, its necessary add jvm parameter as below.
```
--add-opens java.base/java.lang=ALL-UNNAMED
```

This sample is converting a Person to Friend type.
```kotlin
val converter = GikConverter()
val friend = Friend(name = "Joana", age = 23, email = "nomail")
val person = converter.from(friend).to(Person::class)

assertEquals(person.name, friend.name)
assertEquals(person.age, friend.age)
assertEquals(person.address, friend.email)
```


## GenericConverter

This sample is converting a Person to Friend type using reflections and cache.

```kotlin
val converter = GenericConverter()
val person = Person("Inacio", 38, "me@mail.com")
val friend = converter.from(person).to(Friend::class.java)

assertEquals(person.name, friend.name)
assertEquals(person.age, friend.age)
assertEquals(person.address, friend.email)
```


## UnsafeConverter

This sample is converting a Person to Friend type using reflections, Unsafe and cache.

```kotlin
val converter = UnsafeConverter()
val person = Person("Inacio", 38, "me@mail.com")
val friend = converter.from(person).to(Friend::class.java)

assertEquals(person.name, friend.name)
assertEquals(person.age, friend.age)
assertEquals(person.address, friend.email)
```

## Performance

The performance test is available on `PerformanceConverterTest` class.

Doing a comparison between three converter solutions we can observe the time in milliseconds that took to process records:


| Records | GikConverter (ms) | GenericConverter (ms) | UnsafeConverter (ms) |
|:-------:|:-----------------:|:---------------------:|:----------:|
|   1M    |       2872        |         2047          |    2130    |
|   2M    |       2769        |         3786          |    3844    |
|   3M    |       3994        |         5471          |    5761    |
|   10M   |       13132       |         17882         |    19338    |
|   30M   |       39302       |         53535         |    57415    |


