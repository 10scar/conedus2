package com.conedus.backend.handlers;

public class BadRequestException extends RuntimeException {
  public BadRequestException(String msg){
    super(msg);
  }
}
