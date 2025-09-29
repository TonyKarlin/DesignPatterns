package ConcreteImplementations;

import Abstractions.Workshop;

public class Inspection implements Workshop {
    private boolean approved;

    @Override
    public void work() {
        int rand = (int) (Math.random() * 2);
        System.out.println("   Inspection:");
        approved = rand == 0;

        if (approved) {
            System.out.println("      Approved");
        } else {
            System.out.println("      Not Approved");
        }
    }

    public boolean isApproved() {
        return approved;
    }
}
