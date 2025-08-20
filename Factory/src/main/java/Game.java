import Maps.CityMap;
import Maps.Map;
import Maps.WildernessMap;

import java.util.Scanner;

public class Game {

    public int menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which Map would you like to play: ");
        System.out.println("1. City");
        System.out.println("2. Wilderness");
        System.out.print("Select: ");

        return sc.nextInt();
    }

    public void createMap() {
        int id;
        do {
            id = menu();
            if (id == 1) {
                Map city = new CityMap();
                System.out.println("\nMAP:  CITY \n");
                city.display(10, 8);
            } else if (id == 2) {
                Map wild = new WildernessMap();
                System.out.println("\nMAP:  WILDERNESS \n");
                wild.display(10, 8);
            } else {
                System.out.println("Invalid input. Please enter a choice between 1 & 2.\n");
            }
        } while(id != 1 && id != 2);

    }
}
