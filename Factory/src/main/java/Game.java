import Maps.CityMap;
import Maps.Map;
import Maps.WildernessMap;

import java.util.Scanner;

public class Game {

    public int menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which Map would you like to play: ");
        System.out.println("1. CityMap");
        System.out.println("2. WildernessMap");

        return sc.nextInt();
    }

    public void createMap(int id) {
        if (id == 1) {
            Map city = new CityMap();
            city.display(10, 8);
        } else if (id == 2) {
            Map wild = new WildernessMap();
            wild.display(10, 8);
        } else {
            System.out.println("Invalid input. Please enter a choice between 1 & 2.");
        }
    }
}
