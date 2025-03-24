package com.example.BazaDanychHibernate.service.DTO;

public class WeatherDetailsDTO  {
    private int ordinalNumber;
    private double feelsLikeC;
    private double cloudcover;
    private double humidity;
    private String  localObsDateTime;
    private int pressure;
    private double temp_C;
    private int uvIndex;
    private int visibility;


    public WeatherDetailsDTO(int ordinalNumber, double feelsLikeC, double cloudcover, double humidity, String localObsDateTime, int pressure, double temp_C, int uvIndex, int visibility) {
        this.ordinalNumber = ordinalNumber;
        this.feelsLikeC = feelsLikeC;
        this.cloudcover = cloudcover;
        this.humidity = humidity;
        this.localObsDateTime = localObsDateTime;
        this.pressure = pressure;
        this.temp_C = temp_C;
        this.uvIndex = uvIndex;
        this.visibility = visibility;
    }

    public int getOrdinalNumber() {
        return ordinalNumber;
    }

    public double getFeelsLikeC() {
        return feelsLikeC;
    }

    public double getCloudcover() {
        return cloudcover;
    }

    public double getHumidity() {
        return humidity;
    }

    public String getLocalObsDateTime() {
        return localObsDateTime;
    }

    public int getPressure() {
        return pressure;
    }

    public double getTemp_C() {
        return temp_C;
    }

    public int getUvIndex() {
        return uvIndex;
    }

    public int getVisibility() {
        return visibility;
    }
}
