import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Runnable {
    private final List<Observer> observers = new ArrayList<>();
    private int temperature;


    public WeatherStation() {
        this.temperature = (int) ((Math.random() < 0.5 ? -1 : 1) * (Math.random() * 30));
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        System.out.println("Simulation started!");
        System.out.println("Starting temperature " + getTemperature() + "°C\n");

        do {
            try {
                Thread.sleep((int) (Math.random() * 2001) + 1000);
                int rand = (int) (Math.random() * 3);
                if ((rand == 1 && temperature < 45) || (rand == 0 && temperature > -40)) {
                    temperature += (rand == 1) ? 1 : -1;
                    notifyObservers();
                } else System.out.println("Temperature remains the same: " + temperature + "°C\n");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (System.currentTimeMillis() - start < 60000);

        System.out.println("Simulation ended!");
    }

    public void activeObservers() {
        System.out.println("\nCurrently active observers: ");
        for (Observer observer : observers) {
            System.out.println(observer.getName());
        }
        System.out.println();
    }

    public void addObserver(Observer observer) {
        System.out.println(observer.getName() + " has been added as an observer!");
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        System.out.println(observer.getName() + " has been removed from observers!");
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
