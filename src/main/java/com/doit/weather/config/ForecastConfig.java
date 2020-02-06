package com.doit.weather.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ForecastConfig {
  @Value("${weather.forcast.url}")
  String url;
  
  @Value("${weather.forcast.days}")
  int days;
  
  public String getUrl() {
    return url;
  }
  
  public void setUrl(String url) {
    this.url = url;
  }
  
  public int getDays() {
    return days;
  }
  
  public void setDays(int days) {
    this.days = days;
  }
}
