package edu.syne.UI.controller;

import edu.syne.application.entities.emprestimoRDN;
import edu.syne.application.useCases.emprestimo.emprestimoInteractor;
import edu.syne.domain.entities.emprestimoEntidadeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class emprestimoController {

  emprestimoInteractor emprestimoInteractor;

  @Autowired
  public emprestimoController(edu.syne.application.useCases.emprestimo.emprestimoInteractor emprestimoInteractor) {
    this.emprestimoInteractor = emprestimoInteractor;
  }

  @PostMapping("/emprestimo/criar")
  public ResponseEntity<String> criarEmprestimo(@RequestBody emprestimoRDN emprestimoParaCriar) {
    try {
      emprestimoInteractor.create(emprestimoParaCriar);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Deu ruim, aqui o erro informado: " + e.getMessage() + "\nAqui está o Objeto que você enviou para debbug: " + emprestimoParaCriar);
    }

    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/emprestimo/delete")
  public ResponseEntity<String> deletarEmprestimo(@RequestBody emprestimoEntidadeRepositorio emprestimoParaDeletar) {
    System.out.println(emprestimoParaDeletar);
    try {
      emprestimoInteractor.delete(emprestimoParaDeletar.getAluno__RA(), emprestimoParaDeletar.getId__Livro());
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Deu ruim, aqui o erro informado: " + e.getMessage() + "\nAqui está o Objeto que você enviou para debbug: " + emprestimoParaDeletar);
    }

    return ResponseEntity.ok().build();
  }

  @GetMapping("/emprestimo/findEmprestimobyBook/{id}")
  public ResponseEntity<?> findEmprestimoByBook(@PathVariable("id") int id) {
    List<emprestimoEntidadeRepositorio> emprestimo;
    try {
      emprestimo = emprestimoInteractor.findEmprestimoByLivro(id);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Deu ruim, aqui o erro informado: " + e.getMessage() + "\nAqui está o Objeto que você enviou para debbug: " + id);
    }

    return ResponseEntity.ok().body(emprestimo);
  }

  @GetMapping("/emprestimo/findEmprestimobyAluno/{ra}")
  public ResponseEntity<?> findEmprestimoByAluno(@PathVariable("ra") String ra) {
    List<emprestimoEntidadeRepositorio> emprestimo;
    try {
      emprestimo = emprestimoInteractor.findEmprestimoByAluno(ra);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Deu ruim, aqui o erro informado: " + e.getMessage() + "\nAqui está o Objeto que você enviou para debbug: " + ra);
    }

    return ResponseEntity.ok().body(emprestimo);
  }

  @GetMapping("/emprestimo/findall")
  public ResponseEntity<?> findall() {
    List<emprestimoEntidadeRepositorio> emprestimo;
    try {
      emprestimo = emprestimoInteractor.findAll();
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Deu ruim, aqui o erro informado: " + e.getMessage());
    }

    return ResponseEntity.ok().body(emprestimo);
  }
}
