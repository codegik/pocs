# Load Balancers

## Round-robin

### Cons

- cannot be depended upon for site reliability; if one of the servers goes down,
  the DNS server will still keep that server's IP in the round-robin rotation. (revalidate)
- Overload resources. The algorithm assumes that servers are similar enough to handle equivalent loads.

### Pros

- easy to implement
- zero overhead beside hotspot

## Least-connected

### Pros

- Improve the balancing due load awareness.

### Cons

- Overloaded servers due hotspot.

## Least-load / Resource-based

### Pros

- Availability, costs and less. Server resources (cpu, mem, load, etc) awareness to improve the balancing.

### Cons

- Response time, timeout, less availability. It might overload servers that are not providing health information due agent failures.

## Weighted round robin

### Pros

-
- Server capacity awareness to improve the balancing.

### Cons

- Overloaded servers due long lived connections.

## Weighted response time

### Pros

- Server capacity awareness to improve the balancing.

### Cons

-

## Randomized static

### Pros

- Don't need for a distribution master because every processor knows what task is assigned to it.

### Cons

- The performance of this strategy (measured in total execution time for a given fixed set of tasks) decreases with the maximum size of the tasks.

Work stealing

## Client Side

### Cons

- Client-side load balancing tends to suffer worse latency than server-side load balancing.
- The client may have to wait for a timeout before it tries another server.
-

### Pro

- tends to enjoy greater throughput than server-side load balancing.

## Server Side

### Cons

### Pros

- it could obtain server availability much faster.
- no latency penalty to the client
- unique destination for many clients

## Prefix Sum

### Cons

- Only works for tasks can be subdivided
- Most of the time, the execution time of a task is unknown and only rough approximations are available, so is not viable for these scenarios.

### Pros

- By dividing the tasks in such a way as to give the same amount of computation to each processor

## Master-Worker

### Pros

- it distributes the burden very fairly.

### Cons

- it has difficulty adapting to a large number of processors because of the high amount of necessary communications
- lack of scalability makes it quickly inoperable in very large servers or very large parallel computers

## Work stealing

### Pros

### Cons

## IP hash

### Pros

### Cons

## Consistent Hashing

### Pros

### Cons

## Resource-based / Custom metrics

### Pros

### Cons
