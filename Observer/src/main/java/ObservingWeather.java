public class ObservingWeather extends Observer{
    private WeatherStation observable;

    public ObservingWeather(String name, WeatherStation observable) {
        super(name);
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Observer: " + this.getName());
        System.out.println("Has been notified of the temperature changes!");
    }
}
