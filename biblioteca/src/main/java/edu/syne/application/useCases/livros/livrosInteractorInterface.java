package edu.syne.application.useCases.livros;

import edu.syne.application.entities.livrosRDN;
import edu.syne.domain.entities.livrosEntidadeRepositorio;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface livrosInteractorInterface {
  void create(livrosRDN livrosParaCriar) throws IllegalArgumentException, DataAccessException;

  void update(livrosEntidadeRepositorio livrosParaSalvar) throws IllegalArgumentException, DataAccessException;

  void delete(int id) throws IllegalArgumentException, DataAccessException;

  livrosEntidadeRepositorio findById(int id) throws IllegalArgumentException, DataAccessException;

  List<livrosEntidadeRepositorio> findAll() throws DataAccessException;
}
