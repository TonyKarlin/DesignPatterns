package Interfaces;

public abstract class Components {
    protected String name;
    protected double salary;

    public Components(String name) {
        this.name = name;
//        this.salary = salary;
    }

    public abstract double getSalary();

    public abstract void add(Components component);
    public abstract void remove(Components component);
    public abstract Components getChild(int index);
}
