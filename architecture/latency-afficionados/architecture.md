# 🧬 Architecture overview

## 🏛️ Structure

### 1. 🎯 Problem Statement and Context

Latency Afficionados is a RETRO video game marketplace where users can sell RETRO video games and users can also buy such video games.

The platform is capable of:

- posting products
- search products
- view product descriptions
- rating products with review
- comments
- provide recommendation of products to users based on previews browsing
- sell/buy video games



#### Problem space
<br/>Latency is a key concern for the CTO.


**Problem 1:**
<br/>The UI must be fast and the current React 16 implementation is not meeting the performance requirements.
<br/>The goal is to find ways to speed up the rendering process and ensure that the UI is fast at all times.
<br/>Could we upgrade and tune React to be faster enough?
<br/>Could we use different technology to improve the performance of the UI?

**Problem 2:**
<br/>The monolith is very old and needs to be migrated to Java 21.
<br/>The monolith should be decomposed into smaller, more manageable services to improve maintainability and performance.
<br/>Could we rewrite the monolith in Java 21 and still meet the performance requirements?
