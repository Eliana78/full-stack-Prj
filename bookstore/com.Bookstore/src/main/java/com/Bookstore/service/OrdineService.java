package com.Bookstore.service;

import java.util.List;
import java.util.Optional;

import com.Bookstore.entities.Ordine;
import com.Bookstore.entities.Utente;

public interface OrdineService {

	
	List<Ordine> getAllOrdine();
	
	Ordine addOrdine(Ordine ordine);
	
	Ordine updateOrdine(Ordine ordine);
	
	void deleteOrdine (int id);
	
	Optional<Ordine> getById(Integer id);
	
	Optional<Ordine> getByUtente(Utente utente);
	
}
