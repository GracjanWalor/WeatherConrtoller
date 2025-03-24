package com.example.BazaDanychHibernate.service;

import com.example.BazaDanychHibernate.repository.LocationRepository;
import com.example.BazaDanychHibernate.repository.entity.LocationEntity;
import com.example.BazaDanychHibernate.repository.entity.WeatherDetailsEntity;
import com.example.BazaDanychHibernate.service.API.WeatherInfo;
import com.example.BazaDanychHibernate.service.DTO.LocationDTO;
import com.example.BazaDanychHibernate.service.DTO.WeatherDetailsDTO;
import com.example.BazaDanychHibernate.service.DTO.WeatherStatsDTO;
import com.example.BazaDanychHibernate.service.Mapper.WeatherMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherService {

    private final RestTemplate restTemplate ;
    private final LocationRepository locationRepository;
    private final WeatherMapper weatherMapper;

    public WeatherService(RestTemplate restTemplate, LocationRepository locationRepository, WeatherMapper weatherMapper) {
        this.restTemplate = restTemplate;
        this.locationRepository = locationRepository;
        this.weatherMapper = weatherMapper;
    }

    public LocationDTO addCity(String city) {
        String url = "https://wttr.in/" + city + "?format=j1";
        WeatherInfo weatherInfo = restTemplate.getForObject(url, WeatherInfo.class);
        LocationEntity findLocation = locationRepository.findByAreaName(city);

        if (findLocation == null) {

            LocationEntity newLocationEntity = weatherMapper.mapToLocationEntityFromWeatherInfo(weatherInfo);
            int listSize = newLocationEntity.getWeatherDetailsEntities().size();
            if (listSize > 0) {
                newLocationEntity.getWeatherDetailsEntities().get(listSize - 1).setOrdinalNumber(listSize);
            }

            LocationEntity saved = locationRepository.save(newLocationEntity);
            return weatherMapper.mapperToDTO(saved);


        } else  {
            WeatherDetailsEntity findUpdate = weatherMapper.mapToWeatherDetailsEntityFromWeatherInfo(weatherInfo);
            findLocation.addWeatherDetails(findUpdate);
            int listSize = findLocation.getWeatherDetailsEntities().size();
            System.out.println(listSize);
            if (listSize > 0) {
                findLocation.getWeatherDetailsEntities().get(listSize - 1).setOrdinalNumber(listSize);

            }

            LocationEntity saved = locationRepository.saveAndFlush(findLocation);
            return weatherMapper.mapperToDTO(saved);
        }
    }


    public LocationDTO createWeather(LocationDTO locationDTO) {
        LocationEntity findLocation = locationRepository.findByAreaName(locationDTO.getCity());

        if (findLocation == null) {
            LocationEntity locationEntity = weatherMapper.mapToLocationEntity(locationDTO);
            int listSize = locationEntity.getWeatherDetailsEntities().size();
            if (listSize > 0) {
                locationEntity.getWeatherDetailsEntities().get(listSize - 1).setOrdinalNumber(listSize);
            }
            LocationEntity saved = locationRepository.saveAndFlush(locationEntity);
            return weatherMapper.mapperToDTO(saved);
        } else {
            WeatherDetailsEntity newWeatherDetails = weatherMapper.mapToWeatherDetailsEntityFromLocationDTO(locationDTO);
            findLocation.addWeatherDetails(newWeatherDetails);
            int listSize = findLocation.getWeatherDetailsEntities().size();
            if (listSize > 0) {
                findLocation.getWeatherDetailsEntities().get(listSize - 1).setOrdinalNumber(listSize);
            }
            LocationEntity saved = locationRepository.saveAndFlush(findLocation);
            return weatherMapper.mapperToDTO(saved);
        }
    }

    public void deleteWeatherDetails(Long weatherId) {
        if (!locationRepository.existsById(weatherId)) {
            System.out.println("Nie ma takiego ID w bazie danych");
        } else {
            locationRepository.deleteById(weatherId);
        }
    }

    public List<LocationDTO> getWeatherDetailsAndLocation() {
        List<LocationEntity> data = locationRepository.findAll();

        return data.stream()
                .map(weatherMapper::mapperToDTO)
                .collect(Collectors.toList());
    }

    public LocationDTO findByCity(String city) {
        LocationEntity findLocation = locationRepository.findByAreaName(city);
        if (findLocation == null) {
            return null;
        }
        return weatherMapper.mapperToDTO(findLocation);
    }

    public LocationDTO updateDetails(String city, int ordinalNumber, WeatherDetailsDTO updateWeatherDetails) {
        LocationEntity locationEntity = locationRepository.findByAreaName(city);

        if (locationEntity == null) {
            return null;
        } else {
            WeatherDetailsEntity weatherDetailsEntity = locationEntity.getWeatherDetailsEntities()
                    .stream()
                    .filter(weatherDetailsEntity1 -> weatherDetailsEntity1.getOrdinalNumber() == ordinalNumber)
                    .findFirst()
                    .orElse(null);

            if (weatherDetailsEntity == null) {
                return null;
            } else {
                weatherDetailsEntity.setFeelsLikeC(updateWeatherDetails.getFeelsLikeC());
                weatherDetailsEntity.setCloudCover(updateWeatherDetails.getCloudcover());
                weatherDetailsEntity.setHumidity(updateWeatherDetails.getHumidity());
                weatherDetailsEntity.setLocalObsDateTime(updateWeatherDetails.getLocalObsDateTime());
                weatherDetailsEntity.setPressure(updateWeatherDetails.getPressure());
                weatherDetailsEntity.setTemp_C(updateWeatherDetails.getTemp_C());
                weatherDetailsEntity.setUvIndex(updateWeatherDetails.getUvIndex());
                weatherDetailsEntity.setVisibility(updateWeatherDetails.getVisibility());

            }
        }
        
        LocationEntity updatedEntity = locationRepository.save(locationEntity);
        return weatherMapper.mapperToDTO(updatedEntity);
    }


    public WeatherStatsDTO getTemperaturesStats(String city) {
       LocationEntity locationEntity = locationRepository.findByAreaName(city);

       if (locationEntity == null) {
           return null;

       } else {
           List<WeatherDetailsEntity> weatherDetailsEntities = locationEntity.getWeatherDetailsEntities();
           WeatherStatsDTO weatherStatsDTO = collectStats(weatherDetailsEntities);
           return weatherStatsDTO;
       }
    }

    private WeatherStatsDTO  collectStats (List<WeatherDetailsEntity> weatherDetailsEntities) {

        double maxTemp = weatherDetailsEntities.stream()
                .mapToDouble(value -> value.getTemp_C()).max().orElse(0.0);

        double minTemp = weatherDetailsEntities.stream()
                .mapToDouble(value -> value.getTemp_C()).min().orElse(0.0);

        double averageTemp = weatherDetailsEntities.stream()
                .mapToDouble(value -> value.getTemp_C()).average().orElse(0.0);

        double maxPressure = weatherDetailsEntities.stream()
                .mapToDouble(value -> value.getPressure()).max().orElse(0.0);

        double minPressure = weatherDetailsEntities.stream()
                .mapToDouble(value -> value.getPressure()).min().orElse(0.0);

        double averagePressure = weatherDetailsEntities.stream()
                .mapToDouble(value -> value.getPressure()).average().orElse(0.0);

        double maxHumidity = weatherDetailsEntities.stream()
                .mapToDouble(value -> value.getHumidity()).max().orElse(0.0);

        double minHumidity = weatherDetailsEntities.stream()
                .mapToDouble(value -> value.getHumidity()).min().orElse(0.0);

        double averageHumidity = weatherDetailsEntities.stream()
                .mapToDouble(value -> value.getHumidity()).average().orElse(0.0);

        WeatherStatsDTO weatherStatsDTO= new WeatherStatsDTO(
                maxTemp,
                minTemp,
                averageTemp,
                maxPressure,
                minPressure,
                averagePressure,
                maxHumidity,
                minHumidity,
                averageHumidity
        );

        return weatherStatsDTO;
    }
}
