import java.util.Random;

public class BattleUtils extends Fighter{
    static Random rand = new Random();

    public BattleUtils(String name, int HP, int attackPower){
        super(name, HP , attackPower);
    }

    static int strikeAttack(){
        return rand.nextInt(10) + 1;
    }

    static int strikeAttack(int attackPower){
        boolean criticalHit = rand.nextBoolean();
        
        if (criticalHit){
            return attackPower + strikeAttack();
        }else{
            return attackPower;
        }
    }

    public void strikeAttack(Fighter enemy){
        
        if (enemy.getHP() <= 0){
            System.out.println("Player is already eliminated.");
            return;
        }

        int damage = strikeAttack(getAttackPower());
        enemy.damageTaken(damage);

        System.out.println(getName() + " receive " + damage + " damage from" + enemy.getName());
    }
}