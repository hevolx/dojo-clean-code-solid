# Coding Dojo - Clean Code - SOLID

> An introduction to Clean Code / Architecture in disguise.

A Coding Dojo based on the universe of Metal Gear Solid. Five exercises will be presented to introduce the principles behind the SOLID acronym.

## Dojo

### Dependency Inversion Principle

> "High level modules should not depend upon low level modules. Both should depend upon abstractions." Robert C. Martin.

> "Abstractions should not depend upon details. Details should depend upon abstraction." Robert C. Martin.

If you commit to a specific database — say, an in-memory store — you reference it directly everywhere. Then right before shipping, your boss tells you the requirements changed and you must use a different store. Now you have to search the entire codebase and replace every reference...

This is exactly what the **Dependency Inversion Principle** prevents. Instead of depending on `InMemoryAgentsRepository`, you depend on `AgentsRepository` (the abstraction). Swapping to a new implementation only requires one change at the wiring point.

```
One last thing to greatly improve our project and you will be free to go.

The team wants to be able to try numerous technical choices before deciding which one to use in production.

To do so, we need to rethink our application to remove any explicit references!
```

#### Exercise

Checkout into the `java-exercise-5` branch.

`AgentsService` makes an explicit reference to the concrete `InMemoryAgentsRepository` class.

Look for the `TODO (Exercise 5 - DIP)` comment and abstract the dependency.

You will find a solution to this exercise in the `java-exercise-5-solution` branch.

## Requirements

- Java 11+
- Maven 3.6+

## Running the tests

```
mvn test
```
