package Builders;

import ConcreteClasses.Computer;

public interface ComputerBuilder {
    void buildProcessor(String type);

    void buildRAM(String size);

    void buildGraphicsCard(String type);

    void buildHardDrive(String size);

    void buildOS(String name);

    Computer getComputer();
}
