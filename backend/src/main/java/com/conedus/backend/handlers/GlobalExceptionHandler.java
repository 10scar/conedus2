package com.conedus.backend.handlers;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String handleNotFoundException(NotFoundException ex){
    return ex.getMessage();
  }

  @ExceptionHandler(BadRequestException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String handleBadRequestException(BadRequestException ex){
    return ex.getMessage();
  }

}
