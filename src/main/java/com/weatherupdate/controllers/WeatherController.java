package com.weatherupdate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.weatherupdate.dtos.WeatherDTO;
import com.weatherupdate.services.WeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherController {
	@Autowired
	private WeatherService weatherService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public void saveWeather(@RequestBody WeatherDTO weatherDto) {
		weatherService.saveWeather(weatherDto);
	}

	/*@RequestMapping(value = "/title/{title}", method = RequestMethod.GET)
	public WeatherDTO getWeatherByTitle(@PathVariable String title) {
		return weatherService.getWeatherTitle(title);*/
	
	@RequestMapping(value = "/title/{title}", method = RequestMethod.GET)
	public WeatherDTO getWeatherByTitleAndActive(@PathVariable String title) {
		return weatherService.getWeatherAndActiveFalse(title);
}
}