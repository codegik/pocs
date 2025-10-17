# Monitoring Netty Event Loop Metrics

This guide explains how to monitor Netty event loop metrics using Prometheus and Grafana.

## Setup

### 1. Start the Spring Boot Application

```bash
mvn spring-boot:run
```

The application exposes Prometheus metrics at: `http://localhost:8080/actuator/prometheus`

### 2. Start Prometheus and Grafana

```bash
docker-compose up -d
```

This will start:
- Prometheus on `http://localhost:9090`
- Grafana on `http://localhost:3000`

### 3. Access Grafana

1. Open `http://localhost:3000` in your browser
2. Login with credentials:
   - Username: `admin`
   - Password: `admin`
3. The Netty Event Loop Metrics dashboard is automatically provisioned

## Testing Event Loop Blocking

### Test Normal Operations

```bash
curl http://localhost:8080/api/users
```

Event loop pending tasks should be 0.

### Test Blocking Operations

Run multiple concurrent blocking requests:

```bash
for i in {1..10}; do curl http://localhost:8080/api/block & done
```

Watch the Grafana dashboard - you'll see:
- Event loop pending tasks increasing
- Connections increasing
- Response times degrading

## Metrics Exposed

- `reactor_netty_eventloop_pending_tasks` - Number of pending tasks in event loop (should be 0 or very low)
- `reactor_netty_connections_total` - Total active connections
- `reactor_netty_bytebuf_allocator_used_heap_memory` - Heap memory used by ByteBuf allocator
- `reactor_netty_bytebuf_allocator_used_direct_memory` - Direct memory used by ByteBuf allocator
- `reactor_netty_data_received_total` - Total bytes received
- `reactor_netty_data_sent_total` - Total bytes sent

## Stopping

```bash
docker-compose down
```

To remove volumes:

```bash
docker-compose down -v
```
