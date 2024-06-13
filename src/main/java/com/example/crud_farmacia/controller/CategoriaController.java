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

import com.example.crud_farmacia.model.Categoria;
import com.example.crud_farmacia.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	    @Autowired
	    private CategoriaService categoriaService;

	    @GetMapping
	    public List<Categoria> findAll() {
	        return categoriaService.findAll();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Categoria> findById(@PathVariable Long id) {
	        return categoriaService.findById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public Categoria create(@RequestBody Categoria categoria) {
	        return categoriaService.save(categoria);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria categoria) {
	        return categoriaService.findById(id)
	                .map(c -> {
	                    categoria.setId(id);
	                    return ResponseEntity.ok(categoriaService.save(categoria));
	                })
	                .orElse(ResponseEntity.notFound().build());
	   }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Object> delete(@PathVariable Long id) {
	        return categoriaService.findById(id)
	                .map(c -> {
	                    categoriaService.deleteById(id);
	                    return ResponseEntity.noContent().build();
	                })
	                .orElse(ResponseEntity.notFound().build());
	    }
}
