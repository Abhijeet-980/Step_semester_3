public class Problem1_HealthBar {
    public static void main(String[] args) {
        Character c = new Character(100);
        System.out.println("Max health: " + c.getMaxHealth());

        c.takeDamage(30);
        System.out.println("After 30 damage: " + c.getHealth());

        c.heal(50);
        System.out.println("After heal 50: " + c.getHealth());

        c.takeDamage(150);
        System.out.println("After 150 damage: " + c.getHealth());
    }
}

class Character {
    private final int maxHealth;
    private int health;

    Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    void takeDamage(int amount) {
        int newHealth = health - amount;
        if (newHealth < 0) {
            newHealth = 0;
        }
        health = newHealth;
    }

    void heal(int amount) {
        int newHealth = health + amount;
        if (newHealth > maxHealth) {
            newHealth = maxHealth;
        }
        health = newHealth;
    }

    int getHealth() {
        return health;
    }

    int getMaxHealth() {
        return maxHealth;
    }
}
