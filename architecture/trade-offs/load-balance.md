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

- The request assignment is deterministic and it is easy to determine the assigned server.

### Cons

- Overloaded servers due expensive service time or when each request have different service time.

## 5. Weighted response time

### Pros

- Server average response time awareness to reduce the response time in scenarios where response time is the most important thing.

### Cons

- Considering only response time average could overload servers.

## 6. Randomized static

### Pros

- Don't need for a distribution master because every processor knows what task is assigned to it.

### Cons

- The performance of this strategy (measured in total execution time for a given fixed set of tasks) decreases with the maximum size of the tasks.

## 7. Work stealing

### Pros

- Reduce the idle time of workers since each worker can steal subtask from others.
- Reduce overload of workers due well adapt to dynamic and irregular worloads.

### Cons

- Could introduce non-determinism and unpredictability since the subtast execution depends of the availability. The algorithm can produce differente results for each run making harder to debugging and test.

## 8. Client Side

### Pro

- tends to enjoy greater throughput than server-side load balancing.

### Cons

- Client-side load balancing tends to suffer worse latency than server-side load balancing.
- The client may have to wait for a timeout before it tries another server.

## 9. Server Side

### Pros

- it could obtain server availability much faster.
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
