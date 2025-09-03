public class IntermediateLevel extends State{
    private final String[] options = {"Train", "Meditate", "Quit"};

    public IntermediateLevel(Character character) {
        super(character);
    }

    public String[] getOptions() {
        return options;
    }

    @Override
    public void train() {

    }

    @Override
    public void meditate() {

    }

    @Override
    public void fight() {

    }
}
