package com.weatherupdate.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.weatherupdate.entities.WeatherEntity;

@Repository
public interface WeatherRepository extends CrudRepository<WeatherEntity, Long> {
	
	public WeatherEntity findByTitle(String title);
	
	public WeatherEntity findByTitleAndActiveFalse(String title);
	
	//public List<WeatherEntity> findAll();
		
	}
	

