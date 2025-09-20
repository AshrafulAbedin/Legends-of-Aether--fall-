
public class Archer extends Character{
    public Archer(String name)
    {
        super(name, 100, 100, 15, 8);
    }
    @Override
     public boolean canUseSpecial()
     {
        return power >= 25;
     }
     public boolean canUseMultiShot() {
        return power >= 50; 
    }
    @Override
    public int special(Character opponent) {
        
        
        if (canUseMultiShot()) {
            
            return multiShot(opponent);
        } else if (canUseSpecial()) {
            
            return quickShot(opponent);
        } else {
            
            return 0;
        }
    }
    

    public int quickShot(Character opponent) {
        if (power < 25) {
            return 0; 
        }
        
        int damage = 30; 
        
        if (isWeakened) {
            damage = damage / 2;
        }
        
        opponent.takeDamage(damage);
        usePower(25);
        
        return damage;
    }
    
    public int multiShot(Character opponent) {
        if (power < 50) {
            return 0; 
        }
        
        int damage = 60; 
        
        if (isWeakened) {
            damage = damage / 2;
        }
        
        opponent.takeDamage(damage);
        usePower(50);
        
        return damage;
    }
}
Archer.java
External
Displaying Archer.java.
