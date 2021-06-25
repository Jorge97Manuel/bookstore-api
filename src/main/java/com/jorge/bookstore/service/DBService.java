package com.jorge.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorge.bookstore.domain.Categoria;
import com.jorge.bookstore.domain.Livro;
import com.jorge.bookstore.repositories.CategoriaRepository;
import com.jorge.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Matematica", "Livros de Matematica");
		Categoria cat3 = new Categoria(null, "Romance", "Livros de Historia");
		
		Livro l1 = new Livro(null, "Clean code", "Robert Martin","Lorem Y", cat1);
		Livro l2 = new Livro(null, "Geometria Analitica", "Luis Tome","Concava ", cat2);
		Livro l3 = new Livro(null, "50 Tons de Cinza", "Walter Brown","dknfjdsd", cat3);
		Livro l4 = new Livro(null, "JavaScript", "Jorge A","arrow Functions", cat1);
		Livro l5 = new Livro(null, "Derivadas", "Manual Vianja","Lorem Y", cat2);
		
		cat1.getLivros().addAll(Arrays.asList(l1, l4));
		cat2.getLivros().addAll(Arrays.asList(l2, l5));
		cat3.getLivros().addAll(Arrays.asList(l3));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}

}
