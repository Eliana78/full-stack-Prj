package com.Bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Bookstore.entities.Categoria;
import com.Bookstore.entities.Libro;
import com.Bookstore.repo.LibroRepo;



@Service
public class LibroServiceImpl implements LibroService {

	
	@Autowired
	LibroRepo libroRepo;
	
	@Override
	public List<Libro> getAllLibri() {
		
		return libroRepo.findAll() ;
	}

	@Override
	public Libro addLibro(Libro libro) {
		
		return libroRepo.save(libro);
	}

	@Override
	public Libro updateLibro(Libro libro) {
		
		return libroRepo.save(libro);
	}

	@Override
	public void deleteLibro(int id) {
		
		libroRepo.deleteById(id);
	}

	@Override
	public List<Libro> findByCategoria(Categoria categoria) {
		
		return libroRepo.findByCategoria(categoria) ;
	}

	@Override
	public Optional<Libro> getByTitolo(String titolo) {
		
		return	libroRepo.findByTitolo(titolo);
		
	}

	@Override
	public Optional<Libro> getById(int id) {
		
		return libroRepo.findById(id);
	}

	@Override
	public List<Libro> getLibroByPrezzo(double prezzo) {
		
		return libroRepo.findLibroByPrezzo(prezzo);
	}

}
