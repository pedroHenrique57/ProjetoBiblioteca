package edu.syne.infrastructure.rowMapper;

import edu.syne.domain.entities.emprestimoEntidadeRepositorio;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class emprestimoEntidadeRepositorioRowMapper implements RowMapper<emprestimoEntidadeRepositorio> {
  @Override
  public emprestimoEntidadeRepositorio mapRow(ResultSet rs, int rowNum) throws SQLException {
    emprestimoEntidadeRepositorio emprestimo = new emprestimoEntidadeRepositorio();
    emprestimo.setAluno__RA(rs.getString("aluno__RA"));
    emprestimo.setLivros__id__Livros(rs.getInt("Livros__id__Livros"));
    return emprestimo;
  }
}
