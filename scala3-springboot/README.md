# Scala Collections + Interoperability

This project is using Scala + Springboot. It is a simple project to demonstrate the interoperability between Scala and Java.

## Requirements
- Java 21
- SBT 1.10.5
- Scala 3.6.2

## Engineer Design

- Imagine that you want to avoid the use of Java Collections in your Scala codebase. 
There are many reasons for that, but one of the main reasons is that Scala Collections are more powerful and have more features than Java Collections.
Specially if we're seeking for Immutability.

- Springboot is a Java Library and by default, it uses Java Collections. Example: `ArrayList`, `HashMap`, `HashSet`, etc.

- The `Repository` interface is returning `Iterable`, which is a Java Interface. 


So, here are some questions that we need to answer: 
- How can we use Scala Collections in a Springboot project?
- How can we create a Repository that returns Scala Collections?