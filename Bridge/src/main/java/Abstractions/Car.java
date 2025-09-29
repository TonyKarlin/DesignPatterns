package Abstractions;

import java.util.List;

public class Car extends Vehicle {

    public Car(List<Workshop> workshops) {
        super(workshops);
    }

    @Override
    public void manufacture() {
        System.out.println("\nCar:");
        for (Workshop workshop : workshops) {
            workshop.work();
        }
    }
}
