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

    }}