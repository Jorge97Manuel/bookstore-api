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

		Livro l1 = new Livro(null, "Clean code", "Robert Martin",
				"Mesmo um código ruim pode funcionar. Mas se ele não for limpo, pode acabar com uma empresa de desenvolvimento.",
				cat1);
		Livro l2 = new Livro(null, "Geometria ", "Luis Tome",
				"Os Cadernos de Matemática pretendem apoiar e auxiliar os seus leitores  nomeadamente estudantes universitários ou pré-universitários no esforço individual de preparação em diversos temas de Matemática, abordando cada volume um assunto bem delimitado.",
				cat2);
		Livro l3 = new Livro(null, "50 Tons de Cinza", "Walter Brown",
				"A estudante de literatura Anastasia Steele, de 21 anos, entrevista o jovem bilionário Christian Grey, como um favor a sua colega de quarto Kate Kavanagh.",
				cat3);
		Livro l4 = new Livro(null, "JavaScript", "Jorge A",
				"JavaScript é uma linguagem de programação interpretada estruturada, de script em alto nível com tipagem dinâmica fraca e multiparadigma.",
				cat1);
		Livro l5 = new Livro(null, "Derivadas", "Manual Vianja",
				"No cálculo, a derivada em um ponto de uma função y=f(x) representa a taxa de variação instantânea de y em relação a x neste ponto.",
				cat2);

		cat1.getLivros().addAll(Arrays.asList(l1, l4));
		cat2.getLivros().addAll(Arrays.asList(l2, l5));
		cat3.getLivros().addAll(Arrays.asList(l3));

		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}

}
