public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        Thread t1 = new Thread(weatherStation);
        Observer obs1 = new ObservingWeather("Foreca", weatherStation);
        Observer obs2 = new ObservingWeather("Ilmatieteen laitos", weatherStation);

        t1.start();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (!weatherStation.getRunning()) return;
        weatherStation.removeObserver(obs1);
        weatherStation.activeObservers();

    }
}
