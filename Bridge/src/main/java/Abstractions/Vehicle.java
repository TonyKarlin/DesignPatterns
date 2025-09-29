package Abstractions;

import java.util.List;

public abstract class Vehicle {
    protected List<Workshop> workshops;

    protected Vehicle(List<Workshop> workshops) {
        this.workshops = workshops;
    }

    abstract public void manufacture();
}
