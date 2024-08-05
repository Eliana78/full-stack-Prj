package com.Bookstore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bookstore.entities.Categoria;
import com.Bookstore.entities.Libro;
import com.Bookstore.service.LibroService;

@RestController
@RequestMapping("/api")
public class LibroCtrl {

	@Autowired
	LibroService libroService;
	
	
	@GetMapping("/libri")
	@CrossOrigin
	public List<Libro> getAllLibri(){
		return libroService.getAllLibri();
	};
	
	
	@PostMapping("/libri/add")
	@CrossOrigin
	public Libro addLibro(@RequestBody Libro libro) {
		return libroService.addLibro(libro);
	};
	
	
	@PutMapping("/libri/update")
	@CrossOrigin
	public Libro updateLibro(@RequestBody Libro libro) {
		return libroService.updateLibro(libro);
	};
	
	
	@DeleteMapping("(libri/delete/{id}")
	@CrossOrigin
	public void deleteLibro (@PathVariable("id") int id) {
		libroService.deleteLibro(id);
	};

	
	@GetMapping("/libri/categoria/{categoria}")
	@CrossOrigin
	public List<Libro> findByCategoria(@PathVariable Categoria categoria){
		return libroService.findByCategoria(categoria);
	};
	
	@GetMapping("/libri/titolo/{titolo}")
	@CrossOrigin
	public ResponseEntity<Libro> getByTitolo(@PathVariable String titolo){
		Optional<Libro> optionalLibro=libroService.getByTitolo(titolo);
		if(optionalLibro.isPresent()) {
			return ResponseEntity.ok(optionalLibro.get());
		}else {
		return	ResponseEntity.notFound().build();}
	};
	
	@GetMapping("/libri/id/{id}")
	@CrossOrigin
	public ResponseEntity <Libro> getById(@PathVariable int id){
		Optional<Libro> optionalLibro=libroService.getById(id);
		if(optionalLibro.isPresent()) {
			return ResponseEntity.ok(optionalLibro.get());
		}else {
		return	ResponseEntity.notFound().build();}
	};
	
	
	@GetMapping("/libri/prezzo/{prezzo}")
	@CrossOrigin
	 public List<Libro> getLibroByPrezzo(@PathVariable double prezzo) {
        return libroService.getLibroByPrezzo(prezzo);
    };
	
}

