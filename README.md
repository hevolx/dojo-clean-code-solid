# Coding Dojo - Clean Code - SOLID

> An introduction to Clean Code / Architecture in disguise.

A Coding Dojo based on the universe of Metal Gear Solid. Five exercises will be presented to introduce the principles behind the SOLID acronym.

## Dojo

### Interface Segregation Principle

> "The interface-segregation principle (ISP) states that no client should be forced to depend on methods it does not use." Robert C. Martin.

Split large interfaces into smaller, more specific "role interfaces" so that clients only know about the methods that are of interest to them.

For example, instead of one big `DrinkService` with `fillWater`, `pourDrink`, and `doMaintenance` — you would have three focused interfaces, each used by the client that needs it.

```
The previous mission was the most difficult, keep on cleaning !

A lot of integrators expressed their frustration about our API. They keep telling us that there is
way too much useless things to implement, even unnecessary methods...
```

#### Exercise

Checkout into the `java-exercise-4` branch.

The team wants to add the ability to delete missions from a repository. A `delete` method has been added to the `Repository<T, K>` interface.

As you can see, this **breaks the build** — all existing repository implementations are now forced to implement `delete`, even though most of them will never need it:

```
The type InMemoryMissionsRepository must implement the inherited abstract method Repository<Mission,String>.delete(String)
```

Fix the ISP violation: split `Repository<T, K>` into smaller role interfaces so that each repository only depends on what it actually needs.

Look for the `TODO (Exercise 4 - ISP)` comment in `Repository.java` for hints.

You will find a solution to this exercise in the `java-exercise-4-solution` branch.

## Requirements

- Java 11+
- Maven 3.6+

## Running the tests

```
mvn test
```
