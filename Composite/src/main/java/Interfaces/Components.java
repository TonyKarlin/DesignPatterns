package Interfaces;

public abstract class Components {
    protected String name;

    public Components(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public abstract double getSalary();
    public abstract void printSalary();

    public abstract void add(Components component);
    public abstract void remove(Components component);
    public abstract Components getChild(int index);
    public abstract int getChildCount();
}
