# Coding Dojo - Clean Code - SOLID

> An introduction to Clean Code / Architecture in disguise.

A Coding Dojo based on the universe of Metal Gear Solid. Five exercises will be presented to introduce the principles behind the SOLID acronym.

## Solution - Open / Closed Principle

The `MissionsService` had been modified to include `BackedMission`-specific methods (`getAllBackedMissions`, `getAgentBackedMissions`, `getBackedMissionInformation`, `removeBackupFromMission`). This violates OCP: to add a new feature, we modified an existing, working class.

**The fix:**

- A new `BackedMissionsService` class that **extends** `MissionsService` was created.
- All `BackedMission`-specific logic was moved there.
- `MissionsService` was restored to its clean state — untouched by the new feature.

Now `MissionsService` is **closed for modification** but **open for extension**.

Checkout into the next exercise:

```
git checkout java-exercise-3
```

## Requirements

- Java 11+
- Maven 3.6+

## Running the tests

```
mvn test
```
