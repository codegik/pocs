// Configuration
const API_BASE_URL = 'http://localhost:3000';
const WS_URL = 'ws://localhost:3000';

// State variables
let httpTestResults = [];
let wsTestResults = [];
let httpTestInProgress = false;
let wsTestInProgress = false;
let webSocket = null;
let httpTestStartTime = 0;
let wsTestStartTime = 0;
let durationChart = null;
let distributionChart = null;

// DOM Elements
document.addEventListener('DOMContentLoaded', () => {
    // Tab switching
    const tabButtons = document.querySelectorAll('.tab-btn');
    const tabPanes = document.querySelectorAll('.tab-pane');

    tabButtons.forEach(button => {
        button.addEventListener('click', () => {
            // Remove active class from all buttons and panes
            tabButtons.forEach(btn => btn.classList.remove('active'));
            tabPanes.forEach(pane => pane.classList.remove('active'));

            // Add active class to clicked button and corresponding pane
            button.classList.add('active');
            document.getElementById(button.dataset.tab).classList.add('active');
        });
    });

    // Button event listeners
    document.getElementById('start-http-test').addEventListener('click', startHttpTest);
    document.getElementById('start-ws-test').addEventListener('click', startWebSocketTest);
    document.getElementById('start-both-tests').addEventListener('click', startBothTests);
    document.getElementById('reset-metrics').addEventListener('click', resetMetrics);

    // Initialize charts
    initializeCharts();

    // Fetch initial comparison data
    fetchComparisonData();
});

// Initialize Charts
function initializeCharts() {
    const durationCtx = document.getElementById('duration-comparison-chart').getContext('2d');
    durationChart = new Chart(durationCtx, {
        type: 'bar',
        data: {
            labels: ['HTTP', 'WebSocket'],
            datasets: [{
                label: 'Average Request Duration (ms)',
                data: [0, 0],
                backgroundColor: ['rgba(52, 152, 219, 0.6)', 'rgba(46, 204, 113, 0.6)'],
                borderColor: ['rgba(52, 152, 219, 1)', 'rgba(46, 204, 113, 1)'],
                borderWidth: 1
            }]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,
            scales: {
                y: {
                    beginAtZero: true,
                    title: {
                        display: true,
                        text: 'Duration (ms)'
                    }
                }
            }
        }
    });

    const distCtx = document.getElementById('request-distribution-chart').getContext('2d');
    distributionChart = new Chart(distCtx, {
        type: 'line',
        data: {
            labels: [],
            datasets: [
                {
                    label: 'HTTP Requests',
                    data: [],
                    borderColor: 'rgba(52, 152, 219, 1)',
                    backgroundColor: 'rgba(52, 152, 219, 0.1)',
                    borderWidth: 2,
                    fill: true,
                    tension: 0.1
                },
                {
                    label: 'WebSocket Requests',
                    data: [],
                    borderColor: 'rgba(46, 204, 113, 1)',
                    backgroundColor: 'rgba(46, 204, 113, 0.1)',
                    borderWidth: 2,
                    fill: true,
                    tension: 0.1
                }
            ]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,
            scales: {
                y: {
                    beginAtZero: true,
                    title: {
                        display: true,
                        text: 'Duration (ms)'
                    }
                },
                x: {
                    title: {
                        display: true,
                        text: 'Request #'
                    }
                }
            }
        }
    });
}

// Generate random payload of given size
function generateRandomPayload(size) {
    const characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    let result = '';
    const charactersLength = characters.length;

    for (let i = 0; i < size; i++) {
        result += characters.charAt(Math.floor(Math.random() * charactersLength));
    }

    return result;
}

// Update status message
function updateStatus(message) {
    document.getElementById('status-message').textContent = message;
}

// Update progress bar
function updateProgressBar(type, percent) {
    const progressBar = document.getElementById(`${type}-progress-bar`);
    const progressText = document.getElementById(`${type}-progress-text`);

    progressBar.style.width = `${percent}%`;
    progressText.textContent = `${Math.round(percent)}%`;
}

