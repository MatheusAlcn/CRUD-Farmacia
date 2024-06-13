package com.example.crud_farmacia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Produto {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @NotBlank(message = "O nome do produto é obrigatório")
     private String nome;
	 
	 @NotNull(message = "O preço do produto é obrigatório")
	 private Double preco;

	 @ManyToOne
	 @NotNull(message = "A categoria é obrigatória")
	 private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	    
}
