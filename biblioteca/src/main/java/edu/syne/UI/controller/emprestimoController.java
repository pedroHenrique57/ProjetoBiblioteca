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
  public ResponseEntity<String> criarAluno(@RequestBody emprestimoRDN emprestimoParaCriar) {
    try {
      emprestimoInteractor.create(emprestimoParaCriar);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Deu ruim, aqui o erro informado: " + e.getMessage() + "\nAqui está o Objeto que você enviou para debbug: " + emprestimoParaCriar);
    }

    return ResponseEntity.ok().body("Deu bom, aqui o objeto criado: " + emprestimoParaCriar);
  }

  @DeleteMapping("/emprestimo/delete")
  public ResponseEntity<String> deletarAluno(@RequestBody emprestimoRDN emprestimoParaDeletar) {
    try {
      emprestimoInteractor.delete(emprestimoParaDeletar.getAluno__RA(), emprestimoParaDeletar.getLivros__id__livros());
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Deu ruim, aqui o erro informado: " + e.getMessage() + "\nAqui está o Objeto que você enviou para debbug: " + emprestimoParaDeletar);
    }

    return ResponseEntity.ok().body("Deu bom, aqui os  id deletado: " + emprestimoParaDeletar);
  }

  @GetMapping("/emprestimo/findEmprestimobyBook/{id}")
  public ResponseEntity<?> findEmprestimoByBook(@PathVariable("id") int id) {
    List<emprestimoEntidadeRepositorio> emprestimo;
    try {
      emprestimo = emprestimoInteractor.findLivroById(id);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Deu ruim, aqui o erro informado: " + e.getMessage() + "\nAqui está o Objeto que você enviou para debbug: " + id);
    }

    return ResponseEntity.ok().body(emprestimo);
  }

  @GetMapping("/emprestimo/findEmprestimobyAluno/{ra}")
  public ResponseEntity<String> findEmprestimoByAluno(@PathVariable("ra") String ra) {
    List<emprestimoEntidadeRepositorio> emprestimo;
    try {
      emprestimo = emprestimoInteractor.findAlunoById(ra);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Deu ruim, aqui o erro informado: " + e.getMessage() + "\nAqui está o Objeto que você enviou para debbug: " + ra);
    }

    return ResponseEntity.ok().body("Deu bom, aqui o Objeto encontrado id achado: " + emprestimo);
  }

  @GetMapping("/emprestimo/findall")
  public ResponseEntity<String> findall() {
    List<emprestimoEntidadeRepositorio> emprestimo;
    try {
      emprestimo = emprestimoInteractor.findAll();
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Deu ruim, aqui o erro informado: " + e.getMessage());
    }

    return ResponseEntity.ok().body("Deu bom, aqui a lista de Objeto encontrado achado: " + emprestimo);
  }
}
