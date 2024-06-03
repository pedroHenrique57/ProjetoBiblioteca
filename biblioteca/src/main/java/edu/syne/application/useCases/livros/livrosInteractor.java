package edu.syne.application.useCases.livros;

import edu.syne.application.entities.livrosRDN;
import edu.syne.application.useCases.livros.gateway.livrosGateway;
import edu.syne.domain.entities.livrosEntidadeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class livrosInteractor implements livrosInteractorInterface {

  livrosGateway livrosGateway;

  @Autowired
  public livrosInteractor(livrosGateway livrosGateway) throws IllegalArgumentException, DataAccessException {
    this.livrosGateway = livrosGateway;
  }

  @Override
  public void create(livrosRDN livrosParaCriar) {
    livrosGateway.create(livrosParaCriar);
  }

  @Override
  public void update(livrosEntidadeRepositorio livrosParaSalvar) throws IllegalArgumentException, DataAccessException {
    livrosGateway.update(livrosParaSalvar);
  }

  @Override
  public void delete(int id) throws IllegalArgumentException, DataAccessException {
    livrosGateway.delete(id);
  }

  @Override
  public livrosEntidadeRepositorio findById(int id) throws IllegalArgumentException, DataAccessException {
    return livrosGateway.findById(id);
  }

  @Override
  public List<livrosEntidadeRepositorio> findAll() throws DataAccessException {
    return livrosGateway.findAll();
  }
}
