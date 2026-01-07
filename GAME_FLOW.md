## Dungeon of the Ancients — Text-Based RPG


## Internal Game Execution & Logic Flow

---

## 1. Application Entry Point

The game execution begins in the `main()` method of the `TextRPG` class.

```java
public static void main(String[] args) {
    TextRPG game = new TextRPG();
    game.startGame();
}
```

### Flow Summary

1. A `TextRPG` object is instantiated
2. Core systems (`Scanner`, `Random`) are initialized
3. The game lifecycle starts via `startGame()`

---

## 2. Game Initialization Flow

### `startGame()`

This method coordinates the initial setup phase.

**Sequence:**

1. Display game title
2. Create the player character
3. Enter the main game loop

```text
startGame()
 ├── showTitle()
 ├── createPl
 ayer()
 └── gameLoop()
```

---

## 3. Player Creation Flow

### `createPlayer()`

Handles character setup and validation.

**Logic:**

* Prompt for player name
* Loop until a valid class selection is made
* Initialize player stats based on class
* Assign starting items and gold

**Class-based initialization:**

* Warrior → High health & defense
* Mage → High attack, low defense
* Archer → Balanced attributes

This guarantees that the player always starts in a valid and consistent state.

---

## 4. Core Game Loop

### `gameLoop()`

This is the **central control loop** of the game.

```text
WHILE gameRunning AND player.health > 0
 └── showMainMenu()
```

The loop continues until:

* The player chooses to quit
* OR the player’s health reaches zero

This structure ensures continuous interaction while enforcing game termination rules.

---

## 5. Main Menu Control Flow

### `showMainMenu()`

Displays options and routes execution based on user input.

```text
Main Menu
 ├── Explore → explore()
 ├── Check Stats → printStats()
 ├── Inventory → checkInventory()
 ├── Shop → visitShop()
 ├── Rest → rest()
 └── Quit → exit confirmation
```

Invalid input is handled gracefully without breaking the game loop.

---

## 6. Exploration Logic

### `explore()`

Exploration is driven by a random probability model.

**Event Distribution:**

| Event           | Probability |
| --------------- | ----------- |
| Enemy encounter | 40%         |
| Treasure found  | 30%         |
| Nothing happens | 15%         |
| Trap triggered  | 15%         |

This ensures replayability and unpredictability.

---

## 7. Enemy Encounter & Combat Flow

### `encounterEnemy()`

#### Enemy Generation

Enemy stats scale dynamically using the player’s level:

* Health increases with level
* Attack and defense scale progressively
* Rewards scale with difficulty

---

### Combat Loop

Combat follows a **turn-based loop**:

```text
WHILE enemy.health > 0 AND player.health > 0
 ├── Player chooses action
 │    ├── Attack
 │    ├── Use Item
 │    └── Run
 └── Enemy counterattacks (if alive)
```

---

### Damage Calculation

Damage is always guaranteed to be at least **1** to prevent infinite combat.

```text
Player Damage = max(1, player.attack - enemy.defense / 2)
Enemy Damage = max(1, enemy.attack - player.defense / 2)
```

---

### Combat Exit Conditions

* Enemy defeated → rewards granted
* Player defeated → game ends
* Successful escape → return to main menu

---

## 8. Reward & Progression Flow

### `gainRewards()`

* Adds experience points
* Adds gold
* 30% chance to receive an item

---

### `checkLevelUp()`

Level-up condition:

```text
experience >= level × 100
```

On level up:

* Level increases by 1
* Max health increases
* Attack and defense increase
* Health fully restored

This creates a clear progression curve.

---

## 9. Inventory & Item Usage Flow

### Inventory System

* Items stored using `HashMap<String, Integer>`
* Allows fast lookup and quantity tracking

### Item Usage

* Health Potions restore 30 HP
* Items can be used:

  * In combat
  * From inventory menu

Empty or unavailable items are safely handled.

---

## 10. Shop Flow

### `visitShop()`

The shop allows:

* Consumable purchases
* Permanent stat upgrades

Purchases are validated against available gold.
Permanent upgrades directly modify player stats.

---

## 11. Resting & Ambush Logic

### `rest()`

* Restores up to 30 health
* Health capped at maximum
* 20% chance to trigger an enemy ambush

This introduces **risk vs reward** even in recovery actions.

---

## 12. Trap Handling

### `encounterTrap()`

* Immediate health reduction
* Can result in instant game over
* Bypasses combat entirely

Traps reinforce uncertainty during exploration.

---

## 13. Game Termination Flow

### Game Over

Triggered when:

* Player health reaches zero

### Quit Option

* Explicit confirmation required
* Prevents accidental exits

Resources (Scanner) are closed cleanly before termination.

---

## 14. Flow Characteristics Summary

* Single-loop, deterministic control flow
* Randomized events for replayability
* Clear separation of gameplay responsibilities
* No hidden state mutations
* Defensive handling of invalid inputs

---

## 15. Design Intent

The game flow is intentionally:

* Simple
* Predictable
* Easy to trace
* Suitable for demonstrating Java fundamentals

This design prioritizes **readability, correctness, and maintainability** over complexity.

---



















































































































































