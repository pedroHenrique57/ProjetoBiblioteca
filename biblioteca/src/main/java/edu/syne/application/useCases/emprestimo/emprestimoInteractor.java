package edu.syne.application.useCases.emprestimo;

import edu.syne.application.entities.emprestimoRDN;
import edu.syne.application.useCases.emprestimo.gateway.emprestimoGateway;
import edu.syne.domain.entities.emprestimoEntidadeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class emprestimoInteractor implements emprestimoInteractorInterface {

  emprestimoGateway emprestimoGateway;

  @Autowired
  public emprestimoInteractor(edu.syne.application.useCases.emprestimo.gateway.emprestimoGateway emprestimoGateway) {
    this.emprestimoGateway = emprestimoGateway;
  }

  @Override
  public void create(emprestimoRDN emprestimoParaCriar) throws IllegalArgumentException, DataAccessException {
    emprestimoGateway.create(emprestimoParaCriar);
  }

  @Override
  public void delete(String aluno__RA, int Livros__id__Livros) throws IllegalArgumentException, DataAccessException {
    emprestimoGateway.delete(aluno__RA, Livros__id__Livros);
  }

  @Override
  public List<emprestimoEntidadeRepositorio> findLivroById(int id) throws IllegalArgumentException, DataAccessException {
    return emprestimoGateway.findEmprestimoByLivro(id);
  }

  @Override
  public List<emprestimoEntidadeRepositorio> findAlunoById(String id) throws IllegalArgumentException, DataAccessException {
    return emprestimoGateway.findEmprestimoByAluno(id);
  }

  @Override
  public List<emprestimoEntidadeRepositorio> findAll() throws DataAccessException {
    return emprestimoGateway.findAll();
  }
}
