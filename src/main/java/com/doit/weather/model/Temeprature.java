package com.doit.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Temeprature {
  @JsonProperty ("temp_min")
  double minTemp;
  @JsonProperty ("temp_max")
  double maxTemp;
  
  public double getMinTemp() {
    return minTemp;
  }
  
  public void setMinTemp(double minTemp) {
    this.minTemp = minTemp;
  }
  
  public double getMaxTemp() {
    return maxTemp;
  }
  
  public void setMaxTemp(double maxTemp) {
    this.maxTemp = maxTemp;
  }
}
