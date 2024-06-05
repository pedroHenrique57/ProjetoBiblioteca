package edu.syne.application.useCases.emprestimo.gateway;

import edu.syne.application.entities.emprestimoRDN;
import edu.syne.domain.entities.emprestimoEntidadeRepositorio;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface emprestimoGatewayInteractor {
  void create(emprestimoRDN emprestimoParaCriar) throws IllegalArgumentException, DataAccessException;

  void delete(String aluno__RA, int Livros__id__Livros) throws IllegalArgumentException, DataAccessException;

  List<emprestimoEntidadeRepositorio> findEmprestimoByLivro(int id) throws IllegalArgumentException, DataAccessException;

  List<emprestimoEntidadeRepositorio> findEmprestimoByAluno(String id) throws IllegalArgumentException, DataAccessException;

  List<emprestimoEntidadeRepositorio> findAll() throws DataAccessException;
}
