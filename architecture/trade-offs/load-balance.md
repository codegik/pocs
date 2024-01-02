# Load Balancers

## 1. Round-robin

### Cons

- cannot be depended upon for site reliability; if one of the servers goes down,
  the DNS server will still keep that server's IP in the round-robin rotation. (revalidate)
- Overload resources. The algorithm assumes that servers are similar enough to handle equivalent loads.

### Pros

- easy to implement
- zero overhead beside hotspot

## 2. Least-connected

### Pros

- Improve the balancing due load awareness.

### Cons

- Overloaded servers due hotspot.

## 3. Least-load / Resource-based

### Pros

- Availability, costs and less. Server resources (cpu, mem, load, etc) awareness to improve the balancing.

### Cons

- Response time, timeout, less availability. It might overload servers that are not providing health information due agent failures.

## 4. Weighted round robin

### Pros

- Performance: Most request assignment could be influentiated to determine the assigned server.

### Cons

- Performance: long running requests could overload servers with less weigh.

## 5. Weighted response time

### Pros

- Performance: Server average response time awareness where response time is the most important thing.

### Cons

- Overload servers: its considering only response time average.

## 6. Randomized static

### Pros

- Avoid communication costs: don't need for a distribution master because every is assigned randomly.

### Cons

- Decrease performance and server overload: its not considering server resources to distribute a task.


## 7. Work stealing

### Pros

- Scalability
  - Reduce the idle time of workers: each worker can steal subtask from others.
- Performance
    - Reduce overload of workers: well adaptation to dynamic and irregular worloads.

### Cons

- Complexity
  - Introducing non-determinism and Unpredictability: the task execution depends of the availability. The algorithm can produce differente results for each run making harder to debugging and test.


## 8. Prefix Sum

### Pros

- Performance: When have static distribution with full knowledge of the tasks.

### Cons

- Only works for tasks can be subdivided
- Most of the time, the execution time of a task is unknown and only rough approximations are available, so is not viable for these scenarios.


## 9. IP Hash

### Pros

- Latency: Allows dropped connections be returned to the same server originally handling it.

### Cons

- Low Performance: uneven distribution in hotspot scenario.

## 10. Consistent Hashing

### Pros

- Scalability: proper distribution of workload when adding new servers.

### Cons

- Performance: server overload due uneven distribution of requests.

## 11. Resource-based / Custom metrics

### Pros

- Performance: even distribution of requests based on server resource availability.

### Cons

- Traffic overload: needs to request metrics very often to analise and take a decision.


