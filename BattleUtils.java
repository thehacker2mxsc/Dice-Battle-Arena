import java.util.Random;

public class Fighter extends BattleUtils{
    static Random rand = new Random();

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

    static int strikeAttack(int attackPower, int choosenPlayer){
        if (super.HP >= 0){
            System.out.println("Player is already eliminated.");
        }else {
            super.damageTaken(attackPower);
        }
    }
}