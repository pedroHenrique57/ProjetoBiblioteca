package edu.syne.infrastructure.rowMapper;

import edu.syne.domain.entities.livrosEntidadeRepositorio;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class livrosEntidadeRepositorioRowMapper implements RowMapper<livrosEntidadeRepositorio> {
  @Override
  public livrosEntidadeRepositorio mapRow(ResultSet rs, int rowNum) throws SQLException {
    livrosEntidadeRepositorio livros = new livrosEntidadeRepositorio();
    livros.setId__Livros(rs.getInt("id__Livro"));
    livros.setNome__Livro(rs.getString("nome__Livro"));
    livros.setDescricao(rs.getString("descricao"));

    return livros;
  }
}
