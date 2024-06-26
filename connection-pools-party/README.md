# Connection Pool Party

This POC was inspired on this other analyses [https://github.com/diegopacheco/java-pocs/tree/master/pocs/connection-pools-party](https://github.com/diegopacheco/java-pocs/tree/master/pocs/connection-pools-party).

## Requirements
- Java 21
- Docker

Make sure you have mysql running before testing.
```shell
./run-mysql-5.7-docker.sh
```

## 3CP0 Notes

Run class `ApplicationC3po`

Refresh method `ds.softReset("root","pass");`

### Behavior
- Refresh DB connection using same user and password is working fine.
- Refresh DB connection with incorrect user and password is throwing exception during refresh operation.
  - The pool will not be invalidated.
  - We still able to open new connections because C3PO will use previous user and password.
- We can change the URI at runtime.

### Source code
- There are too much reflection usage, and I didn't see any kind of cache, we all know reflections cost is very high for JVM.
- Very well documented in most cases, they are providing good information about the use cases.
- There is one external dependency mchange-commons-java.
  - There are a lot of commented code in this dependency like this `//setter.invoke( destBean, new Object[] { value } );`
- C3PO also have commented code, please see `C3P0PooledConnectionPoolManager`.
- There are many inline classes been defined inside methods.

## Hikari Notes

Run class `ApplicationHikari`

Refresh method `ds.getHikariPoolMXBean().softEvictConnections();`

### Behavior
- Refresh DB connection using same user and password is working fine.
- Refresh DB connection with incorrect user and password is not throwing exception during refresh operation.
  - The pool will be invalidated.
  - Every new connection will fail due invalid credentials.
- We cannot change the URI at runtime.

### Source code
- Its creating connection class at runtime, this increase the security and isolation, but makes harder to debug and understand the logic.
- Very well documented, they are explicit explaining the class responsibility.
- There is only one dependency slf4j that is widely used in java applications.


## DBCP2 Notes

Run class `ApplicationDBCP2`

Refresh method `((DBConfiguration.PoolingDataSourceExt) ds).getPool().evict();`

### Behavior
- Refresh DB connection using same user and password is working fine.
- Refresh DB connection with incorrect user and password is not throwing exception during refresh operation.
  - The pool will be invalidated.
  - Every new connection will fail due invalid credentials.
- We cannot change the URI at runtime.

### Source code
- Its too complex solution.
- There are volatile variables, synchronized objects and lock statements.
- Too much abstraction and delegation.
- There is no easy way to update user/password at runtime, its necessary to dig into the structure to do it.
- Code documentation is not so good.
  - There are corner cases within this kind of comment `// not sure what the state is, so assume the connection is open.`.
- There are two external dependencies commons-pool2 and jakarta.transaction-api.


## Summary

If I need to choose one of them to use in my projects, here is the order of preference:
- Hikari
- C3PO
- DBCP2