import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;

// Main game class
public class TextRPG {
    private Player player;
    private Scanner scanner;
    private Random random;
    private boolean gameRunning;
    
    // Game settings
    private static final int MAX_HEALTH = 100;
    private static final int STARTING_GOLD = 50;
    
    public TextRPG() {
        scanner = new Scanner(System.in);
        random = new Random();
        gameRunning = true;
    }
    
    public static void main(String[] args) {
        TextRPG game = new TextRPG();
        game.startGame();
    }
    
    // Player class
    privat
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    e class Player {
        private String name;
        private String characterClass;
        private int health;
        private int maxHealth;
        private int attack;
        private int defense;
        private int level;
        private int experience;
        private int gold;
        private HashMap<String, Integer> inventory;
        
        public Player(String name, String characterClass) {
            this.name = name;
            this.characterClass = characterClass;
            this.level = 1;
            this.experience = 0;
            this.inventory = new HashMap<>();
            initializeStats();
        }
        
        private void initializeStats() {
            switch (characterClass.toLowerCase()) {
                case "warrior":
                    this.maxHealth = 120;
                    this.attack = 15;
                    this.defense = 12;
                    this.gold = STARTING_GOLD;
                    break;
                case "mage":
                    this.maxHealth = 80;
                    this.attack = 20;
                    this.defense = 8;
                    this.gold = STARTING_GOLD;
                    break;
                case "archer":
                    this.maxHealth = 100;
                    this.attack = 18;
                    this.defense = 10;
                    this.gold = STARTING_GOLD;
                    break;
                default:
                    this.maxHealth = 100;
                    this.attack = 10;
                    this.defense = 10;
                    this.gold = STARTING_GOLD;
            }
            this.health = this.maxHealth;
            inventory.put("Health Potion", 3);
        }
        
        public void addItem(String item, int quantity) {
            inventory.put(item, inventory.getOrDefault(item, 0) + quantity);
        }
        
        public boolean useItem(String item) {
            if (inventory.containsKey(item) && inventory.get(item) > 0) {
                if (item.equals("Health Potion")) {
                    health = Math.min(maxHealth, health + 30);
                    System.out.println("You used a Health Potion! Health: " + health + "/" + maxHealth);
                }
                inventory.put(item, inventory.get(item) - 1);
                if (inventory.get(item) == 0) {
                    inventory.remove(item);
                }
                return true;
            }
            return false;
        }
        
        public void printStats() {
            System.out.println("\n=== Player Stats ===");
            System.out.println("Name: " + name);
            System.out.println("Class: " + characterClass);
            System.out.println("Level: " + level);
            System.out.println("Health: " + health + "/" + maxHealth);
            System.out.println("Attack: " + attack);
            System.out.println("Defense: " + defense);
            System.out.println("Experience: " + experience + "/" + (level * 100));
            System.out.println("Gold: " + gold);
        }
    }
    
    // Enemy class
    private class Enemy {
        private String name;
        private int health;
        private int attack;
        private int defense;
        private int experienceReward;
        private int goldReward;
        
        public Enemy(String name, int health, int attack, int defense, int expReward, int goldReward) {
            this.name = name;
            this.health = health;
            this.attack = attack;
            this.defense = defense;
            this.experienceReward = expReward;
            this.goldReward = goldReward;
        }
    }
    
    // Start the game
    public void startGame() {
        showTitle();
        createPlayer();
        gameLoop();
    }
    
    private void showTitle() {
        System.out.println("=================================");
        System.out.println("    DUNGEON OF THE ANCIENTS     ");
        System.out.println("      Text-Based RPG Game       ");
        System.out.println("=================================\n");
    }
    
    private void createPlayer() {
        System.out.println("Create your character:");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        String characterClass;
        while (true) {
            System.out.println("\nChoose your class:");
            System.out.println("1. Warrior - High health and defense");
            System.out.println("2. Mage - High attack, low defense");
            System.out.println("3. Archer - Balanced stats");
            System.out.print("Enter your choice (1-3): ");
            
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    characterClass = "Warrior";
                    break;
                case "2":
                    characterClass = "Mage";
                    break;
                case "3":
                    characterClass = "Archer";
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    continue;
            }
            break;
        }
        
