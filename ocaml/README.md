# Ocaml POCs

Studies purpose.


## Why Ocaml?
OCaml mixes power and pragmatism in a way that makes it ideal for building complex software systems. 
What makes OCaml special is that it occupies a sweet spot in programming language design. 
It provides a combination of efficiency, expressiveness, and practicality that is matched by no other language. 
That is in large part because OCaml is an elegant combination of language features that have been developed over the last 40 years. 
These include:

- **Generational garbage collection** for automatic memory management.
- **First-class functions** that can be passed around like ordinary values, as seen in JavaScript, Common Lisp, and C#.
- **Static type-checking** to increase performance and reduce the number of runtime errors, as found in Java and C#.
- **Parametric polymorphism**, which enables the construction of abstractions that work across different data types, similar to generics in Java and C# and templates in C++.
- **Good support for immutable programming**, i.e., programming without making destructive updates to data structures. This is present in traditional functional languages like Scheme, and it's also found in distributed, big-data frameworks like Hadoop.
- **Type inference**, so you don’t need to annotate every function parameter, return type, and variable. Instead, types are inferred based on how a value is used. Available in a limited form in C# with implicitly-typed local variables and in C++11 with its auto keyword.
- **Algebraic data types and pattern matching** to define and manipulate complex data structures, also available in Scala and F#.

## Generational Garbage Collection
The usual OCaml programming style involves allocating many small values that are used for a short period of time and then never accessed again. OCaml takes advantage of this fact to improve performance by using a generational GC.

A generational GC maintains separate memory regions to hold blocks based on how long the blocks have been live. OCaml’s heap is split into two such regions:

- A small, fixed-size minor heap where most blocks are initially allocated
- A larger, variable-size major heap for blocks that have been live longer

A typical functional programming style means that young blocks tend to die young and old blocks tend to stay around for longer than young ones. This is often referred to as the generational hypothesis.

OCaml uses different memory layouts and garbage-collection algorithms for the major and minor heaps to account for this generational difference.

The compiler has a straightforward compilation strategy that produces performant code without requiring heavy optimisation and without the complexities of dynamic just-in-time (JIT) compilation. 
This, along with OCaml’s strict evaluation model, makes runtime behavior easy to predict. 

All of this makes OCaml a great choice for programmers who want to step up to a better programming language, and at the same time get practical work done. 
