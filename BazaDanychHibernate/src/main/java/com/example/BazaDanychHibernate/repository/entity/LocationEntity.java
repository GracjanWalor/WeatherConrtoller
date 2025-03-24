package com.example.BazaDanychHibernate.repository.entity;

import com.example.BazaDanychHibernate.repository.entity.WeatherDetailsEntity;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class LocationEntity {

    @Id
    @GeneratedValue
    private Long locationID;

    private String areaName;
    private String country;
    private double latitude;
    private double longitude;

    @OneToMany(mappedBy = "locationEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WeatherDetailsEntity> weatherDetailsEntities = new ArrayList<>();

    public LocationEntity() {
        this.weatherDetailsEntities = new ArrayList<>();
    }

    public LocationEntity(String areaName, String country, double latitude, double longitude) {
        this.areaName = areaName;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.weatherDetailsEntities = new ArrayList<>();
    }

    public Long getLocationID() {
        return locationID;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    public List<WeatherDetailsEntity> getWeatherDetailsEntities() {
        return weatherDetailsEntities;
    }

    public void setWeatherDetailsEntities(List<WeatherDetailsEntity> weatherDetailsEntities) {
        this.weatherDetailsEntities = weatherDetailsEntities;
    }

    public void addWeatherDetails(WeatherDetailsEntity weatherDetailsEntity) {
        if (weatherDetailsEntities == null) {
            weatherDetailsEntities = new ArrayList<>();
        }
        weatherDetailsEntities.add(weatherDetailsEntity);
        weatherDetailsEntity.setLocationEntity(this);
    }
}


