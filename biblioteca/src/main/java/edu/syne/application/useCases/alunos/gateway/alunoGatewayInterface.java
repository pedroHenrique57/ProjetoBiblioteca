package edu.syne.application.useCases.alunos.gateway;

import edu.syne.application.entities.alunoRDN;
import edu.syne.domain.entities.alunoEntidadeRepositorio;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface alunoGatewayInterface {

  void create(alunoRDN alunoParaCriar) throws IllegalArgumentException, DataAccessException;

  void update(alunoEntidadeRepositorio alunoParaSalvar) throws IllegalArgumentException, DataAccessException;

  void delete(String id) throws IllegalArgumentException, DataAccessException;

  alunoEntidadeRepositorio findById(String id) throws IllegalArgumentException, DataAccessException;

  List<alunoEntidadeRepositorio> findAll() throws DataAccessException;
}
