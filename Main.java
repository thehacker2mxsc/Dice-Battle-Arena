public class Main {
    public static void main(String[] args) {

        // Create fighters
        Fighter p1 = new Fighter("Ron", 100, 20);
        Fighter p2 = new Fighter("Alex", 100, 15);

        // Turn-based simple battle simulation

        System.out.println("Battle Start!");

        while (p1.getHP() > 0 && p2.getHP() > 0) {

            // Player 1 attack
            int damage1 = BattleUtils.strikeAttack(p1.getAttackPower());
            p2.damageTaken(damage1);

            System.out.println(p1.getName() + " dealt " + damage1 + " damage to " + p2.getName());
            System.out.println(p2.getName() + " HP: " + p2.getHP());

            if (p2.getHP() <= 0) {
                System.out.println(p2.getName() + " is eliminated!");
                break;
            }

            // Player 2 attack
            int damage2 = BattleUtils.strikeAttack(p2.getAttackPower());
            p1.damageTaken(damage2);

            System.out.println(p2.getName() + " dealt " + damage2 + " damage to " + p1.getName());
            System.out.println(p1.getName() + " HP: " + p1.getHP());

            if (p1.getHP() <= 0) {
                System.out.println(p1.getName() + " is eliminated!");
                break;
            }

            System.out.println("------------------------");
        }

        System.out.println("Battle End!");
    }
}