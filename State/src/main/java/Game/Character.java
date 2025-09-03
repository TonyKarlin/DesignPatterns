package Game;

import Levels.*;

public class Character {
    private final String name;
    private State level;
    private int xp;
    private int maxHp = 4;
    private int hp;

    public Character(String name) {
        this.name = name;
        this.hp = maxHp;
        level = new NoviceLevel(this);
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void growMaxHp(int amount) {
        maxHp += amount;
        hp = maxHp;
    }

    public int getXp() {
        return xp;
    }

    public State getLevel() {
        return level;
    }

    public void gainXp(int amount) {
        xp += amount;
        levelUp();
    }

    public void hit(int damage) {
        this.hp -= damage;
    }

    public void levelUp() {
        if (xp >= 6) {
            System.out.println("\nYou've leveled up to Master Tier!");
            System.out.println("You've gained +8 to Maximum Hit points.");
            level = new MasterLevel(this);
        } else if (xp >= 3) {
            System.out.println("\nYou've leveled up to Expert Tier!");
            System.out.println("You've gained +4 to Maximum Hit points.");
            level = new ExpertLevel(this);
        } else if (xp >= 1) {
            System.out.println("\nYou've leveled up to Intermediate Tier!");
            System.out.println("You've gained +2 to Maximum Hit points.");
            level = new IntermediateLevel(this);
        }
    }

    public void attack(Character opponent) {
        try {
            Thread.sleep(1500);
            if (opponent.getHp() > 0) {
                System.out.println(opponent.name + " has " + opponent.getHp() + " HP remaining.");
                int attackRoll = (int) (Math.random() * 3);
                System.out.println("You hit for " + attackRoll + " damage.\n");
                opponent.hit(attackRoll);
            } else System.out.println("You've defeated your opponent!!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void printInfo() {
        System.out.println("\n" + getName());
        System.out.println("Current Level: " + getLevel().toString());
        System.out.println("Current Experience: " + getXp());
        System.out.println("Current HP: " + getHp() + "/" + maxHp + "\n");
    }
}
