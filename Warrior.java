public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 120, 100, 12, 5);
    }

    @Override
    public boolean canUseSpecial() {
        return power > 35;
    }

    @Override
    public int special(Character opponent) {
        if (!canUseSpecial()) {
            return 0;
        }
        int damage = 35;
        if (isWeakened) {
            damage = damage/2;
        }
        opponent.takeDamage(damage);
        usePower(35);

        return damage;
    }

}
