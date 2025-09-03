package Levels;

import Game.Character;

public class NoviceLevel extends State {
    private final String[] options = {"Train", "Quit"};

    public NoviceLevel(Character character) {
        super(character);
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
        System.out.println("You've not learned meditating yet! You should train more.\n");
    }

    @Override
    public void fight() {
        System.out.println("You're a long way from fighting...");
        System.out.println("Come back after you're trained your body and mind!\n");
    }
}
