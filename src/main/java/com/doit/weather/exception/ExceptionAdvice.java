package com.doit.weather.exception;

import com.doit.weather.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
@Component
public class ExceptionAdvice {
  
  @ExceptionHandler (value = Exception.class)
  @ResponseStatus (value = HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<ErrorResponse> handleUnknownException() {
    return getErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR);
  }
  
  @ExceptionHandler (value = HttpClientErrorException.class)
  @ResponseStatus (value = HttpStatus.NOT_FOUND)
  public ResponseEntity<ErrorResponse> handleNotFoundException() {
    return getErrorResponse(HttpStatus.NOT_FOUND);
  }
  
  private ResponseEntity<ErrorResponse> getErrorResponse(HttpStatus status) {
    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setCode(status.value());
    errorResponse.setMsg(status.getReasonPhrase());
    return new ResponseEntity<>(errorResponse, status);
  }
}
