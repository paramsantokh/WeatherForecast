package com.doit.weather.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

public class DailyForecast {
  @JsonProperty ("dt_txt")
  @JsonFormat (pattern = "yyyy-MM-dd HH:mm:ss")
  LocalDateTime date;
  
  @JsonProperty("main")
  Temeprature main;
  
  @JsonProperty("weather")
  List<Weather> weather;
  
  public LocalDateTime getDate() {
    return date;
  }
  
  public void setDate(LocalDateTime date) {
    this.date = date;
  }
  
  public Temeprature getMain() {
    return main;
  }
  
  public void setMain(Temeprature main) {
    this.main = main;
  }
  
  public List<Weather> getWeather() {
    return weather;
  }
  
  public void setWeather(List<Weather> weather) {
    this.weather = weather;
  }
  
  /*@Override
  public String toString() {
    return "DailyForcast{" +
           "date=" + date +
           ", main=" + main +
           ", weather=" + weather +
           '}';
  }*/
}
