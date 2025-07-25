# Spring Boot 3.x Global Error Handling POC

This Proof of Concept (POC) demonstrates global error handling in Spring Boot 3.x using `@ControllerAdvice` and explores the important limitation when dealing with asynchronous method calls.

## Overview

This application showcases:
- ✅ Global error handling with `@ControllerAdvice`
- ✅ Async method execution with custom thread pool
- ⚠️ **Critical Limitation**: Global error handlers cannot catch exceptions from `@Async` methods
- ✅ **Solutions**: Three approaches to handle async exceptions properly

## Project Structure

```
src/main/kotlin/com/codegik/
├── Application.kt              # Main application class
├── config/
│   ├── AsyncConfig.kt          # Async configuration with custom exception handler
│   └── CustomAsyncExceptionHandler.kt # Global async exception handler
├── controller/
│   └── TimeController.kt       # REST controller with multiple async endpoints
├── service/
│   └── TimeService.kt          # Service with different async exception handling approaches
└── exception/
    └── GlobalExceptionHandler.kt # Global error handler with @ControllerAdvice
```

## API Endpoints

### 1. Basic Async with Global Handler
- **Endpoint**: `GET /api/current-time`
- Uses `AsyncUncaughtExceptionHandler` for exception handling
- Exceptions are logged and handled globally

### 2. CompletableFuture Approach  
- **Endpoint**: `GET /api/current-time-with-future`
- Returns `CompletableFuture<T>` for proper async error handling
- Allows `.whenComplete()` or `.exceptionally()` for exception handling

### 3. Manual Exception Handling
- **Endpoint**: `GET /api/current-time-manual-handling`
- Try-catch within the async method itself
- Custom error notifications and logging

## 🚨 Why @ControllerAdvice Cannot Catch Async Exceptions

### The Problem
When a method is annotated with `@Async`, Spring executes it in a **separate thread** outside the request-response cycle:

```kotlin
@GetMapping("/api/current-time")
fun getCurrentTime() {
    // This runs in the main request thread
    timeService.processTimeAsync() // This runs in a separate async thread
    return response // Response sent immediately
}

@Async
fun processTimeAsync() {
    throw RuntimeException("This won't be caught by @ControllerAdvice!")
}
```

### Why It Doesn't Work
1. **Request Thread**: Handles HTTP request/response
2. **Async Thread**: Executes the `@Async` method independently  
3. **@ControllerAdvice**: Only catches exceptions in the request thread
4. **Timeline**: Response (200 OK) → Async Exception (after response sent)

## ✅ Solutions for Async Exception Handling

### Solution 1: AsyncUncaughtExceptionHandler (Implemented)

**Configuration:**
```kotlin
@Configuration
@EnableAsync
class AsyncConfig : AsyncConfigurer {
    override fun getAsyncUncaughtExceptionHandler(): AsyncUncaughtExceptionHandler {
        return CustomAsyncExceptionHandler()
    }
}
```

**Custom Handler:**
```kotlin
class CustomAsyncExceptionHandler : AsyncUncaughtExceptionHandler {
    override fun handleUncaughtException(ex: Throwable, method: Method, vararg params: Any?) {
        logger.severe("Uncaught async exception in method: ${method.name}")
        // Handle exception: log, alert, store in DB, etc.
    }
}
```

**Pros:**
- ✅ Global handling of all uncaught async exceptions
- ✅ Centralized logging and notification
- ✅ No code changes needed in async methods

**Cons:**
- ❌ Cannot affect HTTP response (already sent)
- ❌ Limited context about the original request

### Solution 2: CompletableFuture (Implemented)

**Service Method:**
```kotlin
@Async
fun processTimeAsyncWithFuture(): CompletableFuture<String> {
    return try {
        // Processing logic
        CompletableFuture.completedFuture("Success")
    } catch (ex: Exception) {
        CompletableFuture.failedFuture(ex)
    }
}
```

**Controller Usage:**
```kotlin
val future = timeService.processTimeAsyncWithFuture()
future.whenComplete { result, exception ->
    if (exception != null) {
        // Handle async exception here
        logger.error("Async processing failed: ${exception.message}")
    }
}
```

**Pros:**
- ✅ Proper async result/exception handling
- ✅ Can chain multiple async operations
- ✅ Full control over exception handling

**Cons:**
- ❌ More complex code
- ❌ Still cannot affect original HTTP response

### Solution 3: Manual Exception Handling (Implemented)

**Service Method:**
```kotlin
@Async
fun processTimeAsyncWithManualHandling() {
    try {
        // Processing logic
    } catch (e: IllegalArgumentException) {
        logger.warning("Validation error: ${e.message}")
        sendErrorNotification("Validation Error", e.message)
    } catch (e: Exception) {
        logger.severe("Unexpected error: ${e.message}")
        sendErrorNotification("System Error", e.message)
    }
}
```

**Pros:**
- ✅ Full control over exception handling
- ✅ Can implement custom error handling per exception type
- ✅ Can trigger specific actions (notifications, database updates)

**Cons:**
- ❌ Need to add try-catch to every async method
- ❌ Code duplication if not properly abstracted

## Testing the Solutions

### Run the Application
```bash
./mvnw spring-boot:run
```

### Test Each Approach
```bash
# Test AsyncUncaughtExceptionHandler
curl -X GET http://localhost:8080/api/current-time

# Test CompletableFuture approach
curl -X GET http://localhost:8080/api/current-time-with-future

# Test Manual exception handling
curl -X GET http://localhost:808
