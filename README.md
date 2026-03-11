# Coding Dojo - Clean Code - SOLID

> An introduction to Clean Code / Architecture in disguise.

A Coding Dojo based on the universe of Metal Gear Solid. Five exercises will be presented to introduce the principles behind the SOLID acronym.

## Conclusion

```
Great job Snake, you have managed to tremendously clear the project !
```

I hope that you have enjoyed the trip and that you will apply all of those principles in your work !

### Summary of what you've learned

| # | Principle | Branch | Key takeaway |
|---|-----------|--------|-------------|
| S | Single Responsibility | java-exercise-1 | A class should have only one reason to change. Extract `MissionPolicies` from `MissionsService`. |
| O | Open / Closed | java-exercise-2 | Extend behavior with new classes, don't modify existing ones. Create `BackedMissionsService extends MissionsService`. |
| L | Liskov Substitution | java-exercise-3 | A subtype must be substitutable for its parent. Don't override methods with stronger preconditions. |
| I | Interface Segregation | java-exercise-4 | Don't force clients to depend on methods they don't use. Split `Repository` into focused role interfaces. |
| D | Dependency Inversion | java-exercise-5 | Depend on abstractions, not concretions. `AgentsService` should use `AgentsRepository`, not `InMemoryAgentsRepository`. |

Don't hesitate to raise an issue if you have any observations about the dojo!

I highly recommend reading **"Clean Architecture: A Craftsman's Guide to Software Structure and Design"** by Robert C. Martin for a deeper dive into the SOLID principles and many more.

## Requirements

- Java 11+
- Maven 3.6+

## Running the tests

```
mvn test
```
