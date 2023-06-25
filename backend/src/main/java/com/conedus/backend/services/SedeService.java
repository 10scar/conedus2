package com.conedus.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.conedus.backend.models.Sede;
import com.conedus.interfaces.ISedeRepository;
import com.conedus.interfaces.ISedeService;

public class SedeService implements ISedeService {

  @Autowired
  ISedeRepository repo;

  @Override
  public List<Sede> getSedes() {
    return repo.getSedes();
  }

  @Override
  public Sede createSede() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'createSede'");
  }

  @Override
  public Sede updateSede() {
    return repo.createSede();
  }

  @Override
  public void deleteSede() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteSede'");
  }
  
}
