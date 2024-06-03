package edu.syne.application.useCases.alunos;

import edu.syne.application.entities.alunoRDN;
import edu.syne.domain.entities.alunoEntidadeRepositorio;
import edu.syne.application.useCases.alunos.gateway.alunoGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class alunoInteractor implements alunoInteractorInterface{

  alunoGateway alunoGateway;

  @Autowired
  public alunoInteractor(alunoGateway alunoGateway) throws IllegalArgumentException, DataAccessException {
    this.alunoGateway = alunoGateway;
  }

  @Override
  public void create(alunoRDN alunoParaCriar) {
    alunoGateway.create(alunoParaCriar);
  }

  @Override
  public void update(alunoEntidadeRepositorio alunoParaSalvar) throws IllegalArgumentException, DataAccessException {
    alunoGateway.update(alunoParaSalvar);
  }

  @Override
  public void delete(String id) throws IllegalArgumentException, DataAccessException {
    alunoGateway.delete(id);
  }

  @Override
  public alunoEntidadeRepositorio findById(String id) throws IllegalArgumentException, DataAccessException {
    return alunoGateway.findById(id);
  }

  @Override
  public List<alunoEntidadeRepositorio> findAll() throws DataAccessException {
    return alunoGateway.findAll();
  }
}
