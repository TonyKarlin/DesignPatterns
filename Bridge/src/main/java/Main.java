import Abstractions.Car;
import Abstractions.Motorcycle;
import Abstractions.Vehicle;
import Abstractions.Workshop;
import ConcreteImplementations.Assemble;
import ConcreteImplementations.Deliver;
import ConcreteImplementations.Inspection;
import ConcreteImplementations.Produce;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Inspection inspection;
        List<Workshop> workshops = List.of(
                new Produce(),
                new Assemble(),
                inspection = new Inspection(),
                new Deliver(inspection)
        );

        Vehicle vehicle1 = new Car(workshops);

        vehicle1.manufacture();

        Vehicle vehicle2 = new Motorcycle(workshops);

        vehicle2.manufacture();
    }
}
