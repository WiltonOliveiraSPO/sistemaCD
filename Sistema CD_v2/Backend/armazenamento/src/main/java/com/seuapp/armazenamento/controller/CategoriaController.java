package com.seuapp.armazenamento.controller;

import com.seuapp.armazenamento.entity.Categoria;
import com.seuapp.armazenamento.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "*") // Permite frontend acessar
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    // LISTAR TODAS
    @GetMapping
    public List<Categoria> listar() {
        return repository.findAll();
    }

    // BUSCAR POR SIGLA
    @GetMapping("/{sigla}")
    public ResponseEntity<Categoria> buscar(@PathVariable String sigla) {
        return repository.findById(sigla)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // CRIAR NOVA
    @PostMapping
    public Categoria criar(@RequestBody Categoria categoria) {
        return repository.save(categoria);
    }

    // ATUALIZAR
    @PutMapping("/{sigla}")
    public ResponseEntity<Categoria> atualizar(@PathVariable String sigla,
                                               @RequestBody Categoria nova) {
        return repository.findById(sigla)
                .map(atual -> {
                    atual.setDescricao(nova.getDescricao());
                    return ResponseEntity.ok(repository.save(atual));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // EXCLUIR
    @DeleteMapping("/{sigla}")
    public ResponseEntity<?> excluir(@PathVariable String sigla) {
        return repository.findById(sigla)
                .map(cat -> {
                    repository.delete(cat);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}