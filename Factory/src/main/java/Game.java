import Maps.CityMap;
import Maps.Map;
import Maps.WildernessMap;

import java.util.Scanner;

public class Game {

    public void createMap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which Map would you like to play: ");
        System.out.println("1. CityMap");
        System.out.println("2. WildernessMap");

        int choice = sc.nextInt();

        if (choice == 1) {
            Map city = new CityMap();
            city.display(10, 8);
        } else if (choice == 2) {
            Map wild = new WildernessMap();
            wild.display(10, 8);
        } else {
            System.out.println("Invalid input. Please enter a choice between 1 & 2.");
        }
    }
}
