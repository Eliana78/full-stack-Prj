package com.Bookstore.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Bookstore.entities.Categoria;
import com.Bookstore.entities.Libro;

@Repository
public interface LibroRepo extends JpaRepository<Libro, Integer> {

	List<Libro> findByCategoria(Categoria categoria);
	
	Optional<Libro> findByTitolo(String titolo);
	
	Optional <Libro> findById(int id);
	
	
	@Query(value="select *from libri where prezzo=?1", nativeQuery=true)
	List<Libro> findLibroByPrezzo(@Param("prezzo") double prezzo);
}
