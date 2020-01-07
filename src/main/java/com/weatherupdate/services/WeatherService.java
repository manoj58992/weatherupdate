package com.weatherupdate.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.weatherupdate.dtos.WeatherDTO;
import com.weatherupdate.entities.WeatherEntity;
import com.weatherupdate.repositories.WeatherRepository;

@Service
public class WeatherService {
	@Autowired
	private WeatherRepository weatherRepository;

	public void saveWeather(WeatherDTO weatherDto) {
		WeatherEntity we = new WeatherEntity();
		we.setTitle(weatherDto.getTitle());
		we.setLocation(weatherDto.getLocation());
		we.setReporterName(weatherDto.getReporter());
		we.setCreatedAt(new Date());
		we.setUpdatedAt(new Date());
		weatherRepository.save(we);
	}

	public WeatherDTO getWeatherAndActiveFalse(String title) {
		return Convert(weatherRepository.findByTitleAndActiveFalse(title));
	}

	public WeatherDTO getWeatherTitle(String title) {
		return Convert(weatherRepository.findByTitle(title));
	}

	public WeatherDTO Convert(WeatherEntity we) {
		WeatherDTO wdto = null;
		if (we != null) {
			wdto = new WeatherDTO();
			wdto.setLocation(we.getLocation());
			wdto.setId(we.getId());
			wdto.setTitle(we.getTitle());
			wdto.setCreatedDate(we.getCreatedAt());
			wdto.setUpdatedDate(we.getUpdatedAt());
		}
		return wdto;
	}
}
