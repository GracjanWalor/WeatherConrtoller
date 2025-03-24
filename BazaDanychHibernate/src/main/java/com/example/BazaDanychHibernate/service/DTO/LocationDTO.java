package com.example.BazaDanychHibernate.service.DTO;

import com.example.BazaDanychHibernate.repository.entity.WeatherDetailsEntity;

import java.util.ArrayList;
import java.util.List;

public class LocationDTO {

    private String city;
    private String country;
    private double latitude;
    private double longitude;
    private List<WeatherDetailsDTO> weatherDetailsDTO;

    public LocationDTO(String city, String country, double latitude, double longitude, List<WeatherDetailsDTO> weatherDetailsDTO) {
        this.city = city;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.weatherDetailsDTO = weatherDetailsDTO;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public List<WeatherDetailsDTO> getWeatherDetailsDTO() {
        return weatherDetailsDTO;
    }
}
