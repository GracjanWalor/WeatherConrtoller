package com.example.BazaDanychHibernate.repository;

import com.example.BazaDanychHibernate.repository.entity.WeatherDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherDetailsRepository extends JpaRepository<WeatherDetailsEntity, Long> {

    WeatherDetailsEntity findByOrdinalNumber(int ordinalNumber);

}
