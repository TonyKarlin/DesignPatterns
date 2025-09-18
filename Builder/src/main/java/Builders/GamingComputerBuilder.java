package Builders;

import ConcreteClasses.Component;
import ConcreteClasses.Computer;

public class GamingComputerBuilder implements ComputerBuilder {
    private final Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor(String type) {
        System.out.println("Processor: " + type);
        computer.addComponent(new Component(type));
    }

    @Override
    public void buildRAM(String size) {
        System.out.println("Amount of System RAM: " + size);
        computer.addComponent(new Component(size));
    }

    @Override
    public void buildGraphicsCard(String type) {
        System.out.println("Graphics Card: " + type);
        computer.addComponent(new Component(type));
    }

    @Override
    public void buildHardDrive(String size) {
        System.out.println("Amount of System Storage: " + size);
        computer.addComponent(new Component(size));

    }

    @Override
    public void buildOS(String name) {
        System.out.println("Current Operating System: " + name);
        computer.addComponent(new Component(name));
    }

    public Computer getComputer() {
        return computer;
    }
}
