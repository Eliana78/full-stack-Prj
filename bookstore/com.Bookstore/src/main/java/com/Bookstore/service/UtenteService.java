package com.Bookstore.service;

import java.util.List;

import com.Bookstore.entities.Utente;

public interface UtenteService {

	List<Utente> getAllUtente();
	
	Utente addUtente(Utente utente);
	
	Utente updateUtente(Utente utente);
	
	void deleteUtente (int id);
	
	
}
