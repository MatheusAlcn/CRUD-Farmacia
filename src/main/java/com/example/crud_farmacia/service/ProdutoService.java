package com.example.crud_farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud_farmacia.model.Produto;
import com.example.crud_farmacia.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> findById(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto update(Produto produto) {
        if (produto.getId() != null) {
            return produtoRepository.save(produto);
        }
        throw new RuntimeException("Produto não encontrado");
    }

    public void deleteById(Long id) {
        produtoRepository.deleteById(id);
    }
}
