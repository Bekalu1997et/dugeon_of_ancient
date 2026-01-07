
## Dungeon of the Ancients — Text-Based RPG

---

## 1. Game Overview

**Dungeon of the Ancients** is a console-based, text RPG written in Java.
The player explores a dungeon, fights enemies, collects items and gold, levels up, and tries to survive as long as possible.

The game is turn-based, menu-driven, and fully playable through the terminal.

---

## 2. How to Start the Game

### Requirements

* Java JDK 8 or higher
* Command-line / terminal

### Steps to Run

1. Compile the game:

   ```bash
   javac TextRPG.java
   ```
2. Run the game:

   ```bash
   java TextRPG
   ```

Once started, the game will display the title screen and begin character creation.

---

## 3. Character Creation

At the start of the game:

1. Enter your **character name**
2. Choose a **character class**

### Available Classes

| Class   | Strengths             | Weaknesses           |
| ------- | --------------------- | -------------------- |
| Warrior | High health & defense | Lower attack         |
| Mage    | High attack           | Low health & defense |
| Archer  | Balanced stats        | No extreme strengths |

Each class starts at:

* Level 1
* Full health
* 50 gold
* 3 Health Potions

---

## 4. Main Menu Options

After character creation, the game enters the **Main Menu loop**.

### Main Menu

```
1. Explore
2. Check Stats
3. Check Inventory
4. Visit Shop
5. Rest (Heal)
6. Quit Game
```

Each option performs a specific action:

---

## 5. Exploring the Dungeon

Choosing **Explore** triggers a random event.

### Possible Outcomes

| Event           | Probability |
| --------------- | ----------- |
| Enemy Encounter | 40%         |
| Treasure Found  | 30%         |
| Nothing Happens | 15%         |
| Trap Triggered  | 15%         |

Each exploration advances the game and may affect your health, gold, or inventory.

---

## 6. Combat System

When an enemy appears, the game enters **turn-based combat**.

### Combat Menu

```
1. Attack
2. Use Item
3. Try to Run
```

### Combat Rules

* Player acts first
* Damage is calculated using:

  * Player attack vs enemy defense
  * Enemy attack vs player defense
* Minimum damage is always **at least 1**
* Enemy attacks after the player’s action (unless defeated)

### Escaping Combat

* 50% chance to successfully run away
* Failure gives the enemy a free attack

---

## 7. Items & Inventory

### Health Potions

* Restore **30 HP**
* Cannot exceed max health
* Can be used:

  * In combat
  * From inventory menu

### Inventory Menu

Displays all current items and quantities.
You may use a Health Potion directly from this menu.

---

## 8. Experience & Leveling Up

### Gaining Experience

* Defeating enemies grants:

  * Experience points
  * Gold
  * Chance to obtain items

### Level Up Rules

* Required experience = `current level × 100`
* Upon leveling up:

  * Max Health increases
  * Attack increases
  * Defense increases
  * Health is fully restored

Leveling up makes enemies scale stronger as well.

---

## 9. Treasure & Traps

### Treasure Chests

* Grant random gold
* May contain Health Potions

### Traps

* Deal immediate damage
* Can defeat the player if health reaches zero

---

## 10. Shop System

The shop allows permanent upgrades and item purchases.

### Shop Options

| Item          | Cost     | Effect                 |
| ------------- | -------- | ---------------------- |
| Health Potion | 30 gold  | +1 potion              |
| Attack Boost  | 100 gold | +2 Attack (permanent)  |
| Defense Boost | 100 gold | +2 Defense (permanent) |

Gold must be sufficient to complete a purchase.

---

## 11. Resting

Choosing **Rest**:

* Restores up to 30 health
* Health cannot exceed max health
* There is a **20% chance** of being ambushed by an enemy while resting

---

## 12. Game Over & Quitting

### Game Over

The game ends when:

* Player health reaches **0**

### Quit Game

* Player may quit from the main menu
* Confirmation is required to prevent accidental exit

---

## 13. Winning Condition

There is **no fixed win condition**.
The objective is to:

* Survive as long as possible
* Level up
* Accumulate gold
* Improve character stats

---

## 14. Summary

* Text-based, menu-driven RPG
* Turn-based combat
* Random exploration events
* Leveling and progression system
* Simple, readable gameplay loop

This game emphasizes **core Java concepts**, logical flow, and object-oriented design in a playable format.

---
