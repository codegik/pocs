const express = require('express');
const http = require('http');
const WebSocket = require('ws');
const cors = require('cors');
const promClient = require('prom-client');

// Create Express app
const app = express();
app.use(express.json());
app.use(cors());

// Create HTTP server
const server = http.createServer(app);

// Create WebSocket server
const wss = new WebSocket.Server({ server });

// Initialize Prometheus metrics
const register = new promClient.Registry();
promClient.collectDefaultMetrics({ register });

// Custom metrics
const httpRequestDurationHistogram = new promClient.Histogram({
  name: 'http_request_duration_ms',
  help: 'Duration of HTTP requests in ms',
  buckets: [1, 5, 15, 50, 100, 200, 500, 1000, 2000],
  registers: [register]
});

const wsRequestDurationHistogram = new promClient.Histogram({
  name: 'ws_request_duration_ms',
  help: 'Duration of WebSocket requests in ms',
  buckets: [1, 5, 15, 50, 100, 200, 500, 1000, 2000],
  registers: [register]
});

// Store metrics for comparison
let httpMetrics = [];
let wsMetrics = [];

// HTTP REST endpoint
app.post('/api/echo', (req, res) => {
  const start = performance.now();

  // Echo back the request body
  const data = req.body;

  const duration = performance.now() - start;
  httpRequestDurationHistogram.observe(duration);

  // Store metrics for this request
  httpMetrics.push({
    timestamp: new Date().toISOString(),
    duration: duration,
    payload: JSON.stringify(data).length
  });

  res.json(data);
});

// WebSocket connection handler
wss.on('connection', (ws) => {
  console.log('WebSocket client connected');

  ws.on('message', (message) => {
    const start = performance.now();

    // Echo back the message
    ws.send(message);

    const duration = performance.now() - start;
    wsRequestDurationHistogram.observe(duration);

    // Store metrics for this request
    wsMetrics.push({
      timestamp: new Date().toISOString(),
      duration: duration,
      payload: message.length
    });
    console.log(`Received message: ${message.id}, Duration: ${duration}ms`);
  });

  ws.on('close', () => {
    console.log('WebSocket client disconnected');
  });
});

// Endpoint to get performance metrics
app.get('/metrics', async (req, res) => {
  res.set('Content-Type', register.contentType);
  res.end(await register.metrics());
});

// Endpoint to get comparison data
app.get('/api/comparison', (req, res) => {
  // Calculate averages and other statistics
  const httpAvg = httpMetrics.length > 0
    ? httpMetrics.reduce((sum, item) => sum + item.duration, 0) / httpMetrics.length
    : 0;

  const wsAvg = wsMetrics.length > 0
    ? wsMetrics.reduce((sum, item) => sum + item.duration, 0) / wsMetrics.length
    : 0;

  // Return comparison data
  res.json({
    http: {
      totalRequests: httpMetrics.length,
      averageDuration: httpAvg,
      metrics: httpMetrics.slice(-100) // Return last 100 metrics only
    },
    websocket: {
      totalRequests: wsMetrics.length,
      averageDuration: wsAvg,
      metrics: wsMetrics.slice(-100) // Return last 100 metrics only
    }
  });
});

// Reset metrics endpoint
app.post('/api/reset', (req, res) => {
  httpMetrics = [];
  wsMetrics = [];
  res.json({ status: 'Metrics reset successfully' });
});

// Start the server
const PORT = process.env.PORT || 3000;
server.listen(PORT, () => {
  console.log(`Server running on port ${PORT}`);
  console.log(`HTTP endpoint: http://localhost:${PORT}/api/echo`);
  console.log(`WebSocket endpoint: ws://localhost:${PORT}`);
  console.log(`Metrics endpoint: http://localhost:${PORT}/metrics`);
  console.log(`Comparison endpoint: http://localhost:${PORT}/api/comparison`);
});
