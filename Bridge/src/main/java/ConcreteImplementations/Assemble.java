package ConcreteImplementations;

import Abstractions.Workshop;

public class Assemble implements Workshop {
    @Override
    public void work() {
        System.out.println("  Assembled");
    }
}
