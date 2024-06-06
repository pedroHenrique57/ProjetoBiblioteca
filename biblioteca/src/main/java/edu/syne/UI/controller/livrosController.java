package edu.syne.UI.controller;

import edu.syne.application.entities.livrosRDN;
import edu.syne.domain.entities.livrosEntidadeRepositorio;
import edu.syne.application.useCases.livros.livrosInteractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class livrosController {
  livrosInteractor livrosInteractor;

  @Autowired
  public livrosController(livrosInteractor livrosInteractor) {
    this.livrosInteractor = livrosInteractor;
  }

  @PostMapping("/livros/criar")
  public ResponseEntity<String> criarlivros(@RequestBody livrosRDN livrosParaCriar) {
    try {
      livrosInteractor.create(livrosParaCriar);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Deu ruim, aqui o erro informado: " + e.getMessage() + "\nAqui está o Objeto que você enviou para debbug: " + livrosParaCriar);
    }

    return ResponseEntity.ok().build();
  }

  @PatchMapping("/livros/patch")
  public ResponseEntity<String> atualizarlivros(@RequestBody livrosEntidadeRepositorio livrosParaAtualizar) {
    try {
      livrosInteractor.update(livrosParaAtualizar);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Deu ruim, aqui o erro informado: " + e.getMessage() + "\nAqui está o Objeto que você enviou para debbug: " + livrosParaAtualizar);
    }

    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/livros/delete/{id}")
  public ResponseEntity<String> deletarlivros(@PathVariable("id") int id) {
    try {
      livrosInteractor.delete(id);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Deu ruim, aqui o erro informado: " + e.getMessage() + "\nAqui está o Objeto que você enviou para debbug: " + id);
    }

    return ResponseEntity.ok().build();
  }

  @GetMapping("/livros/findbyid/{id}")
  public ResponseEntity<?> findByIdlivros(@PathVariable("id") int id) {
    livrosEntidadeRepositorio livros;
    try {
      livros = livrosInteractor.findById(id);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Deu ruim, aqui o erro informado: " + e.getMessage());
    }

    return ResponseEntity.ok().body(livros);
  }

  @GetMapping("/livros/findall")
  public ResponseEntity<?> findall() {
    List<livrosEntidadeRepositorio> livros;
    try {
      livros = livrosInteractor.findAll();
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Deu ruim, aqui o erro informado: " + e.getMessage());
    }

    return ResponseEntity.ok().body(livros);
  }
}
