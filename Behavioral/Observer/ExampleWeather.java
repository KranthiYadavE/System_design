package Behavioral.Observer;

import java.util.ArrayList;
import java.util.List;

interface  Observer{
 
    void update();
 }

 class WeatherDisplay implements Observer{
   public WeatherData weatherdata;
   public WeatherDisplay(WeatherData weatherdata){
      this.weatherdata=weatherdata;
      weatherdata.addobserver(this);
   }
    @Override
    public void update(){
      double temperature=weatherdata.gettemprature();
      double pressure=weatherdata.getpressure();
      System.out.println("temperature: "+ temperature + "pressure: "+ pressure);

    }
 }

 class StatisticalDisplay implements Observer{
    public WeatherData weatherdata;
    public StatisticalDisplay(WeatherData weatherdata){
      this.weatherdata=weatherdata;
      weatherdata.addobserver(this);
   }

     @Override
    public void update(){
      double temperature=weatherdata.gettemprature();
      double humidity=weatherdata.gethumidity();
      System.out.println("temperature: "+ temperature + "humidity: "+ humidity);

    }

 }

 
 class ForecastDisplay implements Observer {
    private WeatherData weatherData;
    private String name;
    
    public ForecastDisplay(String name, WeatherData weatherData) {
        this.name = name;
        this.weatherData = weatherData;
        weatherData.addobserver(this);
    }
    
    @Override
    public void update() {
        double temperature = weatherData.gettemprature();
        double pressure = weatherData.getpressure();
        double humidity = weatherData.gethumidity();
        
        String forecast = "Sunny";
        if (pressure < 1000) {
            forecast = "Rainy";
        } else if (humidity > 70) {
            forecast = "Cloudy";
        }
        
        System.out.println(name + " - Forecast: " + forecast + 
                         " (Temp: " + temperature + "°C)");
    }
}

abstract class Subject{
   private List<Observer> observers = new ArrayList<>();
   public void addobserver(Observer observer){
      observers.add(observer);
   }
   public void removeobserver(Observer observer){
      observers.remove(observer);
   }

   public void notifyObserver(){
      for(Observer observer : observers) {
    	observer.update();
    }
   }
}


class WeatherData extends Subject{

   private double temperature;
   private double pressure;
   private double humidity;
   public void setmeasurements(double temperature,double pressure,double humidity){
      this.temperature=temperature;
      this.humidity=humidity;
      this.pressure=pressure;
      notifyallObserver();

   }
   public void notifyallObserver(){
      notifyObserver();
   }
   public double gettemprature(){
      return temperature;
   }
   public double getpressure(){
      return pressure;
   }
   public double gethumidity(){
      return humidity;
   }  
}
public class ExampleWeather {
   public static void main(String[] args) {
      System.out.println("=== Weather Observer Pattern Demo ===\n");
        
       
        WeatherData weatherStation = new WeatherData();
        
        // observers (different displays)
        WeatherDisplay currentDisplay = new WeatherDisplay(weatherStation);
        StatisticalDisplay statsDisplay = new StatisticalDisplay(weatherStation);
        ForecastDisplay forecastDisplay = new ForecastDisplay("Forecast", weatherStation);
        
        System.out.println("\n=== First Weather Update ===");
        weatherStation.setmeasurements(25.0, 1013.2, 65.0);
        
        System.out.println("=== Second Weather Update ===");
        weatherStation.setmeasurements(22.5, 995.8, 80.0);
        
        System.out.println("=== Third Weather Update ===");
        weatherStation.setmeasurements(28.0, 1020.5, 45.0);
        
        // removing an observer
        System.out.println("=== Removing Statistics Display ===");
        weatherStation.removeobserver(statsDisplay);
        
        System.out.println("=== Fourth Weather Update (after removal) ===");
        weatherStation.setmeasurements(30.0, 1008.0, 55.0);
        
        //adding new observer dynamically
        System.out.println("=== Adding New Observer ===");
        WeatherDisplay mobileDisplay = new WeatherDisplay(weatherStation);
        
        System.out.println("=== Final Weather Update ===");
        weatherStation.setmeasurements(26.5, 1015.0, 60.0);
      
   }
   
    
}
