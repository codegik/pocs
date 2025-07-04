# Spring Boot 3.x JDBC Soft Delete Approaches

This project demonstrates different approaches to implementing soft delete functionality in a Spring Boot 3.x application using Spring Data JDBC.

## What is Soft Delete?

Soft delete is a data retention pattern where records are marked as "deleted" but remain in the database. Instead of physically removing data with a `DELETE` statement, a flag or timestamp indicates that the record should be considered deleted in normal operations. This approach offers benefits like data recovery, audit trails, and historical reporting.

## Approaches Implemented

This project demonstrates three different approaches to implementing soft delete:

### 1. Standard Repository (No Filtering)

**Implementation**: `AddressRepository.java`

This approach represents the base case where no automatic filtering of soft-deleted records occurs. All queries return all records, including those marked as deleted.

**How it works:**
- Standard repository extends `CrudRepository`
- No special handling for soft-deleted records
- Queries must explicitly include filtering condition for `is_soft_deleted` if needed

**Use case:** When you need to access both active and deleted records in different scenarios.

### 2. Database View Approach

**Implementation**: `AddressRepositoryActiveData.java` + SQL View (`active_address`)

This approach uses a database view that filters out soft-deleted records at the database level.

**How it works:**
- Creates a database view (`active_address`) that only includes records where `is_soft_deleted = false`
- Repository methods query against this view instead of the base table
- Automatically filters out soft-deleted records for all operations

**Use case:** When you want to delegate the filtering responsibility to the database and ensure consistent filtering across all queries.

### 3. Query Concatenation Approach

**Implementation**: `AddressRepositoryConcatFilter.java`

This approach adds filtering conditions directly in the repository queries.

**How it works:**
- Defines a constant filter condition (`NOT_DELETED = "is_soft_deleted = false"`)
- Appends this condition to all query methods using string concatenation
- Explicitly overrides CRUD methods to include the filter

**Use case:** When you want control at the application level without database-specific features like views.

## Trade-offs

### Standard Repository (No Filtering)
**Pros:**
- Simplicity - no special handling required
- Full data access - can access both active and deleted records
- Flexibility - can apply filtering as needed

**Cons:**
- Risk of exposing deleted data - requires discipline to add filtering in every query
- Inconsistency - different queries might handle soft deletion differently
- Cognitive overhead - developers must remember to add filters

### Database View Approach
**Pros:**
- Database-level enforcement - consistent filtering across all queries
- Clean separation - repository code doesn't need filtering logic
- Performance - database can optimize view queries
- Database-agnostic queries - application code remains clean

**Cons:**
- Database-specific implementation - views may differ between database systems
- Less flexibility - harder to access soft-deleted records when needed
- Schema changes require view updates - additional maintenance
- Limited control over filtering in complex scenarios

### Query Concatenation Approach
**Pros:**
- Application-level control - no database-specific features required
- Consistent filtering - centralized filter definition
- Visibility - filtering logic is explicit in the code
- Works across database platforms

**Cons:**
- Code duplication - filter condition appears in multiple queries
- Error-prone - risk of forgetting to include the filter
- String concatenation risks - potential for SQL injection (though minimal with constants)
- Verbosity - repository code includes repetitive filter conditions

## Implementation Details

The project uses:
- Spring Boot 3.x
- Spring Data JDBC
- H2 in-memory database (for testing)
- JUnit 5 for integration tests

Each approach is implemented with its own repository interface and corresponding test cases that validate the soft delete behavior.

## Getting Started

1. Clone this repository
2. Run `./mvnw spring-boot:run` to start the application
3. Run `./mvnw test` to execute the tests that demonstrate each approach

## Conclusion

Choosing the right soft delete approach depends on your specific requirements:
- For maximum flexibility and simplicity, use the standard repository approach
- For database-level enforcement and clean repository code, use the view approach
- For application-level control without database-specific features, use the query concatenation approach

This project serves as a proof of concept to help you decide which approach best fits your application's needs.

