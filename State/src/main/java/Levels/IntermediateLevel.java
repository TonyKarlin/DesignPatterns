package Levels;

import Game.Character;

public class IntermediateLevel extends State {
    private final String[] options = {"Train", "Meditate", "Quit"};
    private final int healthGrowth = 2;

    public IntermediateLevel(Character character) {
        super(character);
        character.growMaxHp(healthGrowth);
    }

    public String[] getOptions() {
        return options;
    }

    @Override
    public void train() {
        try {
            System.out.println("You've initiated your training...");
            Thread.sleep(2500);
            System.out.println("Working your way up!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void meditate() {
        try {
            System.out.println("You begin to meditate...");
            Thread.sleep(1500);
            System.out.println("You look within...");
            Thread.sleep(2000);
            System.out.println("You feel calm and centered.");
            System.out.println("Growing more confident before entering battle!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void fight() {
        System.out.println("You should prepare a little bit more before entering a battle.");
        System.out.println("Come back when you're ready! (Requires Expert Level)");
    }
}
