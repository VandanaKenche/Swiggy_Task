import java.util.Random;

public class MagicalArena {

    public static class Player {
        private int health;
        private int strength;
        private int attack;

        public Player(int health, int strength, int attack) {
            this.health = health;
            this.strength = strength;
            this.attack = attack;
        }

        public int getHealth() {
            return health;
        }

        public int getStrength() {
            return strength;
        }

        public int getAttack() {
            return attack;
        }

        public void takeDamage(int damage) {
            this.health -= damage;
            if (this.health < 0) {
                this.health = 0;
            }
        }

        public boolean isAlive() {
            return this.health > 0;
        }

        public int rollDice() {
            return (new Random().nextInt(6)) + 1;
        }
    }

    public static class Arena {
        private Player player1;
        private Player player2;

        public Arena(Player player1, Player player2) {
            this.player1 = player1;
            this.player2 = player2;
        }

        public void startFight() {
            Player attacker, defender;

            if (player1.getHealth() < player2.getHealth()) {
                attacker = player1;
                defender = player2;
            } else {
                attacker = player2;
                defender = player1;
            }

            while (player1.isAlive() && player2.isAlive()) {
                System.out.println("Attacker: " + (attacker == player1 ? "Player 1" : "Player 2"));
                int attackDice = attacker.rollDice();
                int defendDice = defender.rollDice();

                int damage = attacker.getAttack() * attackDice - defender.getStrength() * defendDice;
                damage = Math.max(damage, 0);

                defender.takeDamage(damage);
                System.out.println("Attacker rolls: " + attackDice + " | Defender rolls: " + defendDice);
                System.out.println("Damage dealt: " + damage);
                System.out.println("Defender's health: " + defender.getHealth());

                Player temp = attacker;
                attacker = defender;
                defender = temp;
            }

            if (player1.isAlive()) {
                System.out.println("Player 1 wins!");
            } else {
                System.out.println("Player 2 wins!");
            }
        }
    }

    public static void main(String[] args) {
        Player player1 = new Player(50, 5, 10);
        Player player2 = new Player(100, 10, 5);

        Arena arena = new Arena(player1, player2);
        arena.startFight();
    }

}