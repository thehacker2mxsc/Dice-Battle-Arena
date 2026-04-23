    import java.util.Random;

    public class BattleUtils{
        static Random rand = new Random();

        static int strikeAttack(){
            return rand.nextInt(10) + 1;
        }

        static int strikeAttack(int attackPower){
                //damageTaken(0);
                return attackPower * 2;
        }

        static int strikeAttack(Fighter attacker, Fighter opponent, int attackPower, boolean specialSkill){
            boolean criticalHit = rand.nextBoolean();

            if (criticalHit && specialSkill){
                attackPower += strikeAttack(); 
                opponent.damageReceive(attackPower);
                return strikeAttack(attackPower);
            }else if(criticalHit){
                attackPower += strikeAttack(); 
                attacker.damageTaken(attackPower);
                opponent.damageReceive(attackPower);
                return attackPower;
            }else if(specialSkill){
                attackPower = strikeAttack(attackPower);
                opponent.damageReceive(attackPower);
                return attackPower;
            }else{
                opponent.damageReceive(attackPower);
                attacker.damageTaken(attackPower);
                return attackPower;
            }
        }

        
    }

    /*public void strikeAttack(Fighter enemy){
            
            if (enemy.getHP() <= 0){
                System.out.println("Player is already eliminated.");
                return;
            }

            int damage = strikeAttack(getAttackPower());
            enemy.damageTaken(damage);

            System.out.println(getName() + " receive " + damage + " damage from" + enemy.getName());
        }*/