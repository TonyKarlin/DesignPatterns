public abstract class Observer {
    private final String name;

    public Observer(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract void update();
}
