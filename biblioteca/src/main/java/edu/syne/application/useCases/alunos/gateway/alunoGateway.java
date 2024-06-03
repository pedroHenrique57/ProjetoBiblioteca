package edu.syne.application.useCases.alunos.gateway;

import edu.syne.application.entities.alunoRDN;
import edu.syne.domain.entities.alunoEntidadeRepositorio;
import edu.syne.infrastructure.rowMapper.alunoEntidadeRepositorioRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class alunoGateway implements alunoGatewayInterface {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public alunoGateway(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }


  @Override
  public void create(alunoRDN alunoParaCriar) throws IllegalArgumentException, DataAccessException {
    // Define o SQL.
    String sql = "INSERT INTO aluno VALUES (?,?,?)";

    //Verifica se o RA possui 10 Digitos.
    if (alunoParaCriar.getRA().length() != 10) {
      throw new IllegalArgumentException("O RA precisa ter 10 caracteres");
    }

    // Formata o SQL com as informações e roda no banco.
    jdbcTemplate.update(sql, alunoParaCriar.getRA(), alunoParaCriar.getNome__aluno(), alunoParaCriar.getTurma());
  }

  @Override
  public void update(alunoEntidadeRepositorio alunoParaSalvar) throws IllegalArgumentException, DataAccessException {
    // Define o SQL.
    String sql = "UPDATE aluno SET nome__aluno = ? , turma = ? WHERE RA = ?";

    //Verifica se o RA possui 10 Digitos.
    if (alunoParaSalvar.getRA().length() != 10) {
      throw new IllegalArgumentException("O RA precisa ter 10 caracteres");
    }

    // Formata o SQL com as informações e roda no banco.
    jdbcTemplate.update(sql, alunoParaSalvar.getNome__aluno(), alunoParaSalvar.getTurma(), alunoParaSalvar.getRA() );
  }

  @Override
  public void delete(String id) throws IllegalArgumentException, DataAccessException {
    // Define o SQL.
    String sql = "DELETE FROM aluno WHERE RA = ?";

    //Verifica se o RA possui 10 Digitos.
    if (id.length() != 10) {
      throw new IllegalArgumentException("O RA precisa ter 10 caracteres");
    }

    // Formata o SQL com as informações e roda no banco.
    jdbcTemplate.update(sql, id);
  }

  @Override
  public alunoEntidadeRepositorio findById(String id) throws IllegalArgumentException, DataAccessException {
    // Define o SQL.
    String sql = "SELECT * FROM aluno WHERE RA = ?";

    //Verifica se o RA possui 10 Digitos.
    if (id.length() != 10) {
      throw new IllegalArgumentException("O RA precisa ter 10 caracteres");
    }

    // Formata o SQL com as informações e roda no banco.
    return jdbcTemplate.queryForObject(sql, new Object[]{id}, new alunoEntidadeRepositorioRowMapper());
  }

  @Override
  public List<alunoEntidadeRepositorio> findAll() throws DataAccessException {
    // Define o SQL.
    String sql = "SELECT * FROM aluno";

    // Formata o SQL com as informações e roda no banco.
    return jdbcTemplate.query(sql, new alunoEntidadeRepositorioRowMapper());
  }
}
