package com.conedus.backend.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.conedus.backend.models.Sede;
import com.conedus.backend.models.SedeDTO;
import com.conedus.backend.interfaces.ISedeRepository;

@Repository
public class SedeRepository implements ISedeRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public List<Sede> getSedes() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getSedes'");
  }

  @Override
  public SedeDTO createSede(SedeDTO sede) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'createSede'");
  }

  @Override
  public SedeDTO updateSede(SedeDTO sede) {
    // TODO Auto-generated method stub
    jdbcTemplate.update("UPDATE sedes WHERE sede_dane = ?", sede.getSedeDane());
    return sede;
  }

  @Override
  public void deleteSede(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteSede'");
  }
  
  public List<Map<String, Object>> queryForList(String sql){
    return jdbcTemplate.queryForList(sql);
  }

}
