package com.conedus.backend.interfaces;

import java.util.List;

import com.conedus.backend.models.Sede;
import com.conedus.backend.models.SedeDTO;

public interface ISedeRepository  {
  
  public List<Sede> getSedes();

  public SedeDTO createSede(SedeDTO sede);

  public SedeDTO updateSede(SedeDTO sede);

  public void deleteSede(String id);
}
