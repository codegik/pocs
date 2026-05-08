# Scala 3 + Scalaz POC

POC demonstrating Scalaz functional programming concepts with Scala 3.

## Features

### 1. Validation (Applicative Functor)
- Accumulates multiple validation errors
- Uses `ValidationNel` for error collection
- Applicative composition with `|@|` operator

### 2. Option Monad
- Safe handling of nullable values
- Monadic composition with for-comprehensions
- Division by zero handling

### 3. Either (\/) Monad
- Error handling with `\/` (disjunction)
- Left for errors, Right for success values
- Composable error handling

### 4. Writer Monad
- Computation with logging
- Log accumulation across operations
- Separates value from context (logs)

### 5. Reader Monad
- Dependency injection pattern
- Configuration passing without explicit parameters
- Pure functional environment access

### 6. State Monad
- Stateful computations
- State threading through operations
- Immutable state management

### 7. Functor Operations
- Standard map/filter transformations
- Type-safe data transformations

### 8. Monoid Operations
- Sum aggregation with `suml`
- String concatenation with `intercalate`

### 9. Applicative Composition
- Combining multiple validations
- Parallel validation execution

## Running

```bash
sbt run
sbt test
```

## Output

All tests pass (21 tests) covering:
- Validation logic with error accumulation
- Option monad operations including chained divisions
- Either monad for success/failure paths
- Writer monad with logging
- Reader monad with configuration
- State monad with stateful computations
- Monoid operations for aggregation

## Key Concepts

- **Validation**: Accumulate errors instead of fail-fast
- **Monad**: Chain operations with automatic error handling
- **Writer**: Log without side effects
- **Reader**: Inject dependencies functionally
- **State**: Thread state through pure functions
- **Monoid**: Combine values with associative operations
