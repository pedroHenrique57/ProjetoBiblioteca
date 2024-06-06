package edu.syne.UI.controller;

import edu.syne.application.entities.alunoRDN;
import edu.syne.application.useCases.alunos.alunoInteractor;
import edu.syne.domain.entities.alunoEntidadeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class alunoController {

  alunoInteractor alunoInteractor;

  @Autowired
  public alunoController(alunoInteractor alunoInteractor) {
    this.alunoInteractor = alunoInteractor;
  }

  @PostMapping("/aluno/criar")
  public ResponseEntity<String> criarAluno(@RequestBody alunoRDN alunoParaCriar) {
    try {
      alunoInteractor.create(alunoParaCriar);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Deu ruim, aqui o erro informado: " + e.getMessage() + "\nAqui está o Objeto que você enviou para debbug: " + alunoParaCriar);
    }

    return ResponseEntity.ok().body("Deu bom, aqui o objeto criado: " + alunoParaCriar);
  }

  @PatchMapping("/aluno/patch")
  public ResponseEntity<String> atualizarAluno(@RequestBody alunoEntidadeRepositorio alunoParaAtualizar) {
    try {
      alunoInteractor.update(alunoParaAtualizar);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Deu ruim, aqui o erro informado: " + e.getMessage() + "\nAqui está o Objeto que você enviou para debbug: " + alunoParaAtualizar);
    }

    return ResponseEntity.ok().body("Deu bom, aqui o objeto atualizado: " + alunoParaAtualizar);
  }

  @DeleteMapping("/aluno/delete/{id}")
  public ResponseEntity<String> deletarAluno(@PathVariable("id") String id) {
    try {
      alunoInteractor.delete(id);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Deu ruim, aqui o erro informado: " + e.getMessage() + "\nAqui está o Objeto que você enviou para debbug: " + id);
    }

    return ResponseEntity.ok().body("Deu bom, aqui o id deletado: " + id);
  }

  @GetMapping("/aluno/findbyid/{id}")
  public ResponseEntity<String> findByIdAluno(@PathVariable("id") String id) {
    alunoEntidadeRepositorio aluno;
    try {
      aluno = alunoInteractor.findById(id);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Deu ruim, aqui o erro informado: " + e.getMessage() + "\nAqui está o Objeto que você enviou para debbug: " + id);
    }

    return ResponseEntity.ok().body(aluno.toString());
  }

  @GetMapping("/aluno/findall")
  public ResponseEntity<String> findall() {
    List<alunoEntidadeRepositorio> aluno;
    try {
      aluno = alunoInteractor.findAll();
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }

    return ResponseEntity.ok().body(aluno.toString());
  }
}
