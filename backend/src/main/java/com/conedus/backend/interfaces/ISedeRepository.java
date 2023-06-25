package com.conedus.backend.interfaces;

import java.util.List;

import com.conedus.backend.models.Sede;

public interface ISedeRepository  {
  
  public List<Sede> getSedes();

  public Sede createSede(Sede sede);

  public Sede updateSede(Sede sede);

  public void deleteSede(String id);
}
