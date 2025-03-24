package com.example.BazaDanychHibernate.controller;

import com.example.BazaDanychHibernate.repository.entity.LocationEntity;
import com.example.BazaDanychHibernate.repository.entity.WeatherDetailsEntity;
import com.example.BazaDanychHibernate.service.DTO.LocationDTO;
import com.example.BazaDanychHibernate.service.DTO.WeatherDetailsDTO;
import com.example.BazaDanychHibernate.service.DTO.WeatherStatsDTO;
import com.example.BazaDanychHibernate.service.WeatherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/weather")
public class WeatherController {

    private WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/addCity/{city}")
    public LocationDTO getWeather(@PathVariable String city) {

        return weatherService.addCity(city);
    }

    @PostMapping("/create")
    public LocationDTO createWeather(@RequestBody LocationDTO locationDTO) {
        return weatherService.createWeather(locationDTO);
    }

    @DeleteMapping("/delete/{weatherId}")
    public void delete(@PathVariable Long weatherId) {
        weatherService.deleteWeatherDetails(weatherId);
    }

    @GetMapping("/details")
    public List<LocationDTO> getDetails() {
        return weatherService.getWeatherDetailsAndLocation();
    }

    @GetMapping("/show/{city}")
    public LocationDTO getCity(@PathVariable String city) {
        return weatherService.findByCity(city);
    }

    @PutMapping("/update/{city}/{number}")
    public LocationDTO putUpdate(@PathVariable String city, @PathVariable int number,@RequestBody WeatherDetailsDTO updateWeatherDetails) {
        return weatherService.updateDetails(city,number,updateWeatherDetails);
    }

    @GetMapping("/stats/{city}")
    public WeatherStatsDTO getStats(@PathVariable String city){
        return weatherService.getTemperaturesStats(city);
    }

}



// Data godzina (zmienna)
// Testy | jednostkowe & integracyjne
// Obsluga bledow: warotsci pol do pol
//Obsluga bledow (Spring Boot, try catch, )

