package com.conedus.backend.interfaces;

import com.conedus.backend.models.Sede;

public interface ISedeService {

  public String getSedes();

  public Sede createSede(Sede sede);

  public Sede updateSede(Sede sede);

  public void deleteSede(String id);

}
