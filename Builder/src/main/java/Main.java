import Builders.ComputerBuilder;
import Builders.GamingComputerBuilder;
import Builders.OfficeComputerBuilder;
import ConcreteClasses.Director;

public class Main {
    public static void main(String[] args) {
        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        Director officeDirector = new Director(officeBuilder);
        Director gamingDirector = new Director(gamingBuilder);


        System.out.println("Building Office Computer:");
        officeDirector.buildOfficeComputer();


        System.out.println("\nBuilding Gaming Computer:");
        gamingDirector.buildGamingComputer();

    }
}
