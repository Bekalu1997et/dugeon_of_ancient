

## Class-Based Code Explanation

---

## 1. `TextRPG` Class (Main Controller Class)

### Purpose

`TextRPG` is the **core controller class** of the game.
It manages the entire game lifecycle, user interaction, and game flow.

This class is responsible for **orchestrating gameplay**, not representing a game entity.

---

### Key Responsibilities

* Initialize the game
* Control the main game loop
* Display menus
* Handle exploration, combat, shop, resting, and quitting
* Maintain shared game resources

---

### Important Fields

```text
Player player        → stores the current player
Scanner scanner      → handles user input
Random random        → generates randomness
boolean gameRunning  → controls the main loop
```

These fields represent the **global game state**.

---

### Important Methods

| Method             | Description                           |
| ------------------ | ------------------------------------- |
| `main()`           | Entry point of the application        |
| `startGame()`      | Starts the game sequence              |
| `gameLoop()`       | Runs the main menu loop               |
| `showMainMenu()`   | Displays menu and routes user choices |
| `explore()`        | Triggers random dungeon events        |
| `encounterEnemy()` | Handles enemy encounters and combat   |
| `visitShop()`      | Handles shopping logic                |
| `rest()`           | Restores health with risk             |
| `checkInventory()` | Displays and manages inventory        |

---

### Design Notes

* Acts as a **game manager**
* Uses procedural control flow with object interaction
* Keeps the game state centralized and predictable

---

## 2. `Player` Class (Inner Class)

### Purpose

The `Player` class represents the **player-controlled character**.

It stores all data related to:

* Player identity
* Combat capability
* Progression
* Inventory

---

### Key Fields

```text
String name
String characterClass
int health, maxHealth
int attack, defense
int level, experience
int gold
HashMap<String, Integer> inventory
```

Each field represents a specific aspect of the player’s state.

---

### Core Methods

| Method              | Description                             |
| ------------------- | --------------------------------------- |
| `Player()`          | Constructor that initializes the player |
| `initializeStats()` | Sets stats based on chosen class        |
| `addItem()`         | Adds items to inventory                 |
| `useItem()`         | Uses consumable items                   |
| `printStats()`      | Displays player stats                   |

---

### Logic Explanation

* Stats vary based on character class
* Inventory uses `HashMap` for efficient access
* Health is capped at `maxHealth`
* Experience resets after leveling up

---

### Object-Oriented Principles Used

* **Encapsulation**: all fields are private
* **Composition**: inventory belongs to player
* **State management**: player state evolves over time

---

## 3. `Enemy` Class (Inner Class)

### Purpose

The `Enemy` class models **hostile creatures** encountered during exploration.

It represents **temporary combat entities**.

---

### Key Fields

```text
String name
int health
int attack
int defense
int experienceReward
int goldReward
```

---

### Behavior

* Enemies are created dynamically
* Stats scale with player level
* Exist only during combat encounters

The enemy class is intentionally simple and data-focused.

---

### Design Choice

* No behavior methods
* Combat logic is handled by `TextRPG`
* Keeps enemy representation lightweight

---

## 4. Combat Logic (Class Interaction)

Combat is a **collaboration between classes**:

```text
TextRPG → controls combat loop
Player  → deals and receives damage
Enemy   → takes damage and gives rewards
```

### Damage Formula

```text
Damage = max(1, attack − defense / 2)
```

This guarantees:

* Combat always progresses
* Defense reduces but never nullifies damage

---

## 5. Inventory System (Player-Centered)

* Inventory stored in `HashMap<String, Integer>`
* Allows:

  * Fast lookup
  * Quantity tracking
  * Safe removal when empty

Items are manipulated only through player methods.

---

## 6. External Libraries Used (Class-Level)

### `Scanner`

Used by `TextRPG` to:

* Read menu input
* Read combat decisions

### `Random`

Used by `TextRPG` to:

* Generate encounters
* Scale enemy stats
* Apply probabilities

### `HashMap`

Used by `Player` to:

* Store inventory
* Manage items efficiently

All libraries are from the **Java Standard Library**.

---

## 7. Why Inner Classes Were Used

### Reasoning

* Small-scale project
* Educational focus
* Reduced file complexity
* Clear ownership of entities

Inner classes simplify structure while preserving OOP principles.

---

## 8. Design Limitations (Intentional)

* Single source file
* No inheritance hierarchy
* Console-based interface
* No save/load feature

These constraints align with beginner-to-intermediate Java coursework.

---

## 9. Summary

This class-based design ensures:

* Clear responsibility separation
* Predictable game state
* Easy debugging and evaluation
* Strong demonstration of Java fundamentals

The project emphasizes **clarity, control flow, and object interaction**, which are essential for academic assessment.

---
