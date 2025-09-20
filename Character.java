
public abstract class Character {
    protected String name;
    protected int health;
    protected int power;
    protected int maxHealth;
    protected int maxPower;
    protected int standardAttackDamage;
    protected int standardAttackPowerCost;

    protected boolean isWeakened = false;
    protected int weakenedTurns = 0;
    protected boolean cannotAttack = false;
    protected int cannotAttackTurns = 0;

    public Character(String name, int health, int power, int standardAttackDamage, int standardAttackPowerCost) {
        this.name = name;
        this.health = health;
        this.power = power;
        this.maxHealth = health;
        this.maxPower = power;
        this.standardAttackDamage = standardAttackDamage;
        this.standardAttackPowerCost = standardAttackPowerCost;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public void usePower(int powerCost) {
        power -= powerCost;
    }

    public boolean canAttack() {
        return power >= standardAttackPowerCost && !cannotAttack;
    }

    public int attack(Character opponent) {
        if (!canAttack()) {
            return 0;
        }

        int damage = standardAttackDamage;

        if (isWeakened) {
            damage = damage / 2;
        }

        opponent.takeDamage(damage);
        usePower(standardAttackPowerCost);

        return damage;
    }

    public abstract int special(Character opponent);

    public abstract boolean canUseSpecial();

    public void updateStatus() {
        if (weakenedTurns > 0) {
            weakenedTurns--;
            if (weakenedTurns == 0) {
                isWeakened = false;
            }
        }

        if (cannotAttackTurns > 0) {
            cannotAttackTurns--;
            if (cannotAttackTurns == 0) {
                cannotAttack = false;
            }
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public int getPower() {
        return power;
    }
}
Character.java
External
Displaying Character.java.
