package com.doit.weather.service;

import com.doit.weather.config.ForecastConfig;
import com.doit.weather.model.DailyForecast;
import com.doit.weather.model.ForecastModel;
import com.doit.weather.model.ForecastResponse;
import com.doit.weather.model.Temeprature;
import com.doit.weather.model.Weather;
import com.doit.weather.repository.ForecastProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class ForecastService {
  
  @Autowired
  ForecastConfig forecastConfig;
  
  @Autowired
  ForecastProvider forecastProvider;
  
  private static DecimalFormat numberFormat = new DecimalFormat("#.00");
  
  public List<ForecastResponse> getWeatherData(String city) {
    ForecastModel forecastModel = forecastProvider.getForcastData(city);
    if (forecastModel == null || forecastModel.getList() == null || forecastModel.getList().size() == 0) {
      return new ArrayList<>();
    }
    
    return buildForecastResponse(forecastModel);
  }
  
  /**
   * Build the forecast response
   * @param forecastModel
   * @return forecasts for configured days
   */
  private List<ForecastResponse> buildForecastResponse(ForecastModel forecastModel) {
    LocalDate startDate = LocalDate.now().plusDays(1);
    LocalDate endDate = startDate.plusDays(forecastConfig.getDays() - 1);
    Predicate<DailyForecast> dateRange = df -> !df.getDate().toLocalDate().isBefore(startDate)
                                               && !df.getDate().toLocalDate().isAfter(endDate);
    //collect data by date
    Map<LocalDate, List<DailyForecast>> dateForcastMap = forecastModel.getList().stream()
        .filter(dateRange)
        .collect(Collectors.groupingBy(d -> d.getDate().toLocalDate()));
    
    List<ForecastResponse> forecastResponses = new ArrayList<>();
    //For each date get the min/max Temperature
    dateForcastMap.forEach((date, forecast) -> {
      double[] min = {0.0};
      double[] max = {0.0};
      String[] desc = {null};
      forecast.forEach(f -> {
        Temeprature temperature = f.getMain();
        List<Weather> weather = f.getWeather();
        if (min[0] == 0.0 || temperature.getMinTemp() < min[0]) {
          min[0] = temperature.getMinTemp();
        }
        
        if (max[0] == 0.0 || temperature.getMaxTemp() > max[0]) {
          max[0] = temperature.getMaxTemp();
        }
        
        desc[0] = weather != null && weather.get(0) != null ? weather.get(0).getDescription() : desc[0]; //ERROR: NullPointerException
      });
      
      //build forecast response
      ForecastResponse forecastResponse = new ForecastResponse();
      forecastResponse.setDate(date.toString());
      forecastResponse.setMinTemp(Double.valueOf(numberFormat.format(min[0] - 273.15)));
      forecastResponse.setMaxTemp(Double.valueOf(numberFormat.format(max[0] - 273.15)));
      forecastResponse.setDescription(desc[0]);
      forecastResponse.setTipOfDay(desc[0] != null && (desc[0].contains("clouds") || desc[0].contains("snow") || desc[0].contains("rain")) ? "Carry umbrella" : "Use sunscreen lotion");
      forecastResponses.add(forecastResponse);
    });
    
    return forecastResponses.stream()
        .sorted(Comparator.comparing(ForecastResponse::getDate))
        .collect(Collectors.toList());
  }
}
