# DOJO

## Requirements

- Java 17
- Scala 3
- Sbt 1.8

## ATM Withdrawal Challenge

- This is an ATM withdrawal engine to deliver money to the customer.

### Rules:

- Deliver less number of banknotes as possible.
- Allow to withdraw with available banknotes.
- Client balance is infinite.
- ATM banknotes are finite.
- Banknotes available are $100, $50, $20 and $10

#### Example

- Given withdraw amount is $30, then the customer will receive these banknotes: $20 and $10.


# Running
```
sbt run
```
