import java.util.Scanner;

public class Game {
    private Character player;

    public Game() {
    }

    public void start() {
        player = new Character(chooseName());
        play();
    }

    public String chooseName() {
        System.out.println("Choose your character's name");
        System.out.print("Enter: ");
        return UserInputs.scanner.nextLine();
    }

    private void play() {
        try {
            System.out.println("\nWelcome challenger " + player.getName() + "!");
            System.out.println("Challenge awaits. Your journey begins as a " + player.getLevel().toString() + ".");
            while (!player.getLevel().toString().equalsIgnoreCase("Master")) {
                if (player.getLevel() == null) {
                    System.out.println("Character has no level");
                    return;
                }

                String playerAction = player.getLevel().action();

                if (playerAction.equals("EXIT")) {
                    System.out.println("\nExiting program...");
                    return;
                }
            }
            System.out.println("You've MASTERED the Game!");
            Thread.sleep(1000);
            System.out.println("Exiting...");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
