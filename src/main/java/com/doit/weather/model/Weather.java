package com.doit.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather {
  
  @JsonProperty("main")
  String main;
  
  @JsonProperty("description")
  String description;
  
  public String getMain() {
    return main;
  }
  
  public void setMain(String main) {
    this.main = main;
  }
  
  public String getDescription() {
    return description;
  }
  
  public void setDescription(String description) {
    this.description = description;
  }
  
}
