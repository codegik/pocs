# Spring Boot Data JDBC Empty List Handling POC

This project demonstrates different approaches to handle queries with empty list parameters in Spring Boot Data JDBC (without Hibernate).

## Person Repository - Empty List Handling

The `PersonRepository` demonstrates three different approaches to handle queries when the parameter is an empty list:

### Option 1: Plain IN Clause
```java
@Query("SELECT * FROM person WHERE id IN (:ids)")
List<Person> findByIdInOption1(@Param("ids") List<Long> ids);
```

**Results:**
- ❌ **Not Working**: This approach fails with an exception when an empty list is passed.
- ✅ **Working**: Works correctly when a non-empty list is provided.
- 💥 **Error**: `InvalidDataAccessApiUsageException` occurs because Spring Data JDBC generates invalid SQL with an empty IN clause (`WHERE id IN ()`).

### Option 2: PostgreSQL's ANY with Array Syntax
```java
@Query("SELECT * FROM person WHERE (id = ANY((:ids)::bigint[]) OR array_length(:ids::bigint[], 1) IS NULL) AND is_soft_deleted = FALSE")
List<Person> findByIdInOption2(@Param("ids") List<Long> ids);
```

**Results:**
- ✅ **Working**: When using PostgreSQL, this correctly handles empty lists by using array functions.
- ⚠️ **Limited Compatibility**: This approach is PostgreSQL-specific and may not work with other databases.
- 🔧 **H2 Compatibility**: When H2 is properly configured in PostgreSQL mode, this approach works in testing.

### Option 3: Java-based Handling (Recommended)
```java
default List<Person> findByIdInOption3(List<Long> ids) {
    if (ids == null || ids.isEmpty()) {
        return Collections.emptyList();
    }
    return findByIdInOption1(ids);
}
```

**Results:**
- ✅ **Working**: Works correctly with both empty and non-empty lists.
- 🌟 **Database Agnostic**: This approach works with any database since the empty list check happens in Java code.
- 👍 **Best Practice**: Recommended approach for handling empty lists in Spring Data JDBC applications.
