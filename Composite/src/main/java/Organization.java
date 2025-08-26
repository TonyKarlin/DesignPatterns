import Interfaces.Components;

import java.util.ArrayList;
import java.util.List;

public class Organization extends Components {
    protected double salary;
    private final List<Components> children = new ArrayList<>();

    public Organization(String name) {
        super(name);

    }

    @Override
    public void printSalary() {
        System.out.println("Organization: " + name);
        System.out.println("Total amount of paid salaries: " + getSalary() + "€");
    }

    @Override
    public double getSalary() {
        this.salary = 0;
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

    @Override
    public int getChildCount() {
        return children.size();
    }

}
