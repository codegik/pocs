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


## GenericConverter

This sample is converting a Person to Friend type.

```kotlin
val person = Person("Inacio", 38, "me@mail.com")
val friend = converter.from(person).to(Friend::class.java)

assertEquals(person.name, friend.name)
assertEquals(person.age, friend.age)
assertEquals(person.address, friend.email)
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
val friend = Friend(name = "Joana", age = 23, email = "nomail")
val person = converter.from(friend).to(Person::class)

assertEquals(person.name, friend.name)
assertEquals(person.age, friend.age)
assertEquals(person.address, friend.email)
```


## Performance

The performance test is available on `PerformanceConverterTest` class.

Doing a comparison between two converter solutions we can observe the gain of `GikConverter` against `GenericConverter`:

| Records | GikConverter (ms) | GenericConverter (ms) |  Gain  |
|:-------:|:-----------------:|:---------:|:------:|
|   1M    |       2574        |   3136    | 17,93% |
|   10M   |       13673       |   27696   | 50,64% |
|   20M   |       27045       |   54883   | 50,73% |
|   30M   |       40558       |   82027   | 50,56% |