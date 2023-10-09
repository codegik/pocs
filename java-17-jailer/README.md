# Jail Joke Challenge - Java 17

- A jail has a number of prisoners and a number of treats to pass out to them. Their jailer decides the fairest way to divide the treats is to seat the prisoners around a circular table in sequentially numbered chairs. A chair number will be drawn from a hat.
- Beginning with the prisoner in that chair, one candy will be handed to each prisoner sequentially around the table until all have been distributed.
- The jailer is playing a little joke, though. The last piece of candy looks like all the others, but it tastes awful.
- Determine the chair number occupied by the prisoner who will receive that candy.
- Create a function that should return an integer representing the chair number of the prisoner to warn.

## Requirements

- Java 17
- Gradle 7

## Example input

```
prisoners = 7
candyPieces = 19
startAt = 2
```

## Example output

```
6
```

# Running

```
./gradlew clean build
```
