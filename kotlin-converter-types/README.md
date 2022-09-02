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
val person = Person("Inacio", 38)
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

