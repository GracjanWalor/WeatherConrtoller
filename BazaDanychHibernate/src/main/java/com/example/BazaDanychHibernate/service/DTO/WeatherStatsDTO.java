package com.example.BazaDanychHibernate.service.DTO;

public class WeatherStatsDTO {

    private double maxTemp;
    private double minTemp;
    private double averageTemp;
    private double maxPressure;
    private double minPressure;
    private double averagePressure;
    private double maxHumidity;
    private double minHumidity;
    private double averageHumidity;


    public WeatherStatsDTO(double maxTemp, double minTemp, double averageTemp, double maxPressure, double minPressure, double averagePressure, double maxHumidity, double minHumidity, double averageHumidity) {
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.averageTemp = averageTemp;
        this.maxPressure = maxPressure;
        this.minPressure = minPressure;
        this.averagePressure = averagePressure;
        this.maxHumidity = maxHumidity;
        this.minHumidity = minHumidity;
        this.averageHumidity = averageHumidity;
    }


    public double getMaxTemp() {
        return maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public double getAverageTemp() {
        return averageTemp;
    }

    public double getMaxPressure() {
        return maxPressure;
    }

    public double getMinPressure() {
        return minPressure;
    }

    public double getAveragePressure() {
        return averagePressure;
    }

    public double getMaxHumidity() {
        return maxHumidity;
    }

    public double getMinHumidity() {
        return minHumidity;
    }

    public double getAverageHumidity() {
        return averageHumidity;
    }
}
