# 🧬 Architecture overview

# 🏛️ Structure

## 1 🎯 Problem Statement and Context

Latency Afficionados is a RETRO video game marketplace where users can sell RETRO video games and users can also buy such video games.

The platform is capable of:

- posting products
- search products
- view product descriptions
- rating products with review
- comments
- provide recommendation of products to users based on previews browsing
- sell/buy video games



### 1.1 Problem space
<br/>Latency is a key concern for the CTO.


#### 1.1.1 First Problem
<br/>The UI must be fast and the current React 16 implementation is not meeting the performance requirements.
<br/>The goal is to find ways to speed up the rendering process and ensure that the UI is fast at all times.
<br/>Could we upgrade and tune React to be faster enough?
<br/>Could we use different technology to improve the performance of the UI?

**Option 1:**
<br/>
<br/>Upgrade React to the latest version and use React Hooks to improve the performance of the UI.

**Option 2:**
<br/>
<br/>Use a different technology like Svelte to improve the performance of the UI.
<br/>Svelte is a new technology that compiles the code to vanilla JavaScript at build time,
<br/>which means that there is no need for a virtual DOM and the code is faster to execute.
<br/>Here is an performance comparison between React and Svelte:
<br/>
![](react-vs-svelte.png)

<br/>Svelte excels in terms of bundle size, initial load time, render time, memory usage, and CPU usage due to its
<br/>compile-time optimizations and lack of virtual DOM.
<br/>
<br/>React offers a more mature ecosystem with a wide range of libraries, third-party tools, and a larger community,
<br/>making it ideal for complex, large-scale applications.
<br/>

**Websockets**
<br/>Websockets are faster than traditional http protocol, here are the advantages:
<br/>Persistent connection: Once established, the connection remains open, reducing overhead for subsequent messages.
<br/>Full-duplex communication: Allows simultaneous two-way communication between client and server.
<br/>Lower latency: After the initial handshake, data can be sent immediately without additional HTTP headers.
<br/>Reduced server load: Fewer connections need to be opened and closed repeatedly.
<br/>Real-time updates: Ideal for live data, chat applications, gaming, etc.
<br/>Less data transfer: Smaller message sizes due to reduced header information.

#### 1.1.2 Second Problem
<br/>The monolith is very old and needs to be migrated to Java Latest Stable.
<br/>The monolith should be decomposed into smaller, more manageable services to improve maintainability and performance.
<br/>Could use gradual migration strategy. First, could use tools to assist the migration like AI or OpenRewrite. Second, 
<br/>start decomposing the monolith into microservices.
<br/>Here is a decomposition propose:
- Product Service: Handles product listing, details, and search
- User Service: Manages user accounts and authentication
- Review Service: Handles product ratings and reviews
- Recommendation Service: Provides product recommendations
- Order Service: Manages the buying and selling process
- Comment Service: Handles user comments on products


## 2. 🎯 Goals
- Improve UI Performance
- Migrate and Modernize the Backend
- Enhance User Experience
- Maintain Scalability and Observability

## 3. 🎯 Non-Goals
- Support for Legacy Browsers
- Backward Compatibility with Java 1.4
- Custom Hardware Optimization


## 📐 4. Principles
1. Performance-First Design: Prioritize low-latency and high-performance solutions in both frontend and backend systems.
2. Incremental Migration: Ensure the migration from the monolith to microservices is gradual, minimizing disruption to users.
3. Observability: Expose metrics and logs to enable tracking and monitor latency.
4. User-Centric Optimization: Continuously optimize the system based on user behavior and feedback to enhance the overall experience.


# 🏗️ 5. Overall Diagrams

## 🗂️ 5.1 Overall architecture

![img.overall.architecture.png](img.overall.architecture.png)


## 🗂️ 5.2 Deployment

![img.deployment.png](img.deployment.png)

## 🗂️ 5.3 Use Cases

### Posting products

The user is capable of post products into the platform to sell it.

![img.uc.post.product.png](img.uc.post.product.png)

### Searching products

The user is capable of searching products in the platform to buy it.

![img.uc.search.product.png](img.uc.search.product.png)

### Viewing product descriptions

The user is capable of viewing product descriptions to understand the product better.
![img.uc.view.product.png](img.uc.view.product.png)

### Rating products with review

The user is capable of rating products with review to help other users to understand the product better.
![img.uc.review.product.png](img.uc.review.product.png)

### Comments and Recommend

The user is capable of commenting products to help other users to understand the product better.

The user is capable of providing recommendation of products to users based on previews browsing to help other users to understand the product better.

![img.uc.comment.recommend.png](img.uc.comment.recommend.png)


## 🧭 6. Trade-offs

### Major Decisions
1. Use Copilot Agent for code generation in latest Java version in order to modernize the monolith.
2. Use Svelte for frontend to improve UI performance and reduce latency.
3. Use WebSockets for real-time updates and faster communication.
   * Price drop alerts for wish listed games
   * Order status updates ("Seller has shipped your game")
   * Instantly update when rare retro games become available or sell out
   * Show "X people are viewing this item" counters in real-time
   * Display "Just sold!" notifications without page refresh
