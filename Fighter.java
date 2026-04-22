import java.util.*;
import java.util.ArrayList;

class Fighter{
    private String name;
    private int HP;
    private int attackPower;

    public Fighter(String name, int HP, int attackPower){
        this.name = name;
        this.HP = HP;
        this.attackPower = attackPower;
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

    // Methods
    public void damageTaken(int attackDamage){
    
        if (HP < attackDamage){
             HP = 0;
        }else {
             HP -= attackDamage;
        }
    }
}