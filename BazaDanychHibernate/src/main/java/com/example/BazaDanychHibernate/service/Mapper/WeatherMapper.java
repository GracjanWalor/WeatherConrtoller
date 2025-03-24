package com.example.BazaDanychHibernate.service.Mapper;

import com.example.BazaDanychHibernate.repository.entity.LocationEntity;
import com.example.BazaDanychHibernate.repository.entity.WeatherDetailsEntity;
import com.example.BazaDanychHibernate.service.DTO.LocationDTO;
import com.example.BazaDanychHibernate.service.DTO.WeatherDetailsDTO;
import com.example.BazaDanychHibernate.service.API.WeatherInfo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class WeatherMapper {


    public LocationDTO mapperToDTO(LocationEntity locationEntity) {

        List<WeatherDetailsDTO> list = locationEntity.getWeatherDetailsEntities().stream()
            .map(weatherDetailsEntity -> mapToWeatherDetailsDTO(weatherDetailsEntity)

        ).collect(Collectors.toList());

        LocationDTO location = new LocationDTO(
                locationEntity.getAreaName(),
                locationEntity.getCountry(),
                locationEntity.getLatitude(),
                locationEntity.getLongitude(),
                list
        );
         return  location;
    }

    public LocationEntity mapToLocationEntity(LocationDTO locationDTO) {

        LocationEntity locationEntity = new LocationEntity(
                locationDTO.getCity(),
                locationDTO.getCountry(),
                locationDTO.getLatitude(),
                locationDTO.getLongitude());

        locationDTO.getWeatherDetailsDTO()
                .forEach(weatherDetailsDTO -> {
                    WeatherDetailsEntity weatherDetailsEntity = mapToWeatherDetailsEntity(weatherDetailsDTO);
                    locationEntity.addWeatherDetails(weatherDetailsEntity);
                });

        return locationEntity;
    }
    public WeatherDetailsDTO mapToWeatherDetailsDTO(WeatherDetailsEntity weatherDetailsEntity) {
        return new WeatherDetailsDTO(
                weatherDetailsEntity.getOrdinalNumber(),
                weatherDetailsEntity.getFeelsLikeC(),
                weatherDetailsEntity.getCloudCover(),
                weatherDetailsEntity.getHumidity(),
                weatherDetailsEntity.getLocalObsDateTime(),
                weatherDetailsEntity.getPressure(),
                weatherDetailsEntity.getTemp_C(),
                weatherDetailsEntity.getUvIndex(),
                weatherDetailsEntity.getVisibility());
    }

    public WeatherDetailsEntity mapToWeatherDetailsEntity(WeatherDetailsDTO weatherDetailsDTO) {
        return new WeatherDetailsEntity(
                weatherDetailsDTO.getOrdinalNumber(),
                weatherDetailsDTO.getFeelsLikeC(),
                weatherDetailsDTO.getCloudcover(),
                weatherDetailsDTO.getHumidity(),
                weatherDetailsDTO.getLocalObsDateTime(),
                weatherDetailsDTO.getPressure(),
                weatherDetailsDTO.getTemp_C(),
                weatherDetailsDTO.getUvIndex(),
                weatherDetailsDTO.getVisibility());
    }
    public LocationEntity mapToLocationEntityFromWeatherInfo(WeatherInfo info) {

        WeatherInfo.CrurrentCondition currentCondition = info.getCurrent_condition().get(0);
        WeatherInfo.NearestArea nearestArea = info.getNearest_area().get(0);

        LocationEntity locationEntity= new LocationEntity(
                nearestArea.getAreaName().get(0).getValue(),
                nearestArea.getCountry().get(0).getValue(),
                nearestArea.getLatitude(),
                nearestArea.getLongitude()
        );

        WeatherDetailsEntity weatherDetailsEntity = new WeatherDetailsEntity(
                0,
                currentCondition.getFeelsLikeC(),
                currentCondition.getCloudcover(),
                currentCondition.getHumidity(),
                currentCondition.getLocalObsDateTime(),
                currentCondition.getPressure(),
                currentCondition.getTemp_C(),
                currentCondition.getUvIndex(),
                currentCondition.getVisibility()
        );

        locationEntity.addWeatherDetails(weatherDetailsEntity);
        return locationEntity;
    }



    public  WeatherDetailsEntity mapToWeatherDetailsEntityFromWeatherInfo(WeatherInfo info) {

        WeatherInfo.CrurrentCondition currentCondition = info.getCurrent_condition().get(0);

        WeatherDetailsEntity weatherDetailsEntity = new WeatherDetailsEntity(
                0,
                currentCondition.getFeelsLikeC(),
                currentCondition.getCloudcover(),
                currentCondition.getHumidity(),
                currentCondition.getLocalObsDateTime(),
                currentCondition.getPressure(),
                currentCondition.getTemp_C(),
                currentCondition.getUvIndex(),
                currentCondition.getVisibility()
        );

        return weatherDetailsEntity;
    }

    public WeatherDetailsEntity mapToWeatherDetailsEntityFromLocationDTO(LocationDTO locationDTO) {
        WeatherDetailsDTO weatherDetailsDTO = locationDTO.getWeatherDetailsDTO().get(0);

        WeatherDetailsEntity weatherDetailsEntity = new WeatherDetailsEntity(
                0,
                weatherDetailsDTO.getFeelsLikeC(),
                weatherDetailsDTO.getCloudcover(),
                weatherDetailsDTO.getHumidity(),
                weatherDetailsDTO.getLocalObsDateTime(),
                weatherDetailsDTO.getPressure(),
                weatherDetailsDTO.getTemp_C(),
                weatherDetailsDTO.getUvIndex(),
                weatherDetailsDTO.getVisibility()
        );

        return weatherDetailsEntity;
    }

}

