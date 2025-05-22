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

### Rating products with review

The user is capable of rating products with review to help other users to understand the product better.

### Comments

The user is capable of commenting products to help other users to understand the product better.

### Provide recommendation of products to users based on previews browsing

The user is capable of providing recommendation of products to users based on previews browsing to help other users to understand the product better.

