import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Create an array of fighters using ArrayList
        ArrayList<Fighter> fighters = new ArrayList<>();
        
        // Create a scanner function for the users input
        Scanner scan = new Scanner(System.in);

        // Create fighters
        fighters.add(new Fighter("Assassin", 300, 15));
        fighters.add(new Fighter("Golem", 400 , 10));
        fighters.add(new Fighter("Goblin", 350, 12));
        fighters.add(new Fighter("Reaper", 250, 20));
        fighters.add(new Fighter("Smasher", 400, 10));

        // Welcom message
        System.out.println("Battle Start!");

        // Initialize players turn as first fighter
        int playersTurn = 0;
        ArrayList<String> opponent = new ArrayList<>();

        // Create a boolean variable that determine for winner, skill and player's turn
        boolean thereIsWinner = false; 

        // Create a loop that runs if there is still no winner
        while(!thereIsWinner) {

            // Initialize the skill to false
            boolean specialSkill = false;

            // Create a variable that counts the players eliminated
            int eliminatedPlayerCount = 0;

            // Create a loop that checks the player that has 0 or below HP left
            for (Fighter f : fighters) {
                if (f.getHP() <= 0) {
                    eliminatedPlayerCount++;// Adds count to players with 0 or below HP left
                    playersTurn++;
                }else if(!f.getName().equals(fighters.get(playersTurn).getName())){
                    opponent.add(f.getName());
                }
            }

            // Check wether if the player with zero and below HP reaches players count minus one 
            if (eliminatedPlayerCount == (fighters.size() - 1)) {
                thereIsWinner = true;
                break;
            }

            // It resets if all player already made and attack minus the eliminated player
            if (playersTurn >= fighters.size() - eliminatedPlayerCount){
                playersTurn = 0;
            }


            // Get the stats of the current player to attack
            Fighter current = fighters.get(playersTurn);
            // Use for displaying purposes to player whom you will attack
            int printIndex = 1;

            // Show player status
            fighters.get(playersTurn).showStats();

            int opponentIndex = 0;
            
            // Display players choices to who you will attack
            System.out.println("Choose Player to Attack: ");
            for (Fighter f : fighters){
                    if (f.getName().equals(opponent.get(opponentIndex))){
                        System.out.println(printIndex + ". " + f.getName() + " : " + f.getHP());
                        printIndex++;
                        opponentIndex++;
                }
                    
            }

            System.out.print("Enter opponent name you will attack: ");

            int  choosenOpponent = scan.nextInt();
            /*
            int choosenOpponentIndex = -1;
            int findOpponentIndex = 0;
            for (Fighter f : fighters){
                if (choosenOpponent.toLowerCase().equals(f.getName().toLowerCase())){
                    choosenOpponentIndex = findOpponentIndex;
                }
                findOpponentIndex++;
            }*/
            
            if (choosenOpponent >= 0 &&  choosenOpponent <= opponent.size() - 1){
                if (fighters.get(playersTurn).getSkillRage() >= 75){
                char skill;

                System.out.println("Would you like to use your skill? y/n: ");
                skill = scan.next().charAt(0);

                if (Character.toLowerCase(skill) == 'y') {
                    specialSkill = true;
                }else if (Character.toLowerCase(skill) == 'n'){
                    System.out.println("You haven't used your skill.");
                }else{
                    System.out.println("Invalid input.\nSkill not used.");
                }

                }else {
                    System.out.println("Skill not yet available.");
                }

                int damage1 = BattleUtils.strikeAttack(
                fighters.get(playersTurn),
                fighters.get(choosenOpponent),
                fighters.get(playersTurn).getAttackPower(),
                specialSkill);

                System.out.println("" + damage1);
            }else {
                System.out.println("Invalid Attack!");
            }

            playersTurn++;
        }
    }
}