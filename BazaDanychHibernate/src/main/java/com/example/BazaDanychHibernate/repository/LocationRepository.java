package com.example.BazaDanychHibernate.repository;

import com.example.BazaDanychHibernate.repository.entity.LocationEntity;
import com.example.BazaDanychHibernate.repository.entity.WeatherDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Long> {

    LocationEntity findByAreaName(String areaName);

}
