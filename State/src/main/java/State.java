public abstract class State {
    public final Character character;

    public State(Character character) {
        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }

    public String action() {
        character.printInfo();
        int choice = UserInputs.readUserInput(character.getLevel().getOptions());
        if (choice >= 1 && choice <= getOptions().length - 1) {
            System.out.println("You chose to " + getOptions()[choice - 1]);
            switch (getOptions()[choice - 1]) {
                case "Train":
                    this.train();
                    character.gainXp(Experience.TRAIN.getValue());
                    break;

                case "Meditate":
                    this.meditate();
                    character.gainXp(Experience.MEDITATE.getValue());
                    break;

                case "Fight":
                    this.fight();
                    character.gainXp(Experience.FIGHT.getValue());
                    break;
            }
        } else if (choice == getOptions().length) {
            return "EXIT";
        }
        return "";
    }

    abstract String[] getOptions();

    abstract void train();

    abstract void meditate();

    abstract void fight();

    @Override
    public String toString() {
        return this.getClass().getSimpleName().replace("Level", "");
    }
}
