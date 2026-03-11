# Coding Dojo - Clean Code - SOLID

> An introduction to Clean Code / Architecture in disguise.

A Coding Dojo based on the universe of Metal Gear Solid. Five exercises will be presented to introduce the principles behind the SOLID acronym.

## Solution - Dependency Inversion Principle

`AgentsService` was depending on the concrete `InMemoryAgentsRepository` class. This means that if we ever want to swap out the in-memory store for a real database, we must modify `AgentsService` itself — a clear violation of DIP.

**The fix:**

- `AgentsService.agentsRepository` field type changed from `InMemoryAgentsRepository` to `AgentsRepository`.
- The constructor parameter was changed in the same way.
- `AgentsService` now depends only on the abstraction — the specific implementation is provided by the caller.

Now `AgentsService` works with any `AgentsRepository` implementation without knowing which one it is.

Checkout into the conclusion:

```
git checkout java-conclusion
```

## Requirements

- Java 11+
- Maven 3.6+

## Running the tests

```
mvn test
```
