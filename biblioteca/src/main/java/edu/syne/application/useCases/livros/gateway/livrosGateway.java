package edu.syne.application.useCases.livros.gateway;

import edu.syne.application.entities.livrosRDN;
import edu.syne.domain.entities.livrosEntidadeRepositorio;
import edu.syne.infrastructure.rowMapper.livrosEntidadeRepositorioRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class livrosGateway implements livrosGatewayInterface{

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public livrosGateway(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }


  @Override
  public void create(livrosRDN livrosParaCriar) throws IllegalArgumentException, DataAccessException {
    // Define o SQL.
    String sql = "INSERT INTO livros VALUES (?,?,?)";

    // Formata o SQL com as informações e roda no banco.
    jdbcTemplate.update(sql, livrosParaCriar.getId__Livros(), livrosParaCriar.getNome__Livro(), livrosParaCriar.getDescricao());
  }

  @Override
  public void update(livrosEntidadeRepositorio livrosParaSalvar) throws IllegalArgumentException, DataAccessException {
    // Define o SQL.
    String sql = "UPDATE livros SET nome__livro = ? , descricao = ? WHERE id__Livros = ?";

    // Formata o SQL com as informações e roda no banco.
    jdbcTemplate.update(sql, livrosParaSalvar.getNome__Livro(), livrosParaSalvar.getDescricao(), livrosParaSalvar.getId__Livros() );
  }

  @Override
  public void delete(int id) throws IllegalArgumentException, DataAccessException {
    // Define o SQL.
    String sql = "DELETE FROM livros WHERE id__Livros = ?";

    // Formata o SQL com as informações e roda no banco.
    jdbcTemplate.update(sql, id);
  }

  @Override
  public livrosEntidadeRepositorio findById(int id) throws IllegalArgumentException, DataAccessException {
    // Define o SQL.
    String sql = "SELECT * FROM livros WHERE id__Livros = ?";

    // Formata o SQL com as informações e roda no banco.
    return jdbcTemplate.queryForObject(sql, new Object[]{id}, new livrosEntidadeRepositorioRowMapper());
  }

  @Override
  public List<livrosEntidadeRepositorio> findAll() throws DataAccessException {
    // Define o SQL.
    String sql = "SELECT * FROM livros";

    // Formata o SQL com as informações e roda no banco.
    return jdbcTemplate.query(sql, new livrosEntidadeRepositorioRowMapper());
  }
}
