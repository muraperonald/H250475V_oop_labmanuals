# OOP 
name: Ronald Murape 
Reg number: H250475V
Course: Object-Oriented Programming with Java 

This directory contains the complete, compilable (JDK 17+) solutions for Labs .



## Folder layout
- `Lab01` ... `Lab11` — one folder per lab, containing the manual's demo programs plus
  selected `Basic / Intermediate / Challenge` exercise solutions.
- `Lab11` also contains the **Library Management System mini-project**.
- `banking system/` — standalone **bank account practice project** (`Account`, `SavingsAccount`,
  `CurrentAccount`, `BankDemo`) demonstrating abstraction, inheritance and polymorphism,
  plus the assignment brief (`ronaldmurape_h250475V_oop_prac_assignment1.pdf`).

## How to compile and run (example: Lab 01)
```bash
cd "Lab01"
javac *.java
java Student
```
Every class uses the manual's naming conventions (PascalCase classes, camelCase members,
UPPER_SNAKE_CASE constants) and `// EXPLAIN:` viva comments.

## Labs summary
| Lab | Topic | Key demos |
|---|---|---|
| 1 | Classes & objects | `Student`, `ReferenceDemo`, `Course`, exercise solutions |
| 2 | Constructors, this, static | `Book`, `InitOrder`, `Point`, exercise solutions |
| 3 | Encapsulation | `BankAccount`, `BankDemo`, `Team`, exercise solutions |
| 4 | Inheritance | `Employee`/`Manager`/`Developer`, `Chain`, `CompositionDemo` |
| 5 | Polymorphism | `Calculator`, `Shapes`, `CastingDemo` |
| 6 | Abstraction | `VehicleDemo`, `InterfaceDemo`, `ComparableDemo` |
| 7 | Exceptions | `ExceptionBasics`, `Wallet`, `ResourceDemo` |
| 8 | Generics & collections | `GenericsDemo`, `CollectionsDemo`, `SortingDemo` |
| 9 | Nested types, enums, records | `NestedDemo`, `EnumDemo`, `ObjectContract` |
| 10 | File I/O, lambdas, streams | `FileDemo`, `StudentRepository`, `StreamDemo` |
| 11 | Design patterns & mini-project | `SingletonFactoryDemo`, `StrategyObserverDemo`, `LibraryApp` |

## Mini-project (Lab 11) — Library Management System
Run with:
```bash
cd "Lab11"
javac *.java
java LibraryApp
```
Features: abstraction (`LibraryItem`), inheritance (`LibBook`, `Dvd`), interface `Borrowable`,
custom exceptions, `Map`-based storage, stream search, CSV persistence across runs,
menu (add item, register member, borrow, return, overdue list, search by title).

## Banking System (Practice Assignment)
A standalone practice project demonstrating an abstract `Account` with concrete
`SavingsAccount` and `CurrentAccount` subclasses (overdraft rules, interest,
maintenance fee, month-end processing), run from `BankDemo`.

Compile and run:
```bash
cd "banking system"
javac *.java
java BankDemo
```

## Edge cases / pitfalls addressed
- `NullPointerException` guards and null checks (Lab 1, 7).
- Defensive copies for mutable internal state (Lab 3).
- Checked vs unchecked exceptions and try-with-resources (Lab 7).
- Type erasure / primitive generics limitation shown in exercises (Lab 8).
- equals/hashCode contract verified with `HashSet` (Lab 9).
- Stream reuse and external-state mutation pitfalls noted in comments (Lab 10).

All folders have been compiled successfully with `javac *.java` (JDK 17+).
