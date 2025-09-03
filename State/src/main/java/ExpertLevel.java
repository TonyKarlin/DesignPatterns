public class ExpertLevel extends State{
    private final String[] options = {"Train", "Meditate", "Fight", "Quit"};

    public ExpertLevel(Character character) {
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
