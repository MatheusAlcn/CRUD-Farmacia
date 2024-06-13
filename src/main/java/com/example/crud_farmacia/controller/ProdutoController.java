package com.example.crud_farmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud_farmacia.model.Produto;
import com.example.crud_farmacia.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> findAll() {
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        return produtoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Produto create(@RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.findById(id)
                .map(p -> {
                    produto.setId(id);
                    return ResponseEntity.ok(produtoService.save(produto));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return produtoService.findById(id)
                .map(p -> {
                    produtoService.deleteById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
