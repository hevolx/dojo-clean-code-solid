# Coding Dojo - Clean Code - SOLID

> An introduction to Clean Code / Architecture in disguise.

A Coding Dojo based on the universe of Metal Gear Solid. Five exercises will be presented to introduce the principles behind the SOLID acronym.

## Dojo

### Liskov Substitution Principle

> "Functions that use pointers or references to base classes must be able to use objects of derived classes without knowing it." Robert C. Martin.

This principle is about substitutability: if `S` is a subtype of `T`, you should be able to use an `S` wherever a `T` is expected — without breaking anything.

Two key rules:
1. **Never strengthen preconditions** in a subtype. A subclass method should accept at least the same inputs as the parent.
2. **Never weaken postconditions** in a subtype. A subclass method should produce at least as strong a guarantee as the parent.

```
Still with us ? We need you more than ever with this issue.

The project acts oddly depending on the implementation, no matter how precise the API is...

Spot the weak substitution and fix it.
```

#### Exercise

Checkout into the `java-exercise-3` branch.

The team has decided that a `BackedMission` must have at least one backup agent.

Look at `BackedMissionsService`. It **overrides** `addMission()` and adds a new precondition: the mission must have a backup. This violates LSP — you cannot substitute a `BackedMissionsService` for a `MissionsService` because the behavior of `addMission()` is different.

You will find a solution to this exercise in the `java-exercise-3-solution` branch.

## Requirements

- Java 11+
- Maven 3.6+

## Running the tests

```
mvn test
```
