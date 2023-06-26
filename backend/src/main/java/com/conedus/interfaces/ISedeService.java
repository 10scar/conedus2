package com.conedus.interfaces;

import java.util.List;

import com.conedus.backend.models.Sede;

public interface ISedeService {

  public String getSedes();

  public Sede createSede();

  public Sede updateSede();

  public void deleteSede();

}