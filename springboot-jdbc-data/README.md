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

## Address Repository - Soft Delete Filter Approaches

This project also demonstrates three different approaches to automatically apply a soft delete filter (`is_soft_deleted = false`) to repository queries:

### Approach 1: Standard Repository (`AddressRepository`)

The standard repository uses explicit filters in each query:

```java
@Query("SELECT * FROM address WHERE street = :street AND is_soft_deleted = FALSE")
List<Address> findByStreet(@Param("street") String street);
```

**Results:**
- ✅ **Working**: Explicitly adding the filter to each query works but is repetitive.
- ⚠️ **Error-prone**: Easy to forget adding the filter to new query methods.
- 👎 **Not DRY**: Violates the "Don't Repeat Yourself" principle.

### Approach 2: SQL Fragment Constant (`AddressRepositoryConcatFilter`)

This approach uses a SQL fragment constant that's concatenated to all queries:

```java
public interface AddressRepositoryConcatFilter extends CrudRepository<Address, Long> {
    String NOT_DELETED = " is_soft_deleted = false ";

    @Query("SELECT * FROM address WHERE " + NOT_DELETED)
    @Override
    List<Address> findAll();
}
```

**Results:**
- ✅ **Working**: All queries automatically include the filter via concatenation.
- 👍 **Maintainable**: The filter condition is defined in one place and reused.
- ⚠️ **Still Manual**: Still requires manual addition to each query method.

### Approach 3: Active Data Pattern (`AddressRepositoryActiveData`)

This approach uses Spring Data JDBC repository customization to automatically apply filters:

```java
public interface AddressRepositoryActiveData extends BaseRepository<Address, Long> {
    // Methods from BaseRepository automatically filter by is_soft_deleted = false
    List<Address> findByStreet(String street); // Filter applied automatically
}
```

**Results:**
- ✅ **Working**: Automatically applies the filter to standard finder methods.
- 🌟 **Truly Automatic**: No need to modify queries manually to include the filter.
- 👍 **Type-safe**: Uses Java interfaces rather than string concatenation.
- ⚠️ **Complex Setup**: Requires custom repository implementation classes.

## Running the Tests

The integration tests demonstrate and verify all approaches:
- `PersonRepositoryIntegrationTest` - Validates empty list handling
- `AddressRepositoryIntegrationTest` - Tests standard approach
- `AddressRepositoryConcatFilterIntegrationTest` - Tests SQL fragment approach
- `AddressRepositoryActiveDataIntegrationTest` - Tests active data pattern

Run the tests with: `./mvnw test`
