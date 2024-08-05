package com.Bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Bookstore.entities.Categoria;
import com.Bookstore.entities.Libro;


public interface LibroService {

	
	List<Libro> getAllLibri();
	
	Libro addLibro(Libro libro);
	
	Libro updateLibro(Libro libro);
	
	void deleteLibro (int id);
	
	
	
	List<Libro> findByCategoria(Categoria categoria);
	
	Optional<Libro> getByTitolo(String titolo);
	
	Optional <Libro> getById(int id);
	
	
	
	List<Libro> getLibroByPrezzo(double prezzo);
	
}
