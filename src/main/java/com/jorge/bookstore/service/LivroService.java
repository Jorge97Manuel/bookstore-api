package com.jorge.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorge.bookstore.domain.Livro;
import com.jorge.bookstore.repositories.LivroRepository;
import com.jorge.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repository;
	
	public Livro findById(Integer id) {
		
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objecto não encontrado id: " + id + ", Tipo: " + Livro.class.getName()));
		
		
	}

}
