import Maps.CityMap;
import Maps.Map;
import Maps.WildernessMap;

import java.util.Scanner;

public class Game {

    public void createMap() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Which Map would you like to play: ");
        if (sc.nextInt() == 1) {
            Map map = new CityMap();
            map.display(10, 8);
        } else if (sc.nextInt() == 2) {
            Map map = new WildernessMap();
            map.display(10, 8);
        } else {
            System.out.println("Invalid input. Please enter a choice between 1 & 2.");
        }
    }
}
