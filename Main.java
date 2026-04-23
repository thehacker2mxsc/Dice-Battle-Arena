import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Fighter> fighters = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        // Create fighters
        fighters.add(new Fighter("Assassin", 300, 15));
        fighters.add(new Fighter("Golem", 400 , 10));
        fighters.add(new Fighter("Goblin", 350, 12));
        fighters.add(new Fighter("Reaper", 250, 20));
        fighters.add(new Fighter("Smasher", 400, 10));

        // Turn-based simple battle simulation

        System.out.println("Battle Start!");

        boolean thereIsWinner = false; 
        boolean specialSkill = false;
        int playersTurn = 0;

        while(!thereIsWinner) {
            int eliminatedPlayer = 0;

            for (Fighter f : fighters) {
                if (f.getHP() <= 0) {
                    eliminatedPlayer++;
                }
            }

            if (eliminatedPlayer == (fighters.size() - 1)) {
                thereIsWinner = true;
            }

            if (playersTurn >= fighters.size()){
                playersTurn = 0;
            }

            System.out.println("Choose Player to Attack: ");

            Fighter current = fighters.get(playersTurn);
            int i = 1;
            for (Fighter f : fighters){

                if (!f.getName().equals(current.getName()) && f.getHP() > 0){
                    System.out.println(i + ". " + f.getName() + " : " + f.getHP());
                    i++;
                }
            }

            System.out.print("Enter opponent name you will attack: ");

            String  choosenOpponent = scan.nextLine();
            int choosenOpponentIndex = -1;
            int index = 0;
            for (Fighter f : fighters){
                if (choosenOpponent.equals(f.getName())){
                    choosenOpponentIndex = index;
                }
                index++;
            }
            
            if (choosenOpponentIndex != -1){
                if (fighters.get(playersTurn).getSkillRage() >= 75){
                char skill;

                System.out.println("Would you like to use your skill? y/n: ");
                skill = scan.next().charAt(0);

                if (Character.toLowerCase(skill) == 'y') {
                    specialSkill = true;
                }
                }else {
                    System.out.println("Skill not yet available.");
                }

                int damage1 = BattleUtils.strikeAttack(
                fighters.get(playersTurn),
                fighters.get(choosenOpponentIndex),
                fighters.get(0).getAttackPower(),
                specialSkill);


                System.out.println("" + damage1);
            }else {
                System.out.println("Invalid Attack!");
            }

            

            specialSkill = false;
            playersTurn++;
        }
    }
}

            /*
            fighters.get(1).damageReceive(damage1);

            System.out.println(fighters.get(0).getName() + " dealt " + damage1 + " damage to " + fighters.get(1).getName());
            System.out.println(fighters.get(1).getName() + " HP: " + fighters.get(1).getHP());

            if (fighters.get(1).getHP() <= 0) {
                System.out.println(fighters.get(1).getName() + " is eliminated!");
                break;
            }

            // Player 2 attack
            int damage2 = BattleUtils.strikeAttack(fighters.get(1).getAttackPower());
            fighters.get(0).damageTaken(damage2);

            System.out.println(fighters.get(1).getName() + " dealt " + damage2 + " damage to " + fighters.get(0).getName());
            System.out.println(fighters.get(0).getName() + " HP: " + fighters.get(0).getHP());

            if (fighters.get(0).getHP() <= 0) {
                System.out.println(fighters.get(0).getName() + " is eliminated!");
                break;
            }

            System.out.println("------------------------");*/