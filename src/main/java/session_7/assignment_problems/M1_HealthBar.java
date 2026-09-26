package session_7.assignment_problems;

public class M1_HealthBar {

    static class Character {

        private int health;
        private final int maxHealth;

        // Constructor
        Character(int maxHealth) {
            this.maxHealth = maxHealth;
            this.health = maxHealth;
        }

        // Take damage
        void takeDamage(int amount) {

            health = health - amount;

            if (health < 0) {
                health = 0;
            }
        }

        // Heal
        void heal(int amount) {

            health = health + amount;

            if (health > maxHealth) {
                health = maxHealth;
            }
        }

        // Read-only health
        int getHealth() {
            return health;
        }
    }

    public static void main(String[] args) {

        Character c = new Character(100);

        c.takeDamage(30);
        System.out.println(
            "Health after damage: " + c.getHealth()
        );

        c.heal(50);
        System.out.println(
            "Health after healing: " + c.getHealth()
        );

        c.takeDamage(150);
        System.out.println(
            "Health after extra damage: " + c.getHealth()
        );
    }
}