/* Write a Java program that accepts a list of weather data (e.g., temperature, humidity) and returns the
number of days with temperatures within certain ranges (e.g., <0°C, 0-10°C, 10-20°C, etc.), and the average humidity for each temperature range.*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WeatherData {
    private double temperature;
    private double humidity;

    public WeatherData(double temperature, double humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }
    public double getTemperature() {
        return temperature;
    }
    public double getHumidity() {
        return humidity;
    }
}
public class  Temperature {
   public static void main(String[] args) {
        List<WeatherData> weatherDataList = List.of(
                new WeatherData(5.0, 70.0),
                new WeatherData(12.0, 60.0),
                new WeatherData(20.0, 75.0),
                new WeatherData(-2.0, 80.0),
                new WeatherData(25.0, 50.0),
                new WeatherData(8.0, 65.0)
        );
        int[] temperatureRanges = {-10, 0, 10, 20, 30, 40};
        Map<String, Integer> temperatureCount = new HashMap<>();
        Map<String, Double> humiditySum = new HashMap<>();
        for (int i = 0; i < temperatureRanges.length - 1; i++) {
            temperatureCount.put(temperatureRangeLabel(temperatureRanges[i], temperatureRanges[i + 1]), 0);
            humiditySum.put(temperatureRangeLabel(temperatureRanges[i], temperatureRanges[i + 1]), 0.0);
        }
        for (WeatherData data : weatherDataList) {
            double temperature = data.getTemperature();
            double humidity = data.getHumidity();

            for (int i = 0; i < temperatureRanges.length - 1; i++) {
                if (temperature >= temperatureRanges[i] && temperature < temperatureRanges[i + 1]) {
                    String rangeLabel = temperatureRangeLabel(temperatureRanges[i], temperatureRanges[i + 1]);
                    temperatureCount.put(rangeLabel, temperatureCount.get(rangeLabel) + 1);
                    humiditySum.put(rangeLabel, humiditySum.get(rangeLabel) + humidity);
                    break;
                }
            }
        }
        for (Map.Entry<String, Integer> entry : temperatureCount.entrySet()) {
            String rangeLabel = entry.getKey();
            int count = entry.getValue();
            double averageHumidity = humiditySum.get(rangeLabel) / count;
            System.out.println(rangeLabel + ": Days = " + count + ", Average Humidity = " + averageHumidity);
        }
    }
    private static String temperatureRangeLabel(int start, int end) {
        return start + "-" + end + "°C";
    }
}
