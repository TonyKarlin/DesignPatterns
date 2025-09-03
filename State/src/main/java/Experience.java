public enum Experience {
    TRAIN(1),
    MEDITATE(2),
    FIGHT(3);
    
    private final int value;
    
    Experience(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}

