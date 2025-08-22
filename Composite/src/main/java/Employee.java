import Interfaces.Components;

public class Employee extends Components {
    private String name;
    private final double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public void add(Components component) {
        throw new UnsupportedOperationException("Not supported in leaf.");
    }

    @Override
    public void remove(Components component) {
        throw new UnsupportedOperationException("Not supported in leaf.");
    }

    @Override
    public Components getChild(int index) {
        throw new UnsupportedOperationException("Not supported in leaf.");
    }
}
