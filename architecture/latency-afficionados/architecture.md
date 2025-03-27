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

#### 1.1.2 Second Problem
<br/>The monolith is very old and needs to be migrated to Java 21.
<br/>The monolith should be decomposed into smaller, more manageable services to improve maintainability and performance.
<br/>Could we rewrite the monolith in Java 21 and still meet the performance requirements?


