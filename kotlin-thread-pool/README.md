# Task library

This is a Task library where you submit tasks to your own pool of threads.
It is really fast and thread safe.

The `TaskPool` class is responsible to manage the tasks, it is possible to specify the max of simultaneous execution.

Adding new Task into the pool, they will start running automatically.

## Project Structure

- Folder `task-manager` is the task library.
- Folder `client` is sample client using the library.

## Compiling and Running

```
cd task-manager
mvn clean install

cd ../client
mvn clean install

java -jar target/kotlin-task-manager-client-0.0.1-SNAPSHOT-jar-with-dependencies.jar
```

Sample output

```log
Started task delay-task-1
Added task delay-task-1
Added task delay-task-2
Started task delay-task-2
Added task delay-task-3
Started task delay-task-3
Queued task delay-task-4
Queued task delay-task-5
Queued task delay-task-6
Queued task delay-task-7
Queued task delay-task-8
Queued task delay-task-9
Queued task delay-task-10
Finished task delay-task-1
Finished task delay-task-3
Finished task delay-task-2
Started task delay-task-4
Started task delay-task-5
Started task delay-task-6
Finished task delay-task-4
Finished task delay-task-5
Started task delay-task-7
Started task delay-task-8
Finished task delay-task-6
Started task delay-task-9
Finished task delay-task-7
Finished task delay-task-8
Started task delay-task-10
Finished task delay-task-9
Finished task delay-task-10
```

## Code sample

This sample is creating a TaskPool named as "custom-task-manager" and the max simultaneous tasks is 3, the other tasks will be queued.

```kotlin
val taskPool = TaskPool("custom-task-manager", 3)

for (i in 1..10) {
    taskPool.add(DelayTask(name = "delay-task-$i", 4000))
}

taskPool.waitToFinish()
```


