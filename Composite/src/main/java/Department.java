import Interfaces.Components;

import java.util.ArrayList;
import java.util.List;

public class Department extends Components {
    private final List<Components> children = new ArrayList<>();
    private double salary;

    public Department(String name) {
        super(name);
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
}
