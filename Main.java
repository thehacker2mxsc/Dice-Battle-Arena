import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Fighter> fighters = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        fighters.add(new Fighter("Assassin", 300, 15));
        fighters.add(new Fighter("Golem", 400 , 10));
        fighters.add(new Fighter("Goblin", 350, 12));
        fighters.add(new Fighter("Reaper", 250, 20));
        fighters.add(new Fighter("Smasher", 400, 10));

        System.out.println("Battle Start!");

        int playersTurn = 0;
        boolean thereIsWinner = false;

        while(!thereIsWinner) {

            boolean specialSkill = false;

            int eliminatedPlayerCount = 0;

            for (Fighter f : fighters) {
                if (f.getHP() <= 0) {
                    eliminatedPlayerCount++;
                }
            }

            //  FIX 1: correct win check (kept in same place)
            if (eliminatedPlayerCount >= fighters.size() - 1) {
                thereIsWinner = true;
                System.out.println("Game Over!");
                break;
            }

            //  FIX 2: safe turn skipping dead players (same block structure)
            while (playersTurn < fighters.size() &&
                    fighters.get(playersTurn).getHP() <= 0) {

                playersTurn++;

                if (playersTurn >= fighters.size()) {
                    playersTurn = 0;
                }
            }

            // Show player
            fighters.get(playersTurn).showStats();

            ArrayList<Integer> opponentIndexList = new ArrayList<>();

            System.out.println("List of Opponents: ");
            int printIndex = 1;

            for (int i = 0; i < fighters.size(); i++) {
                Fighter f = fighters.get(i);

                if (f.getHP() > 0 && i != playersTurn) {
                    System.out.println(printIndex + ". " + f.getName() + " : " + f.getHP());
                    opponentIndexList.add(i); //  FIX 3: correct indexing
                    printIndex++;
                }
            }

            System.out.print("Enter opponent number: ");

            int choosenOpponent;

            while (true) {
                choosenOpponent = scan.nextInt() - 1;

                if (choosenOpponent >= 0 && choosenOpponent < opponentIndexList.size()) {
                    break;
                } else {
                    System.out.println("Enter valid number (1-" + opponentIndexList.size() + ")");
                }
            }

            int choosenOpponentIndex = opponentIndexList.get(choosenOpponent);

            // Skill check (UNCHANGED STRUCTURE)
            if (fighters.get(playersTurn).getSkillRage() >= 75) {

                System.out.print("Would you like to use your skill? y/n: ");
                char skill = scan.next().charAt(0);

                if (Character.toLowerCase(skill) == 'y') {
                    specialSkill = true;
                }
            }

            int damage1 = BattleUtils.strikeAttack(
                    fighters.get(playersTurn),
                    fighters.get(choosenOpponentIndex),
                    fighters.get(playersTurn).getAttackPower(),
                    specialSkill
            );

            System.out.println("Damage: " + damage1);

            //  FIX 4: safe turn switching (no structure change, just improved)
            do {
                playersTurn++;

                if (playersTurn >= fighters.size()) {
                    playersTurn = 0;
                }

            } while (fighters.get(playersTurn).getHP() <= 0);
        }

        scan.close();
    }
}