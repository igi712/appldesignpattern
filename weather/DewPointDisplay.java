public class DewPointDisplay implements Observer, DisplayElement {
    private float dewPoint = 0.0f;
    private WeatherData weatherData;

    public DewPointDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    // Rumus sederhana dew point (approximation)
    private float computeDewPoint(float temp, float humidity) {
        double a = 17.27;
        double b = 237.7;
        double alpha = ((a * temp) / (b + temp)) + Math.log(humidity / 100.0);
        return (float)((b * alpha) / (a - alpha));
    }

    public void update(float temp, float humidity, float pressure) {
        dewPoint = computeDewPoint(temp, humidity);
        display();
    }

    public void display() {
        System.out.println("Dew point is " + dewPoint);
    }
}