        player = new Player(name, characterClass);
        System.out.println("\nWelcome, " + player.name + " the " + player.characterClass + "!");
        System.out.println("Your adventure begins now...\n");
    }
    
    private void gameLoop() {
        while (gameRunning && player.health > 0) {
            showMainMenu();
        }
        
        if (player.health <= 0) {
            System.out.println("\n=== GAME OVER ===");
            System.out.println("You have been defeated...");
        }
        
        System.out.println("\nThanks for playing!");
        scanner.close();
    }
    
    private void showMainMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. Explore");
        System.out.println("2. Check Stats");
        System.out.println("3. Check Inventory");
        System.out.println("4. Visit Shop");
        System.out.println("5. Rest (Heal)");
        System.out.println("6. Quit Game");
        System.out.print("Enter your choice: ");
        
        String choice = scanner.nextLine();
        
        switch (choice) {
            case "1":
                explore();
                break;
            case "2":
                player.printStats();
                break;
            case "3":
                checkInventory();
                break;
            case "4":
                visitShop();
                break;
            case "5":
                rest();
                break;
            case "6":
                gameRunning = false;
                System.out.println("Are you sure you want to quit? (y/n)");
                if (!scanner.nextLine().equalsIgnoreCase("y")) {
                    gameRunning = true;
                }
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
    
    private void explore() {
        System.out.println("\nYou venture into the dungeon...");
        
        int encounter = random.nextInt(100);
        
        if (encounter < 40) { // 40% chance for enemy
            encounterEnemy();
        } else if (encounter < 70) { // 30% chance for treasure
            findTreasure();
        } else if (encounter < 85) { // 15% chance for nothing
            System.out.println("You explore the area but find nothing of interest.");
        } else { // 15% chance for trap
            encounterTrap();
        }
    }
    
    private void encounterEnemy() {
        String[] enemyNames = {"Goblin", "Skeleton", "Orc", "Giant Spider", "Zombie"};
        String enemyName = enemyNames[random.nextInt(enemyNames.length)];
        
        int baseHealth = 30 + (player.level * 10);
        int baseAttack = 8 + (player.level * 2);
        int baseDefense = 5 + player.level;
        
        Enemy enemy = new Enemy(
            enemyName,
            random.nextInt(20) + baseHealth,
            random.nextInt(5) + baseAttack,
            random.nextInt(3) + baseDefense,
            20 + (player.level * 5),
            10 + (player.level * 3)
        );
        
        System.out.println("\nA wild " + enemy.name + " appears!");
        System.out.println("It looks dangerous!");
        
        // Combat loop
        while (enemy.health > 0 && player.health > 0) {
            System.out.println("\n=== COMBAT ===");
            System.out.println("Your Health: " + player.health + "/" + player.maxHealth);
            System.out.println(enemy.name + " Health: " + enemy.health);
            System.out.println("\n1. Attack");
            System.out.println("2. Use Item");
            System.out.println("3. Try to Run");
            System.out.print("Choose your action: ");
            
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    // Player attacks
                    int playerDamage = Math.max(1, player.attack - (enemy.defense / 2));
                    enemy.health -= playerDamage;
                    System.out.println("You hit the " + enemy.name + " for " + playerDamage + " damage!");
                    
                    if (enemy.health <= 0) {
                        System.out.println("You defeated the " + enemy.name + "!");
                        gainRewards(enemy);
                        checkLevelUp();
                        return;
                    }
                    
                    // Enemy attacks back
                    int enemyDamage = Math.max(1, enemy.attack - (player.defense / 2));
                    player.health -= enemyDamage;
                    System.out.println("The " + enemy.name + " hits you for " + enemyDamage + " damage!");
                    break;
                    
                case "2":
                    useItemInCombat();
                    // Enemy still attacks if player used item
                    if (enemy.health > 0) {
                        enemyDamage = Math.max(1, enemy.attack - (player.defense / 2));
                        player.health -= enemyDamage;
                        System.out.println("The " + enemy.name + " hits you for " + enemyDamage + " damage!");
                    }
                    break;
                    
                case "3":
                    if (random.nextInt(100) < 50) { // 50% chance to escape
                        System.out.println("You successfully ran away!");
                        return;
                    } else {
                        System.out.println("You failed to escape!");
                        // Enemy gets a free attack
                        enemyDamage = Math.max(1, enemy.attack - (player.defense / 2));
                        player.health -= enemyDamage;
                        System.out.println("The " + enemy.name + " hits you for " + enemyDamage + " damage!");
                    }
                    break;
                    
                default:
                    System.out.println("Invalid choice! You hesitate and the enemy attacks!");
                    enemyDamage = Math.max(1, enemy.attack - (player.defense / 2));
                    player.health -= enemyDamage;
                    System.out.println("The " + enemy.name + " hits you for " + enemyDamage + " damage!");
            }
            
            if (player.health <= 0) {
                System.out.println("You have been defeated by the " + enemy.name + "...");
                return;
            }
        }
    }
    
    private void gainRewards(Enemy enemy) {
        player.experience += enemy.experienceReward;
        player.gold += enemy.goldReward;
        System.out.println("You gained " + enemy.experienceReward + " experience!");
        System.out.println("You found " + enemy.goldReward + " gold!");
        
        // Chance to find items
        if (random.nextInt(100) < 30) {
            player.addItem("Health Potion", 1);
            System.out.println("You found a Health Potion!");
        }
    }
    
    private void checkLevelUp() {
        int neededExp = player.level * 100;
        if (player.experience >= neededExp) {
            player.level++;
            player.experience = 0;
            player.maxHealth += 20;
            player.health = player.maxHealth;
            player.attack += 5;
            player.defense += 3;
            System.out.println("\n=== LEVEL UP! ===");
            System.out.println("You are now level " + player.level + "!");
            System.out.println("Your stats have improved!");
        }
    }
    
    private void findTreasure() {
        System.out.println("\nYou found a treasure chest!");
        int goldFound = random.nextInt(50) + 20;
        player.gold += goldFound;
        System.out.println("You found " + goldFound + " gold!");
        
        if (random.nextInt(100) < 50) {
            int potions = random.nextInt(2) + 1;
            player.addItem("Health Potion", potions);
            System.out.println("You found " + potions + " Health Potion(s)!");
        }
    }
    
    private void encounterTrap() {
        System.out.println("\nOh no! You triggered a trap!");
        int trapDamage = random.nextInt(20) + 10;
        player.health -= trapDamage;
        System.out.println("You take " + trapDamage + " damage!");
        
        if (player.health <= 0) {
            System.out.println("The trap was fatal...");
        }
    }
    
    private void checkInventory() {
        System.out.println("\n=== INVENTORY ===");
        if (player.inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            for (String item : player.inventory.keySet()) {
                System.out.println(item + ": " + player.inventory.get(item));
            }
        }
        
        System.out.println("\n1. Use Health Potion");
        System.out.println("2. Back to Menu");
        System.out.print("Choose: ");
        
        String choice = scanner.nextLine();
        if (choice.equals("1")) {
            if (!player.useItem("Health Potion")) {
                System.out.println("You don't have any Health Potions!");
            }
        }
    }
    
    private void useItemInCombat() {
        if (!player.useItem("Health Potion")) {
            System.out.println("You don't have any Health Potions!");
        }
    }
    
    private void visitShop() {
        System.out.println("\n=== WELCOME TO THE SHOP ===");
        System.out.println("Your gold: " + player.gold);
        System.out.println("\n1. Health Potion - 30 gold");
        System.out.println("2. Attack Boost (Permanent +2) - 100 gold");
        System.out.println("3. Defense Boost (Permanent +2) - 100 gold");
        System.out.println("4. Exit Shop");
        System.out.print("Choose: ");
        
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                if (player.gold >= 30) {
                    player.gold -= 30;
                    player.addItem("Health Potion", 1);
                    System.out.println("You bought a Health Potion!");
                } else {
                    System.out.println("Not enough gold!");
                }
                break;
            case "2":
                if (player.gold >= 100) {
                    player.gold -= 100;
                    player.attack += 2;
                    System.out.println("Your attack increased by 2!");
                } else {
                    System.out.println("Not enough gold!");
                }
                break;
            case "3":
                if (player.gold >= 100) {
                    player.gold -= 100;
                    player.defense += 2;
                    System.out.println("Your defense increased by 2!");
                } else {
                    System.out.println("Not enough gold!");
                }
                break;
            case "4":
                System.out.println("Come back anytime!");
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
    
    private void rest() {
        System.out.println("\nYou take a moment to rest and recover...");
        int oldHealth = player.health;
        player.health = Math.min(player.maxHealth, player.health + 30);
        System.out.println("You recovered " + (player.health - oldHealth) + " health!");
        System.out.println("Current health: " + player.health + "/" + player.maxHealth);
        
        // Chance for random encounter while resting
        if (random.nextInt(100) < 20) {
            System.out.println("\nWhile resting, you're ambushed!");
            encounterEnemy();
        }
    }
}