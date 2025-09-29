package ConcreteImplementations;

import Abstractions.Workshop;

public class Deliver implements Workshop {
    Inspection inspection;

    public Deliver(Inspection inspection) {
        this.inspection = inspection;
    }

    @Override
    public void work() {
        if (inspection.isApproved()) {
            System.out.println("    Delivered.");
        } else {
            System.out.println("    Delivery failed due to failed inspection.");
        }
    }
}
