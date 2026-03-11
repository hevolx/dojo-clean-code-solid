# Coding Dojo - Clean Code - SOLID

> An introduction to Clean Code / Architecture in disguise.

A Coding Dojo based on the universe of Metal Gear Solid. Five exercises will be presented to introduce the principles behind the SOLID acronym.

## Solution - Single Responsibility Principle

The `MissionsService` had two problems:

1. It depended on the concrete `InMemoryMissionsRepository` class instead of the `MissionsRepository` interface.
2. The `addMission` method contained inline validation logic that did not belong there.

**The fix:**

- `MissionsService` now depends on the `MissionsRepository` interface.
- A new `MissionPolicies` class was introduced to hold `isMissionValid` and `hasAlreadyAMissionWithinThisPeriod`.
- `MissionsService.addMission` now delegates to `MissionPolicies` — one reason to change.

Checkout into the next exercise:

```
git checkout java-exercise-2
```

## Requirements

- Java 11+
- Maven 3.6+

## Running the tests

```
mvn test
```
