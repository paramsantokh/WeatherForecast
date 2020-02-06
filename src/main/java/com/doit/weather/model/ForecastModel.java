package com.doit.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ForecastModel {
  
  @JsonProperty ("list")
  List<DailyForecast> list;
  
  public List<DailyForecast> getList() {
    return list;
  }
  
  public void setList(List<DailyForecast> list) {
    this.list = list;
  }
}
