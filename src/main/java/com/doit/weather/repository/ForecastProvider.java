package com.doit.weather.repository;

import com.doit.weather.config.ForecastConfig;
import com.doit.weather.model.ForcastModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ForecastProvider {
  @Autowired
  RestTemplate restTemplate;
  
  @Autowired
  ForecastConfig forecastConfig;
  
  public ForcastModel getForcastData(String city){
    String url = String.format(forecastConfig.getUrl(), city);
    ForcastModel forcastModel = restTemplate.getForObject(url, ForcastModel.class);
    return forcastModel;
  }
}
