
public class RegionalWarlord extends Character{
    public RegionalWarlord()
    {
        super("RegionalWarload", 130, 110, 20, 10);
    }
    @Override
    public boolean canUseSpecial() {
        
        return power >= 35;
    }

    @Override
    public int special(Character opponent) {

        if (!canUseSpecial()) {
            return 0;
        }
        
        int damage = 30; 
        
        opponent.takeDamage(damage);

        opponent.cannotAttack = true;
        opponent.cannotAttackTurns = 3; 
        
        
        usePower(35);
        
        return damage;
    }
}
RegionalWarlord.java
External
Displaying RegionalWarlord.java.
