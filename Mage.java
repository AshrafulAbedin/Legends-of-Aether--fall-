
public class Mage extends Character {
    public Mage(String name) {
        super(name, 80, 100, 20, 10);
    }

    @Override
    public boolean canUseSpecial() {
        return power >= 30;
    }

    @Override
    public int special(Character opponent) {
        if (!canUseSpecial()) {
            return 0;
        }
        int damage = 40;

        if (isWeakened) {
            damage = damage / 2;
        }
        opponent.takeDamage(damage);

        usePower(30);

        return damage;
    }

    public int castSpell(Character opponent) {
        return special(opponent);
    }
}
Mage.java
External
Displaying Mage.java.
