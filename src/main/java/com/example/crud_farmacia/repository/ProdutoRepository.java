package com.example.crud_farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud_farmacia.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
}
