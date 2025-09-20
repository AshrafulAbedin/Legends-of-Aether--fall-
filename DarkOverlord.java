
public class DarkOverlord extends Character {
    public DarkOverlord() {
        super("DarkOverload", 200, 150, 25, 17);
    }

    @Override
    public boolean canUseSpecial() {
        return power >= 40;
    }

    @Override
    public int special(Character opponent) {
        if (!canUseSpecial()) {
            return 0;
        }
        int damage = 50;
        opponent.takeDamage(damage);

        opponent.isWeakened = true;
        opponent.weakenedTurns = 3;

        usePower(40);

        return damage;
    }
}
DarkOverlord.java
External
Displaying DarkOverlord.java.
