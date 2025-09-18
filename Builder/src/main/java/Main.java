import Builders.ComputerBuilder;
import Builders.GamingComputerBuilder;
import Builders.OfficeComputerBuilder;
import ConcreteClasses.Director;

public class Main {
    public static void main(String[] args) {
//        ComputerBuilder builder = new OfficeComputerBuilder();
        ComputerBuilder builder = new GamingComputerBuilder();
        Director director = new Director(builder);
//        director.buildOfficeComputer();
        director.buildGamingComputer();
        builder.getComputer();
    }
}
