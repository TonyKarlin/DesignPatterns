package Levels;

import Game.Character;

public class ExpertLevel extends State {
    private final String[] options = {"Train", "Meditate", "Fight", "Quit"};
    private final int healthGrowth = 4;

    public ExpertLevel(Character character) {
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
        Character opponent = new Character("Thanos >:)");
        while (opponent.getHp() > 0) {
            character.attack(opponent);
        }
        System.out.println("You've defeated Thanos and Mastered the art of combat!!");
        System.out.println(">> LEVEL UP <<");
    }
}
