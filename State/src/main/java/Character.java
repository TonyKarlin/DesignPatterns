import java.util.Scanner;

public class Character {
    private final String name;
    private State level;
    private int xp;
    private final int maxHp = 10;
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

    public void levelUp() {
        if (xp >= 6) {
            System.out.println("\nYou've leveled up to Master Tier!");
            level = new MasterLevel(this);
        } else if (xp >= 3) {
            System.out.println("\nYou've leveled up to Expert Tier!");
            level = new ExpertLevel(this);
        } else if (xp >= 1) {
            System.out.println("\nYou've leveled up to Intermediate Tier!");
            level = new IntermediateLevel(this);
        }
    }

    public void printInfo() {
        System.out.println("\n" + getName());
        System.out.println("Current Level: " + getLevel().toString());
        System.out.println("Current Experience: " + getXp());
        System.out.println("Current HP: " + getHp() + "/" + maxHp + "\n");
    }
}
