package com.doit.weather.repository;

import com.doit.weather.config.ForecastConfig;
import com.doit.weather.model.ForecastModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ForecastProvider {
  @Autowired
  RestTemplate restTemplate;
  
  @Autowired
  ForecastConfig forecastConfig;
  
  public ForecastModel getForcastData(String city){
    String url = String.format(forecastConfig.getUrl(), city);
    ForecastModel forecastModel = restTemplate.getForObject(url, ForecastModel.class);
    return forecastModel;
  }
}
