package edu.syne.application.useCases.emprestimo;

import edu.syne.application.entities.emprestimoRDN;
import edu.syne.domain.entities.emprestimoEntidadeRepositorio;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface emprestimoInteractorInterface {
  void create(emprestimoRDN emprestimoParaCriar) throws IllegalArgumentException, DataAccessException;

  void delete(String aluno__RA, int id__Livros) throws IllegalArgumentException, DataAccessException;

  List<emprestimoEntidadeRepositorio> findEmprestimoByLivro(int id) throws IllegalArgumentException, DataAccessException;

  List<emprestimoEntidadeRepositorio> findEmprestimoByAluno(String id) throws IllegalArgumentException, DataAccessException;

  List<emprestimoEntidadeRepositorio> findAll() throws DataAccessException;

}
