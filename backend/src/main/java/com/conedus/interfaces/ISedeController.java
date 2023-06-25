package com.conedus.interfaces;

import java.util.List;

import com.conedus.backend.models.Sede;

public interface ISedeController {

  public List<Sede> getSedes();

  public Sede createSede();

  public Sede updateSede();

  public void deleteSede();

}
