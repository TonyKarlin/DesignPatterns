package ConcreteClasses;

import Builders.ComputerBuilder;

public class Director {
    private final ComputerBuilder builder;


    public Director(ComputerBuilder builder) {
        this.builder = builder;
    }

    public void buildOfficeComputer() {
        builder.buildOS("Windows 11");
        builder.buildHardDrive("512Gb");
        builder.buildRAM("16Gb");
        builder.buildProcessor("Intel i5 14600k");
    }

    public void buildGamingComputer() {
        builder.buildOS("Windows 10");
        builder.buildHardDrive("2Tb");
        builder.buildGraphicsCard("Nvidia RTX 5090");
        builder.buildRAM("32Gb");
        builder.buildProcessor("AMD Ryzen 7 9800X3D");
    }

}
