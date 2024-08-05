package com.Bookstore.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Bookstore.entities.Ordine;
import com.Bookstore.entities.Utente;

@Repository
public interface OrdineRepo extends JpaRepository<Ordine, Integer> {

	Optional<Ordine> findById(Integer id);
	Optional<Ordine> findByUtente(Utente utente);
	
	
}
