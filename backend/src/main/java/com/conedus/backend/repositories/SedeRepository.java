package com.conedus.backend.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.conedus.backend.models.Sede;
import com.conedus.interfaces.ISedeRepository;

public class SedeRepository implements ISedeRepository {

  @Autowired private JdbcTemplate jdbcTemplate;

  @Override
  public List<Sede> getSedes() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getSedes'");
  }

  @Override
  public Sede createSede() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'createSede'");
  }

  @Override
  public Sede updateSede() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateSede'");
  }

  @Override
  public void deleteSede() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteSede'");
  }
  
  public List<Map<String, Object>> queryForList(String sql){
    return jdbcTemplate.queryForList(sql);
  }

}