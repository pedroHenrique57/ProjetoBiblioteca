package edu.syne.infrastructure.rowMapper;

import edu.syne.domain.entities.alunoEntidadeRepositorio;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class alunoEntidadeRepositorioRowMapper implements RowMapper<alunoEntidadeRepositorio> {
  @Override
  public alunoEntidadeRepositorio mapRow(ResultSet rs, int rowNum) throws SQLException {
    alunoEntidadeRepositorio aluno = new alunoEntidadeRepositorio();
    aluno.setRA(rs.getString("RA"));
    aluno.setNome__aluno(rs.getString("nome__aluno"));
    aluno.setTurma(rs.getString("turma"));
    return aluno;
  }
}
