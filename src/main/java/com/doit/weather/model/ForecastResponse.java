package com.doit.weather.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ForecastResponse {
  
  @JsonProperty ("date")
  String date;
  
  @JsonProperty ("min_temp")
  double minTemp;
  
  @JsonProperty ("max_temp")
  double maxTemp;
  
  @JsonProperty ("description")
  String description;
  
  @JsonProperty ("tipOfDay")
  String tipOfDay;
  
  public String getDate() {
    return date;
  }
  
  public void setDate(String date) {
    this.date = date;
  }
  
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
  
  public String getDescription() {
    return description;
  }
  
  public void setDescription(String description) {
    this.description = description;
  }
  
  public String getTipOfDay() {
    return tipOfDay;
  }
  
  public void setTipOfDay(String tipOfDay) {
    this.tipOfDay = tipOfDay;
  }
  
 /* @Override
  public String toString() {
    return "ForecastResponse{" +
           "date='" + date + '\'' +
           ", minTemp=" + minTemp +
           ", maxTemp=" + maxTemp +
           ", description='" + description + '\'' +
           ", tipOfDay='" + tipOfDay + '\'' +
           '}';
  }*/
}
