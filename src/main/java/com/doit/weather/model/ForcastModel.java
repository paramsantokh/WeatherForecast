package com.doit.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ForcastModel {
  
  @JsonProperty ("list")
  List<DailyForcast> list;
  
  public List<DailyForcast> getList() {
    return list;
  }
  
  public void setList(List<DailyForcast> list) {
    this.list = list;
  }
}