4. CloudFront for serving the static files.
5. Global Accelerator It is commonly used for web applications, APIs, gaming platforms, and any latency-sensitive or highly available global service.
6. OpenSearch It would significantly improve the search experience in the marketplace while maintaining the performance standards.
7. Aurora Postgres works best as the primary transactional database.
8. PGsync to synchronize data from Aurora PostgreSQL to OpenSearch.

### Tradeoffs

1. Open-source.
  * ✅ PROS:
    * Benefits from community support and contributions.
  * 🚫 CONS:
    * Supporting and maintaining in house.

2. Svelte vs React
  * ✅ PROS:
    * Svelte compiles to vanilla JavaScript, resulting in smaller bundle sizes and faster execution.
    * No virtual DOM, leading to lower memory usage and CPU consumption.
  * 🚫 CONS:
    * Svelte has a smaller ecosystem compared to React, which may limit available libraries and tools.

3. WebSockets vs HTTP
  * ✅ PROS:
    * WebSockets provide lower latency and faster communication due to persistent connections.
    * Full-duplex communication allows for real-time updates.
  * 🚫 CONS:
    * Requires additional setup and management compared to traditional HTTP requests.
  * Benchmark comparison
    
    | Requests | Websocket total duration | HTTP total duration | Winner                |
    |----------|--------------------------|---------------------|-----------------------|
    | 1K       | 110 ms                   | 204 ms              | Websocket ~92% faster |
    | 10K      | 12123 ms                 | 19757 ms            | Websocket ~93% faster |
    | 100K     | 120914 ms                | 219011 ms           | Websocket ~94% faster |
    Source: https://github.com/codegik/websocket-benchmark

4. Non AWS alternative Cloudflare Workers
   * ✅ PROS Cloudflare Workers:
     * Extremely fast cold starts (<1ms)
     * Supports both JavaScript and WebAssembly
     * Larger memory limits (up to 128MB)
     * Can make external API calls
     * Extensive global network (275+ edge locations)
     * Built-in security features like Web Application Firewall
   * 🚫 CONS Cloudflare Workers:
     * No native Java/Kotlin support
     * Requires separate infrastructure if using AWS for other services
     * Requires Cloudflare-specific APIs
5. Global Accelerator
   * ✅ PROS:
     * Improves global application performance by routing users to the nearest healthy AWS endpoint.
     * Increases availability with automatic failover and health checks.
     * Supports multi-region architecture for resilience.
     * Provides built-in DDoS protection via AWS Shield.
     * Simplifies global traffic management with a single static IP.
   * 🚫 CONS:
     * Additional cost compared to standard AWS networking.
     * Adds another layer of infrastructure to manage.
     * Limited to AWS endpoints (not suitable for non-AWS resources).
     * May require changes to DNS and application architecture.
     * Some advanced routing features may not be as flexible as custom CDN or DNS solutions.

[//]: # (CloudFront Functions Use Cases:)
[//]: # (URL rewrites and redirects: Modify request URLs for routing, vanity URLs, or A/B testing.)
[//]: # (Header manipulation: Add, remove, or modify HTTP headers for security, CORS, or custom logic.)
[//]: # (Access control: Implement simple authentication, block/allow lists, or geo-restriction based on IP or headers.)
[//]: # (Cache key customization: Adjust cache keys by normalizing query strings or headers.)
[//]: # (Bot mitigation: Block or challenge known bots using user-agent or IP checks.)
[//]: # (Basic request validation: Quickly reject malformed or unauthorized requests before reaching the origin.)

[//]: # (Global Accelerator Use Cases:)
[//]: # (Low-latency global access: Directs users to the nearest healthy AWS region or endpoint, reducing latency for global users.)
[//]: # (High availability: Automatically reroutes traffic away from unhealthy endpoints to healthy ones, improving application uptime.)
[//]: # (Disaster recovery: Supports failover between AWS Regions for business continuity.)
[//]: # (Multi-region active-active architectures: Balances traffic across multiple AWS Regions for better performance and resilience.)
[//]: # (DDoS protection: Leverages AWS Shield for built-in DDoS mitigation.)

[//]: # (OpenSearch Use Cases:)
[//]: # (Product Search: Lightning-fast full-text search across game titles, descriptions, filters, price, recomendations.)
[//]: # (Recomendations: recommendations based on attributes and user behavior, Identify trending games through search behavior analysis.)
[//]: # (Review and Rating Analysis: Search within reviews and comments.)
[//]: # (Performance Benefits: Sub-10ms query performance even with complex filtering.)

# TODO
~~Docker registry - ECR~~
~~Define LLM~~
~~Uses cases for websocket~~
~~Benchmark for websocket~~
~~PGsync option~~
~~Use case cloud front function~~