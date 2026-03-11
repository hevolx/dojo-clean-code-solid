# Coding Dojo - Clean Code - SOLID

> An introduction to Clean Code / Architecture in disguise.

A Coding Dojo based on the universe of Metal Gear Solid. Five exercises will be presented to introduce the principles behind the SOLID acronym.

## Dojo

### Open / Closed Principle

> "A class is closed, since it may be compiled, stored in a library, baselined, and used by client classes. But it is also open, since any new class may use it as parent, adding new features. When a descendant class is defined, there is no need to change the original or to disturb its clients." Bertrand Meyer.

This is one of the most important principles, if you want to be able to make your application grow.

To apply this principle efficiently, you must already have a modular application, respecting the **Single Responsibility Principle**.

To put it in context: what if we want to serve tea as well as coffee? One could rush the feature by adding a parameter with the type of drink and a dirty `if`... But not us!

We can instead make a new `TeaService` with the specific treatment, and have both services implement a `DrinkService` interface.

```
Well done with the previous mess !

Now, if we want to be able to add more specificities to the project, we will need to rethink our classes strategy.
```

#### Exercise

Checkout into the `java-exercise-2` branch.

A new feature has been added: missions with backup agents. These are an extension of regular missions, but with a list of agents that can be used as backup.

Unfortunately, the feature was rushed and we now have a messy `MissionsService`.

Look for the `TODO (Exercise 2 - OCP)` comments in the code.

Try to clean it by putting all the `BackedMission` specifics in a new class that **extends** `MissionsService`.

You will find a solution to this exercise in the `java-exercise-2-solution` branch.

## Requirements

- Java 11+
- Maven 3.6+

## Running the tests

```
mvn test
```
