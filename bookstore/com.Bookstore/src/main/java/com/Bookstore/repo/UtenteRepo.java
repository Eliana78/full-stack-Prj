package com.Bookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Bookstore.entities.Utente;

@Repository
public interface UtenteRepo extends JpaRepository<Utente, Integer> {

	
}
