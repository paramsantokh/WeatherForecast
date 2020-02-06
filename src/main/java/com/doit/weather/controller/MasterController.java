package com.doit.weather.controller;

import com.doit.weather.model.ForecastResponse;
import com.doit.weather.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping ("/weather-forcast")
public class MasterController {
  
  @Autowired
  RestTemplate restTemplate;
  
  @Autowired
  ForecastService forecastService;
  
  @GetMapping ("/city={cityName}")
  public ResponseEntity<?> getWeatherData(@PathVariable String cityName) {
    List<ForecastResponse> forecastResponses = forecastService.getWeatherData(cityName);
    if(forecastResponses == null || forecastResponses.isEmpty()){
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(forecastResponses, HttpStatus.OK);
  }
}
