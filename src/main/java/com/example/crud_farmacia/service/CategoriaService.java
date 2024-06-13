package com.example.crud_farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud_farmacia.model.Categoria;
import com.example.crud_farmacia.repository.CategoriaRepository;

@Service
public class CategoriaService {

	  @Autowired
	  private CategoriaRepository categoriaRepository;

	  public List<Categoria> findAll() {
	      return categoriaRepository.findAll();
	  }

	  public Optional<Categoria> findById(Long id) {
	      return categoriaRepository.findById(id);
	  }

	  public Categoria save(Categoria categoria) {
	      return categoriaRepository.save(categoria);
	  }

	  public Categoria update(Categoria categoria) {
	      if (categoria.getId() != null) {
	          return categoriaRepository.save(categoria);
	      }
	    throw new RuntimeException("Categoria não encontrada");
	  }

	  public void deleteById(Long id) {
	      categoriaRepository.deleteById(id);
	  }
}
