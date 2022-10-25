# Task library

This is a Task library where you submit tasks to your own pool of threads.
It is really fast and thread safe.

The `ThreadPool` class is responsible to manage the tasks, it is possible to specify the max of simultaneous execution.

When pool is instantiated, it will create all threads at once based on the maxSimultaneous parameter.
The threads will be looking for tasks to execute.

## Compiling and Running

```
mvn clean install
```


## Code sample

This sample is creating a TaskPool and the max simultaneous tasks is 10, the other tasks will be queued.

```kotlin
val threadPool = ThreadPool(10)

for (i in 1..1000) {
    threadPool.addTask(DelayTask("delay-task-$i", 4000))
}

taskPool.waitToFinish()
```


