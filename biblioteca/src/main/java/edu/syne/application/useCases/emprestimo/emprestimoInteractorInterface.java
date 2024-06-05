package edu.syne.application.useCases.emprestimo;

import edu.syne.application.entities.emprestimoRDN;
import edu.syne.domain.entities.emprestimoEntidadeRepositorio;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface emprestimoInteractorInterface {
  void create(emprestimoRDN emprestimoParaCriar) throws IllegalArgumentException, DataAccessException;

  void delete(String aluno__RA, int Livros__id__Livros) throws IllegalArgumentException, DataAccessException;

  List<emprestimoEntidadeRepositorio> findLivroById(int id) throws IllegalArgumentException, DataAccessException;

  List<emprestimoEntidadeRepositorio> findAlunoById(String id) throws IllegalArgumentException, DataAccessException;

  List<emprestimoEntidadeRepositorio> findAll() throws DataAccessException;

}
