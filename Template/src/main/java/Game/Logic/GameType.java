package Game.Logic;

public enum GameType {
    POKER(5),
    HOLDEM(2);

    private final int value;

    GameType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
