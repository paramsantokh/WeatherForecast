package com.doit.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse {
  @JsonProperty ("message")
  String msg;
  @JsonProperty("code")
  int code;
  
  public String getMsg() {
    return msg;
  }
  
  public void setMsg(String msg) {
    this.msg = msg;
  }
  
  public int getCode() {
    return code;
  }
  
  public void setCode(int code) {
    this.code = code;
  }
}

