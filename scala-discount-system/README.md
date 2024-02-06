
# Scala Discount System

Let's write a discount system for a beauty saloon, which provides services and sells beauty products.

It offers 3 types of memberships: `Premium`, `Gold` and `Silver`. These members receive a discount of `20%`, `15%`, and `10%`, respectively, for all services provided. Customers without membership receive no discount.

All members receive a flat `10%` discount on products purchased.

Any customer that purchase more than `5` products will become a member `Silver`. And more than `10` products will become a member `Gold`, and more than `20` will become a member `Premium`.

The system should compute the total bill if a customer purchases `$x` of products and `$y` of services.

## Constraints:
- Don't use mock in unit tests, use fakes instead.
- Be immutable always.
- Always use interfaces.
- Don't accept nulls.
- Getters/Setters are forbidden.
- Data classes are forbidden.
- Enums are forbidden.
- HashTables are Forbidden.

## Requirements

- Java 17
- Scala 3
- Sbt 1.8

# Running
```
sbt test
```
