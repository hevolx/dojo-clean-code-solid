# Coding Dojo - Clean Code - SOLID

> An introduction to Clean Code / Architecture in disguise.

A Coding Dojo based on the universe of Metal Gear Solid. Five exercises will be presented to introduce the principles behind the SOLID acronym.

## Solution - Liskov Substitution Principle

The violation was that `BackedMissionsService.addMission()` **overrode** the parent's `addMission()` with a stronger precondition. Any code calling `addMission()` on a `MissionsService` reference would break if the object was actually a `BackedMissionsService`.

**The fix:**

- The override of `addMission()` was removed.
- A new method `addBackedMission(BackedMission)` was introduced instead.
- The extra precondition (must have backup) only lives in this new method — it does not affect the parent's contract.
- A test was added to verify that `addBackedMission` without a backup throws `InvalidMission`.

Now `BackedMissionsService` can safely substitute `MissionsService` anywhere.

Checkout into the next exercise:

```
git checkout java-exercise-4
```

## Requirements

- Java 11+
- Maven 3.6+

## Running the tests

```
mvn test
```
