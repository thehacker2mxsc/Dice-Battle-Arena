import java.util.*;
import java.util.ArrayList;

class Fighter{
    private String name;
    private int HP;
    private int attackPower;
    private int skillRage;

    public Fighter(String name, int HP, int attackPower){
        this.name = name;
        this.HP = HP;
        this.attackPower = attackPower;
        skillRage = 0;
    }

    //Setters
    public void setName(String name){
        if (name == null || name.trim().isEmpty()){
            System.out.println("Please enter your fighter's name.");
        }else{
            this.name = name;
        }
    }

    public void setHP(int HP){
        this.HP = HP;
    }

    public void setAttackPower(int attackPower){
        this.attackPower = attackPower;
    }

    // Getters
    public String getName(){return  name;}
    public int getHP(){return HP;}
    public int getAttackPower(){return attackPower;}
    public int getSkillRage(){return skillRage;}

    // Methods
    public void damageReceive(int attackDamage){
    
        if (HP < attackDamage){
            HP = 0;
        }else {
            HP -= attackDamage;
        }
    }

    public void damageTaken(int damageTaken){
        skillRage += damageTaken;
    }

    public int resetDamageTaken(){
        return skillRage = 0;
    }

    public void showStats(){
        System.out.println("Player's Turn: " + name);
        System.out.println("HP Left: " + HP);
        System.out.println("Skill Rage: " + skillRage + "\n");
    }
}