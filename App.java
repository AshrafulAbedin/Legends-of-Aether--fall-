
import java.util.Scanner;


public class App {
    private Scanner scanner;
    private Character player;
    private Character enemy;

    public App() {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        App game = new App();
        game.startGame();
    }

    public void startGame() {
        
        System.out.println("Choose a character: 1. Mage 2. Archer 3. Warrior");
        System.out.print("> ");
        int characterChoice = scanner.nextInt();
        scanner.nextLine(); 

        createPlayer(characterChoice);
        
        System.out.println("Choose a villain to fight against:");
        System.out.println("1. Dark Overlord");
        System.out.println("2. Regional Warlord");
        System.out.println("3. Corrupted Mortal");
        System.out.print("> ");
        int enemyChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        createEnemy(enemyChoice);

        // Exact introduction format
        System.out.println(player.getName() + " the " + player.getClass().getSimpleName() + " enters the world of Aetherfall!");
        System.out.println(enemy.getName() + " rises to spread chaos!");
        System.out.println("Battle Start!");

        battle();
    }

    private void createPlayer(int choice) {
        String characterType = "";
        switch (choice) {
            case 1:
                characterType = "Mage";
                break;
            case 2:
                characterType = "Archer";
                break;
            case 3:
                characterType = "Warrior";
                break;
            default:
                
                
        }
        
        System.out.println("You've chosen " + characterType);
        System.out.println("Enter your " + characterType.toLowerCase() + " name");
        System.out.print("> ");
        String name = scanner.nextLine();

        switch (choice) {
            case 1:
                player = new Mage(name);
                break;
            case 2:
                player = new Archer(name);
                break;
            case 3:
                player = new Warrior(name);
                break;
            default:
                
        }
    }

    private void createEnemy(int choice) {
        switch (choice) {
            case 1:
                enemy = new DarkOverlord();
                break;
            case 2:
                enemy = new RegionalWarlord();
                break;
            case 3:
                enemy = new CorruptedMortal();
                break;
            default:
                enemy = new CorruptedMortal();
        }
    }

    private void battle() {
        while (player.isAlive() && enemy.isAlive()) {
            if (player.cannotAttack) {
                System.out.println(player.getName() + " cannot attack this turn!");
            } else {
                System.out.print("> ");
                String action = scanner.nextLine().toLowerCase().trim();

                if (action.equals("attack") || action.equals("attck")) { // Handle typo like in example
                    playerAttack();
                } else if (action.equals("special")) {
                    playerSpecial();
                } else {
                    System.out.println("Invalid command!");
                    continue;
                }
            }

            displayStats();

            if (!enemy.isAlive()) {
                break;
            }

            
            System.out.println("Enemy Attacks");
            enemyTurn();
            displayStats();

            player.updateStatus();
            enemy.updateStatus();
        }

        displayResults();
    }

    private void playerAttack() {
        if (!player.canAttack()) {
            System.out.println(player.getName() + " doesn't have enough power to attack!");
            return;
        }

        int damage = player.attack(enemy);
        System.out.println(player.getName() + " used Attack on " + enemy.getName());
        System.out.println(player.getName() + " caused " + damage + " damage.");
    }

    private void playerSpecial() {
        if (!player.canUseSpecial()) {
            System.out.println(player.getName() + " doesn't have enough power for special attack!");
            return;
        }

        int damage = player.special(enemy);
        System.out.println(player.getName() + " used Special on " + enemy.getName() + ".");
        System.out.println(player.getName() + " caused " + damage + " damage.");
    }

    private void enemyTurn() {
        if (enemy.cannotAttack) {
            System.out.println(enemy.getName() + " cannot attack this turn!");
            return;
        }


        if (enemy.canUseSpecial() && Math.random() > 0.3) {
            int damage = enemy.special(player);
            System.out.println(enemy.getName() + " used Special on " + player.getName() + ".");
            
            if (enemy instanceof DarkOverlord) {
                System.out.println(enemy.getName() + " caused " + damage + " damage and weakened next 3 attacks.");
            } else if (enemy instanceof RegionalWarlord) {
                System.out.println(enemy.getName() + " caused " + damage + " damage and next 20 seconds the user cannot attack.");
            } else {
                System.out.println(enemy.getName() + " caused " + damage + " damage.");
            }
        } else if (enemy.canAttack()) {
            int damage = enemy.attack(player);
            System.out.println(enemy.getName() + " used Attack on " + player.getName());
            System.out.println(enemy.getName() + " caused " + damage + " damage.");
        } else {
            System.out.println(enemy.getName() + " doesn't have enough power to attack!");
        }
    }

    private void displayStats() {
        System.out.println("-------- Game Stats --------------");
        System.out.println(player.getName() + " - Health: " + player.getHealth() + ", Power: " + player.getPower());
        System.out.println(enemy.getName() + " - Health: " + enemy.getHealth() + ", Power: " + enemy.getPower());
    }

    private void displayResults() {
        System.out.println("--------- Results ----------------");
        if (player.isAlive()) {
            System.out.println(player.getName() + " wins the battle!");
            System.out.println(enemy.getName() + " has been defeated!");
        } else {
            System.out.println(enemy.getName() + " wins the battle!");
            System.out.println(player.getName() + " the " + player.getClass().getSimpleName().toLowerCase() + " has been defeated!");
        }
    }
}

// Flaws: 
/***************************************************
 *      1. Didn't Implement for Default cases.     *
 *                                                 *
 *      2. Can't control what Enemy will choose    *
 *      Attack or speacial                         *
 *                                                 *
 ***************************************************/
App.java
External
Displaying App.java.
