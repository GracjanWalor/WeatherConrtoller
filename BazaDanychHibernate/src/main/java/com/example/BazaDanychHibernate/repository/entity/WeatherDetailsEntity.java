package com.example.BazaDanychHibernate.repository.entity;

import jakarta.persistence.*;

@Entity
public class WeatherDetailsEntity {

    @Id
    @GeneratedValue
    private Long weatherDetailsID;


    private int ordinalNumber;
    private double feelsLikeC;
    private double cloudCover;
    private double humidity;
    private String  localObsDateTime;
    private int pressure;
    private double temp_C;
    private int uvIndex;
    private int visibility;

    @ManyToOne
    private LocationEntity locationEntity;

    public WeatherDetailsEntity() {
    }

    public WeatherDetailsEntity(int ordinalNumber, double feelsLikeC, double cloudCover, double humidity, String localObsDateTime, int pressure, double temp_C, int uvIndex, int visibility) {
        this.ordinalNumber = ordinalNumber;
        this.feelsLikeC = feelsLikeC;
        this.cloudCover = cloudCover;
        this.humidity = humidity;
        this.localObsDateTime = localObsDateTime;
        this.pressure = pressure;
        this.temp_C = temp_C;
        this.uvIndex = uvIndex;
        this.visibility = visibility;
    }

    public Long getWeatherDetailsID() {
        return weatherDetailsID;
    }

    public int getOrdinalNumber() {
        return ordinalNumber;
    }

    public void setOrdinalNumber(int ordinalNumber) {
        this.ordinalNumber = ordinalNumber;
    }

    public double getFeelsLikeC() {
        return feelsLikeC;
    }

    public void setFeelsLikeC(double feelsLikeC) {
        this.feelsLikeC = feelsLikeC;
    }

    public double getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(double cloudCover) {
        this.cloudCover = cloudCover;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public String getLocalObsDateTime() {
        return localObsDateTime;
    }

    public void setLocalObsDateTime(String localObsDateTime) {
        this.localObsDateTime = localObsDateTime;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public double getTemp_C() {
        return temp_C;
    }

    public void setTemp_C(double temp_C) {
        this.temp_C = temp_C;
    }

    public int getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(int uvIndex) {
        this.uvIndex = uvIndex;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public void setLocationEntity(LocationEntity locationEntity) {
        this.locationEntity = locationEntity;
    }

    public LocationEntity getLocationEntity() {
        return locationEntity;
    }

    public void addLocationEntity(LocationEntity locationEntity) {
        this.locationEntity = locationEntity;
    }

    public void setWeatherDetailsID(Long weatherDetailsID) {
        this.weatherDetailsID = weatherDetailsID;
    }


}
