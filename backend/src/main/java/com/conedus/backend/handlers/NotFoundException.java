package com.conedus.backend.handlers;

public class NotFoundException extends RuntimeException {
  public NotFoundException(String msg){
    super(msg);
  }
}
