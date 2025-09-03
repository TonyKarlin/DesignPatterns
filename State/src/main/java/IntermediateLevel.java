public class IntermediateLevel extends State {
    private final String[] options = {"Train", "Meditate", "Quit"};

    public IntermediateLevel(Character character) {
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

    }

    @Override
    public void fight() {

    }
}
