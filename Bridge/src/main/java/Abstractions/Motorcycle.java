package Abstractions;

import java.util.List;

public class Motorcycle extends Vehicle {

    public Motorcycle(List<Workshop> workshops) {

        super(workshops);
    }

    @Override
    public void manufacture() {
        System.out.println("\nMotorcycle:");
        for (Workshop workshop : workshops) {
            workshop.work();
        }
    }
}
