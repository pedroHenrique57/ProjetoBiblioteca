package edu.syne.application.useCases.emprestimo.gateway;

import edu.syne.application.entities.emprestimoRDN;
import edu.syne.domain.entities.emprestimoEntidadeRepositorio;
import edu.syne.infrastructure.rowMapper.emprestimoEntidadeRepositorioRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class emprestimoGateway implements emprestimoGatewayInteractor{

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public emprestimoGateway(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public void create(emprestimoRDN emprestimoParaCriar) throws IllegalArgumentException, DataAccessException {
    // Define o SQL.
    String sql = "INSERT INTO emprestimo VALUES (?,?)";

    // Formata o SQL com as informações e roda no banco.
    jdbcTemplate.update(sql, emprestimoParaCriar.getLivros__id__livros(), emprestimoParaCriar.getAluno__RA());
  }

  @Override
  public void delete(String aluno__RA, int Livros__id__Livros) throws IllegalArgumentException, DataAccessException {
    // Define o SQL.
    String sql = "DELETE FROM emprestimo WHERE Livros__id__Livros = ? AND Aluno__RA = ?";

    // Formata o SQL com as informações e roda no banco.
    jdbcTemplate.update(sql, Livros__id__Livros, aluno__RA);
  }

  @Override
  public List<emprestimoEntidadeRepositorio> findEmprestimoByLivro(int id) throws IllegalArgumentException, DataAccessException {
    // Define o SQL.
    String sql = "SELECT * FROM emprestimo WHERE Livros__id__Livros = ?";

    // Formata o SQL com as informações e roda no banco.
    return jdbcTemplate.query(sql, new Object[]{id}, new emprestimoEntidadeRepositorioRowMapper());
  }

  @Override
  public List<emprestimoEntidadeRepositorio> findEmprestimoByAluno(String ra) throws IllegalArgumentException, DataAccessException {
    // Define o SQL.
    String sql = "SELECT * FROM emprestimo WHERE Aluno__RA = ?";
    // Formata o SQL com as informações e roda no banco.
    return jdbcTemplate.query(sql, new Object[]{ra}, new emprestimoEntidadeRepositorioRowMapper());
  }

  @Override
  public List<emprestimoEntidadeRepositorio> findAll() throws DataAccessException {
    // Define o SQL.
    String sql = "SELECT * FROM emprestimo";

    // Formata o SQL com as informações e roda no banco.
    return jdbcTemplate.query(sql, new emprestimoEntidadeRepositorioRowMapper());
  }
}