// HTTP Test
async function startHttpTest() {
    if (httpTestInProgress || wsTestInProgress) {
        alert('A test is already in progress. Please wait.');
        return;
    }

    // Reset HTTP test results
    httpTestResults = [];
    httpTestInProgress = true;
    httpTestStartTime = performance.now();

    // Get test parameters
    const numRequests = parseInt(document.getElementById('num-requests').value);
    const payloadSize = parseInt(document.getElementById('payload-size').value);
    const concurrentRequests = parseInt(document.getElementById('concurrent-requests').value);

    // Clear previous results
    document.getElementById('http-details-table').querySelector('tbody').innerHTML = '';
    updateProgressBar('http', 0);

    updateStatus(`Starting HTTP test with ${numRequests} requests, ${payloadSize} bytes payload, ${concurrentRequests} concurrent requests`);

    // Generate payload
    const payload = { data: generateRandomPayload(payloadSize) };

    // Track completed requests
    let completedRequests = 0;

    // Function to send a single HTTP request
    async function sendHttpRequest(index) {
        try {
            const startTime = performance.now();

            const response = await fetch(`${API_BASE_URL}/api/echo`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(payload)
            });

            await response.json();

            const endTime = performance.now();
            const duration = endTime - startTime;

            // Record result
            const result = {
                index: index,
                timestamp: new Date().toISOString(),
                duration: duration,
                payloadSize: payloadSize
            };

            httpTestResults.push(result);

            // Update table
            const tbody = document.getElementById('http-details-table').querySelector('tbody');
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${index + 1}</td>
                <td>${result.timestamp}</td>
                <td>${result.duration.toFixed(2)}</td>
                <td>${result.payloadSize}</td>
            `;
            tbody.appendChild(row);

            // Update progress
            completedRequests++;
            const progressPercent = (completedRequests / numRequests) * 100;
            updateProgressBar('http', progressPercent);

            if (completedRequests === numRequests) {
                const totalTime = performance.now() - httpTestStartTime;
                httpTestInProgress = false;
                updateStatus(`HTTP test completed in ${totalTime.toFixed(2)} ms`);

                // Update summary and charts
                updateHttpSummary();
                updateCharts();
            }
        } catch (error) {
            console.error('HTTP request error:', error);
            completedRequests++;
            const progressPercent = (completedRequests / numRequests) * 100;
            updateProgressBar('http', progressPercent);
        }
    }

    // Process requests in batches based on concurrency
    for (let i = 0; i < numRequests; i += concurrentRequests) {
        const batch = [];
        for (let j = 0; j < concurrentRequests && i + j < numRequests; j++) {
            batch.push(sendHttpRequest(i + j));
        }
        await Promise.all(batch);
    }
}

// WebSocket Test
async function startWebSocketTest() {
    if (httpTestInProgress || wsTestInProgress) {
        alert('A test is already in progress. Please wait.');
        return;
    }

    // Reset WebSocket test results
    wsTestResults = [];
    wsTestInProgress = true;
    wsTestStartTime = performance.now();

    // Get test parameters
    const numRequests = parseInt(document.getElementById('num-requests').value);
    const payloadSize = parseInt(document.getElementById('payload-size').value);
    const concurrentRequests = parseInt(document.getElementById('concurrent-requests').value);

    // Clear previous results
    document.getElementById('ws-details-table').querySelector('tbody').innerHTML = '';
    updateProgressBar('ws', 0);

    updateStatus(`Starting WebSocket test with ${numRequests} requests, ${payloadSize} bytes payload`);

    // Generate payload
    const payload = generateRandomPayload(payloadSize);

    // Connect to WebSocket server
    return new Promise((resolve) => {
        webSocket = new WebSocket(WS_URL);

        // Track completed requests and timestamps
        let completedRequests = 0;
        const requestTimestamps = {};

        webSocket.onopen = async () => {
            updateStatus('WebSocket connected, starting test...');

            // Set up message handler
            webSocket.onmessage = (event) => {
                const data = event.data;
                const endTime = performance.now();

                // Make sure data is treated as a string
                const dataStr = data.toString();

                // Try to find the matching request timestamp
                const index = parseInt(dataStr.substring(0, dataStr.indexOf(':')));
                const startTime = requestTimestamps[index];

                if (startTime) {
                    const duration = endTime - startTime;

                    // Record result
                    const result = {
                        index: index,
                        timestamp: new Date().toISOString(),
                        duration: duration,
                        payloadSize: payloadSize
                    };

                    wsTestResults.push(result);

                    // Update table
                    const tbody = document.getElementById('ws-details-table').querySelector('tbody');
                    const row = document.createElement('tr');
                    row.innerHTML = `
                        <td>${index + 1}</td>
                        <td>${result.timestamp}</td>
                        <td>${result.duration.toFixed(2)}</td>
                        <td>${result.payloadSize}</td>
                    `;
                    tbody.appendChild(row);

                    // Update progress
                    completedRequests++;
                    const progressPercent = (completedRequests / numRequests) * 100;
                    updateProgressBar('ws', progressPercent);

                    // Delete the timestamp as we've used it
                    delete requestTimestamps[index];

                    if (completedRequests === numRequests) {
                        const totalTime = performance.now() - wsTestStartTime;
                        wsTestInProgress = false;
                        updateStatus(`WebSocket test completed in ${totalTime.toFixed(2)} ms`);

                        // Close WebSocket
                        webSocket.close();

                        // Update summary and charts
                        updateWsSummary();
                        updateCharts();
                        updateComparisonSummary();
                        resolve();
                    }
                }
            };

            // Process requests in batches based on concurrency
            for (let i = 0; i < numRequests; i += concurrentRequests) {
                const batchSize = Math.min(concurrentRequests, numRequests - i);

                for (let j = 0; j < batchSize; j++) {
                    const index = i + j;
                    const prefixedPayload = `${index}:${payload}`;
                    requestTimestamps[index] = performance.now();
                    webSocket.send(prefixedPayload);
                }

                // Small delay between batches to avoid overwhelming the WebSocket
                if (i + batchSize < numRequests) {
                    await new Promise(r => setTimeout(r, 10));
                }
            }
        };

        webSocket.onerror = (error) => {
            console.error('WebSocket error:', error);
            wsTestInProgress = false;
            updateStatus('WebSocket test failed');
            resolve();
        };

        webSocket.onclose = () => {
            if (wsTestInProgress) {
                wsTestInProgress = false;
                updateStatus('WebSocket connection closed unexpectedly');
                resolve();
            }
        };
    });
}

// Run both tests sequentially
async function startBothTests() {
    // Switch to Summary tab
    document.querySelectorAll('.tab-btn').forEach(btn => btn.classList.remove('active'));
    document.querySelectorAll('.tab-pane').forEach(pane => pane.classList.remove('active'));
    document.querySelector('.tab-btn[data-tab="summary"]').classList.add('active');
    document.getElementById('summary').classList.add('active');

    updateStatus('Running HTTP test first, then WebSocket test...');

    // Run HTTP test
    await startHttpTest();

    // Small delay between tests
    await new Promise(r => setTimeout(r, 1000));

    // Run WebSocket test
    await startWebSocketTest();

    // Update comparison summary
    updateComparisonSummary();

    updateStatus('Benchmark completed! View results in the tabs above.');
}

// Update HTTP Summary
function updateHttpSummary() {
    if (httpTestResults.length === 0) return;

    const durations = httpTestResults.map(r => r.duration);
    const avgDuration = durations.reduce((sum, val) => sum + val, 0) / durations.length;
    const minDuration = Math.min(...durations);
    const maxDuration = Math.max(...durations);

    document.getElementById('http-total-requests').textContent = httpTestResults.length;
    document.getElementById('http-avg-duration').textContent = `${avgDuration.toFixed(2)} ms`;
    document.getElementById('http-min-duration').textContent = `${minDuration.toFixed(2)} ms`;
    document.getElementById('http-max-duration').textContent = `${maxDuration.toFixed(2)} ms`;
}

// Update WebSocket Summary
function updateWsSummary() {
    if (wsTestResults.length === 0) return;

    const durations = wsTestResults.map(r => r.duration);
    const avgDuration = durations.reduce((sum, val) => sum + val, 0) / durations.length;
    const minDuration = Math.min(...durations);
    const maxDuration = Math.max(...durations);

    document.getElementById('ws-total-requests').textContent = wsTestResults.length;
    document.getElementById('ws-avg-duration').textContent = `${avgDuration.toFixed(2)} ms`;
    document.getElementById('ws-min-duration').textContent = `${minDuration.toFixed(2)} ms`;
    document.getElementById('ws-max-duration').textContent = `${maxDuration.toFixed(2)} ms`;
}

// Update Comparison Summary
function updateComparisonSummary() {
    if (httpTestResults.length === 0 || wsTestResults.length === 0) return;

    const httpAvgDuration = httpTestResults.reduce((sum, r) => sum + r.duration, 0) / httpTestResults.length;
    const wsAvgDuration = wsTestResults.reduce((sum, r) => sum + r.duration, 0) / wsTestResults.length;

    const diff = httpAvgDuration - wsAvgDuration;
    const percentImprovement = (diff / httpAvgDuration) * 100;

    document.getElementById('performance-diff').textContent = `${Math.abs(diff).toFixed(2)} ms`;

    if (diff > 0) {
        document.getElementById('faster-protocol').textContent = 'WebSocket';
        document.getElementById('speed-improvement').textContent = `${percentImprovement.toFixed(2)}% faster`;
    } else if (diff < 0) {
        document.getElementById('faster-protocol').textContent = 'HTTP';
        document.getElementById('speed-improvement').textContent = `${Math.abs(percentImprovement).toFixed(2)}% faster`;
    } else {
        document.getElementById('faster-protocol').textContent = 'Equal';
        document.getElementById('speed-improvement').textContent = '0% (no difference)';
    }
}

// Update Charts
function updateCharts() {
    // Update Duration Comparison Chart
    if (httpTestResults.length > 0 && wsTestResults.length > 0) {
        const httpAvgDuration = httpTestResults.reduce((sum, r) => sum + r.duration, 0) / httpTestResults.length;
        const wsAvgDuration = wsTestResults.reduce((sum, r) => sum + r.duration, 0) / wsTestResults.length;

        durationChart.data.datasets[0].data = [httpAvgDuration, wsAvgDuration];
        durationChart.update();
    }

    // Update Request Distribution Chart
    if (httpTestResults.length > 0 || wsTestResults.length > 0) {
        const maxLength = Math.max(httpTestResults.length, wsTestResults.length);
        const labels = Array.from({ length: maxLength }, (_, i) => i + 1);

        const httpData = httpTestResults.map(r => r.duration);
        const wsData = wsTestResults.map(r => r.duration);

        distributionChart.data.labels = labels;
        distributionChart.data.datasets[0].data = httpData;
        distributionChart.data.datasets[1].data = wsData;
        distributionChart.update();
    }
}

// Fetch comparison data from the server
async function fetchComparisonData() {
    try {
        const response = await fetch(`${API_BASE_URL}/api/comparison`);
        const data = await response.json();

        // Update HTTP metrics if available
        if (data.http && data.http.metrics.length > 0) {
            httpTestResults = data.http.metrics.map((m, i) => ({
                index: i,
                timestamp: m.timestamp,
                duration: m.duration,
                payloadSize: m.payload
            }));

            // Update HTTP table
            const tbody = document.getElementById('http-details-table').querySelector('tbody');
            tbody.innerHTML = '';

            httpTestResults.forEach((result, i) => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${i + 1}</td>
                    <td>${result.timestamp}</td>
                    <td>${result.duration.toFixed(2)}</td>
                    <td>${result.payloadSize}</td>
                `;
                tbody.appendChild(row);
            });

            updateHttpSummary();
        }

        // Update WebSocket metrics if available
        if (data.websocket && data.websocket.metrics.length > 0) {
            wsTestResults = data.websocket.metrics.map((m, i) => ({
                index: i,
                timestamp: m.timestamp,
                duration: m.duration,
                payloadSize: m.payload
            }));

            // Update WS table
            const tbody = document.getElementById('ws-details-table').querySelector('tbody');
            tbody.innerHTML = '';

            wsTestResults.forEach((result, i) => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${i + 1}</td>
                    <td>${result.timestamp}</td>
                    <td>${result.duration.toFixed(2)}</td>
                    <td>${result.payloadSize}</td>
                `;
                tbody.appendChild(row);
            });

            updateWsSummary();
        }

        // Update comparison if both have data
        if (data.http.metrics.length > 0 && data.websocket.metrics.length > 0) {
            updateComparisonSummary();
        }

        // Update charts
        updateCharts();

    } catch (error) {
        console.error('Error fetching comparison data:', error);
    }
}

// Reset metrics
async function resetMetrics() {
    try {
        const response = await fetch(`${API_BASE_URL}/api/reset`, {
            method: 'POST'
        });

        await response.json();

        // Clear local results
        httpTestResults = [];
        wsTestResults = [];

        // Update UI
        document.getElementById('http-details-table').querySelector('tbody').innerHTML = '';
        document.getElementById('ws-details-table').querySelector('tbody').innerHTML = '';

        document.getElementById('http-total-requests').textContent = '0';
        document.getElementById('http-avg-duration').textContent = '0 ms';
        document.getElementById('http-min-duration').textContent = '0 ms';
        document.getElementById('http-max-duration').textContent = '0 ms';

        document.getElementById('ws-total-requests').textContent = '0';
        document.getElementById('ws-avg-duration').textContent = '0 ms';
        document.getElementById('ws-min-duration').textContent = '0 ms';
        document.getElementById('ws-max-duration').textContent = '0 ms';

        document.getElementById('performance-diff').textContent = '-';
        document.getElementById('faster-protocol').textContent = '-';
        document.getElementById('speed-improvement').textContent = '-';

        // Reset progress bars
        updateProgressBar('http', 0);
        updateProgressBar('ws', 0);

        // Reset charts
        durationChart.data.datasets[0].data = [0, 0];
        durationChart.update();

        distributionChart.data.labels = [];
        distributionChart.data.datasets[0].data = [];
        distributionChart.data.datasets[1].data = [];
        distributionChart.update();

        updateStatus('Metrics reset successfully');
    } catch (error) {
        console.error('Error resetting metrics:', error);
        updateStatus('Failed to reset metrics');
    }
}
