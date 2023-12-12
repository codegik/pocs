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

## 8. Client Side

### Pro

- Less latency: the client can directly invoke the backend servers removing an extra hop for the load balancer.
- Reduce costs: no need server-side load balancer.

### Cons

- Server overload: the client is not aware of the server resources.


## 9. Server Side

### Pros

- Server awareness: it could obtain server resource awareness to distribute the work properly.
- no latency penalty to the client
- unique destination for many clients

### Cons

## 10. Prefix Sum

### Pros

- By dividing the tasks in such a way as to give the same amount of computation to each processor

### Cons

- Only works for tasks can be subdivided
- Most of the time, the execution time of a task is unknown and only rough approximations are available, so is not viable for these scenarios.

## 11. Master-Worker

### Pros

- it distributes the burden very fairly.

### Cons

- it has difficulty adapting to a large number of processors because of the high amount of necessary communications
- lack of scalability makes it quickly inoperable in very large servers or very large parallel computers

## 12. IP Hash

### Pros

- Allows dropped connections be returned to the same server originally handling it.

### Cons

- The re-hashing could unecessary move active connections to other server due weight change event cousing low performance.

## 13. Consistent Hashing

### Pros

- The re-hashing doesn't move active connections to other server.

### Cons

- Skewed Load when add/remove server.

## 14. Resource-based / Custom metrics

### Pros

### Cons
