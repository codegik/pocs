# Spring Boot Data JDBC Empty List Handling

This project demonstrates different approaches to handle queries with empty list parameters in Spring Boot Data JDBC (without Hibernate).

## The Problem

When using Spring Data JDBC repositories, passing an empty list to a query with an IN clause typically results in a `BadSqlGrammarException`. This happens because Spring Data JDBC generates invalid SQL syntax like `WHERE id IN ()` which is not valid SQL.

## Approaches to Handle Empty Lists

The `PersonRepository` demonstrates ten different approaches to handle queries when the parameter is an empty list:

### Option 1: Plain IN Clause
```java
@Query("SELECT * FROM person WHERE id IN (:ids)")
List<Person> findByIdInOption1(@Param("ids") List<Long> ids);
```

**Results:**
- ❌ **Not Working**: Fails with an exception when an empty list is passed
- ✅ **Working**: Works correctly when a non-empty list is provided
- 💥 **Error**: `BadSqlGrammarException: invalid SQL grammar [SELECT * FROM person WHERE id IN ()]`

### Option 2: PostgreSQL's ANY with Array Syntax
```java
@Query("SELECT * FROM person WHERE (:ids)::bigint[] IS NULL OR id = ANY((:ids)::bigint[])")
List<Person> findByIdInOption2(@Param("ids") List<Long> ids);
```

**Results:**
- ❌ **Not Working**: Fails with an exception when an empty list is passed
- ⚠️ **PostgreSQL-specific**: This approach is intended for PostgreSQL databases
- 💥 **Error**: `BadSqlGrammarException: invalid SQL grammar [SELECT * FROM person WHERE ()::bigint[] IS NULL OR id = ANY(()::bigint[])]`

### Option 3: Java-based Handling (Recommended)
```java
@Query("SELECT * FROM person WHERE id IN (:ids)")
List<Person> findByIdInOption3Raw(@Param("ids") List<Long> ids);

default List<Person> findByIdInOption3(List<Long> ids) {
    if (ids.isEmpty()) {
        return Collections.emptyList();
    }
    return findByIdInOption3Raw(ids);
}
```

**Results:**
- ✅ **Working**: Works correctly with both empty and non-empty lists
- 🌟 **Database Agnostic**: Works with any database since the empty list check happens in Java code
- 👍 **Best Practice**: Recommended approach for handling empty lists in Spring Data JDBC applications

### Option 4: SpEL Expression for Empty Check in Query
```java
@Query("SELECT * FROM person WHERE (:#{#ids.isEmpty()} = false AND id IN (:ids))")
List<Person> findByIdInOption4(@Param("ids") List<Long> ids);
```

**Results:**
- ❌ **Not Working**: Fails with an exception when an empty list is passed
- 💥 **Error**: `BadSqlGrammarException: invalid SQL grammar [SELECT * FROM person WHERE (? = false AND id IN ())]`
- 🔍 **Analysis**: Despite the SpEL check, the SQL still contains an empty `IN` clause

### Option 5: Constant False OR Condition
```java
@Query("SELECT * FROM person WHERE (1=0 OR id IN (:ids))")
List<Person> findByIdInOption5(@Param("ids") List<Long> ids);
```

**Results:**
- ❌ **Not Working**: Fails with an exception when an empty list is passed
- 💥 **Error**: `BadSqlGrammarException: invalid SQL grammar [SELECT * FROM person WHERE (1=0 OR id IN ())]`
- 🔍 **Analysis**: The empty `IN` clause is still problematic despite the OR condition

### Option 6: PostgreSQL's unnest with CAST
```java
@Query("SELECT * FROM person p WHERE EXISTS (SELECT 1 FROM unnest(CAST(:ids AS bigint[])) AS i(id) WHERE p.id = i.id) OR cardinality(:ids) = 0")
List<Person> findByIdInOption6(@Param("ids") List<Long> ids);
```

**Results:**
- ❌ **Not Working**: Fails with an exception when an empty list is passed
- ⚠️ **PostgreSQL-specific**: Utilizes PostgreSQL's unnest and array functions
- 💥 **Error**: `BadSqlGrammarException: invalid SQL grammar [SELECT * FROM person p WHERE EXISTS (SELECT 1 FROM unnest(CAST( AS bigint[])) AS i(id) WHERE p.id = i.id) OR cardinality() = 0]`

### Option 7: Multiple SpEL Checks
```java
@Query("SELECT * FROM person WHERE " +
        "(:#{#ids == null} = true) OR " +
        "(:#{#ids.isEmpty()} = true) OR " +
        "id IN (:#{#ids})")
List<Person> findByIdInOption7(@Param("ids") List<Long> ids);
```

**Results:**
- ❌ **Not Working**: Fails with an exception when an empty list is passed
- 💥 **Error**: `BadSqlGrammarException: invalid SQL grammar [SELECT * FROM person WHERE (? = true) OR (? = true) OR id IN ()]`
- 🔍 **Analysis**: Despite multiple SpEL checks, the generated SQL still has an invalid IN clause

### Option 8: Null Check with SpEL Expression
```java
@Query("SELECT * FROM person WHERE (:#{#ids == null} = true) OR id IN (:#{#ids})")
List<Person> findByIdInOption8(@Param("ids") List<Long> ids);
```

**Results:**
- ✅ **Working**: Works correctly, but only when passing `null` (not an empty list)
- ❗ **Limited Use**: Only helpful for null lists, not empty lists
- 🔍 **Analysis**: This approach works with `null` values but still has issues with empty lists

### Option 9: SpEL Expression for IN Clause
```java
@Query("SELECT * FROM person WHERE id IN (:#{#ids})")
List<Person> findByIdInOption9(@Param("ids") List<Long> ids);
```

**Results:**
- ❌ **Not Working**: Fails with an exception when an empty list is passed
- 💥 **Error**: `BadSqlGrammarException: invalid SQL grammar [SELECT * FROM person WHERE id IN ()]`
- 🔍 **Analysis**: Using SpEL doesn't solve the empty IN clause problem

### Option 10: PostgreSQL array_length Check
```java
@Query("SELECT * FROM person WHERE array_length(:ids::bigint[], 1) IS NULL OR id IN (:ids)")
List<Person> findByIdInOption10(@Param("ids") List<Long> ids);
```

**Results:**
- ❌ **Not Working**: Fails with an exception when an empty list is passed
- ⚠️ **PostgreSQL-specific**: Uses PostgreSQL's array functions
- 💥 **Error**: `BadSqlGrammarException: invalid SQL grammar [SELECT * FROM person WHERE array_length(::bigint[], 1) IS NULL OR id IN ()]`

## Recommendations

After testing multiple approaches, we recommend the following:

1. **Best Practice**: Use Option 3 (Java-based Handling) for maximum compatibility and reliability
   - Check for empty lists in Java code before executing the query
   - Works with all databases and has no special requirements
   - Most maintainable and least error-prone approach

2. **Alternative for Nullable Parameters**: Option 8 works when passing `null` parameters instead of empty lists
   - If your application logic allows for using null instead of empty lists, this can work

3. **Database-Specific Solutions**: If using PostgreSQL or another database with array functions, consider custom implementations:
   - These require database-specific syntax and careful testing
   - May be useful in certain high-performance scenarios
   - Need proper database configuration in test environments

## Getting Started

1. Clone this repository
2. Run `./mvnw test` to execute the tests that demonstrate each approach

## Conclusion

Handling empty lists in Spring Data JDBC queries requires careful consideration. The most reliable approach is to check for empty lists in Java code before executing the database query, as shown in Option 3. This avoids invalid SQL syntax while maintaining clean, database-agnostic code.
