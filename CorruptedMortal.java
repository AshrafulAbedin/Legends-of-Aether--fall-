
public class CorruptedMortal extends Character{
    public CorruptedMortal()
    {
        super("CorruptedMortal", 90, 90, 18, 9);
    }
    @Override
    public boolean canUseSpecial() {
        
        return power >= 20;
    }

    @Override
    public int special(Character opponent) {
        
        if (!canUseSpecial()) {
            return 0;
        }
        
        int damage = 25; 
        
        opponent.takeDamage(damage);
    
        usePower(20);
        
        return damage;
    }
}
CorruptedMortal.java
External
Displaying CorruptedMortal.java.
