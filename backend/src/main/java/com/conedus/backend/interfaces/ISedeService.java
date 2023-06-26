package com.conedus.backend.interfaces;

import com.conedus.backend.models.Sede;
import com.conedus.backend.models.SedeDTO;

public interface ISedeService {

  public String getSedes();

  public SedeDTO createSede(SedeDTO sede);

  public SedeDTO updateSede(SedeDTO sede);

  public void deleteSede(String id);

}
