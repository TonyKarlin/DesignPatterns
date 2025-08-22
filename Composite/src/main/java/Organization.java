import Interfaces.Components;

import java.util.ArrayList;
import java.util.List;

public class Organization extends Components{
    protected String name;
    protected double salary;
    private final List<Components> children = new ArrayList<>();

    public Organization(String name) {
        super(name);

    }

    public String getName() {
        return name;
    }

    @Override
    public double getSalary() {
        for (Components child : children) {
            this.salary += child.getSalary();
        }
        return this.salary;
    }

    @Override
    public void add(Components component) {
        this.children.add(component);
    }

    @Override
    public void remove(Components component) {
        this.children.remove(component);
    }

    @Override
    public Components getChild(int index) {
        return this.children.get(index);
    }

    public static void main(String[] args) {
        Components org = new Organization("Apple");
        Components dep1 = new Department("HR");
        Components dep2 = new Department("Sales");
        Components emp1 = new Employee("Alice", 50000);
        Components emp2 = new Employee("Bob", 48000);
        Components emp3 = new Employee("Carl", 89000);
        dep1.add(emp1);
        dep1.add(emp2);
        dep2.add(emp3);
        org.add(dep1);
        org.add(dep2);
        double totalSalary = org.getSalary();
        System.out.println("Total amount of salaries: " + totalSalary);
    }
}
