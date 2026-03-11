# Coding Dojo - Clean Code - SOLID

> An introduction to Clean Code / Architecture in disguise.

A Coding Dojo based on the universe of Metal Gear Solid. Five exercises will be presented to introduce the principles behind the SOLID acronym.

## Solution - Interface Segregation Principle

The `Repository<T, K>` interface was monolithic — it bundled `add`, `findAll`, `findById`, and `delete` into a single contract. Adding `delete` forced every repository implementation to implement it, even those that should never support deletion.

**The fix:**

`Repository.java` was split into four focused role interfaces:

- `Add<T>` — for adding elements
- `FindAll<T>` — for listing all elements
- `FindById<T, K>` — for finding a single element by id
- `Delete<K>` — for deleting elements (only used where truly needed)

Each repository interface now only extends the roles it actually needs:

```java
public interface AgentsRepository extends Add<Agent>, FindAll<Agent>, FindById<Agent, String> {}
```

Checkout into the next exercise:

```
git checkout java-exercise-5
```

## Requirements

- Java 11+
- Maven 3.6+

## Running the tests

```
mvn test
```
