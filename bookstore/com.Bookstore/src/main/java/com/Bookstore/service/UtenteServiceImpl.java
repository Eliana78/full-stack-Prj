package com.Bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bookstore.entities.Utente;
import com.Bookstore.repo.UtenteRepo;


@Service
public class UtenteServiceImpl implements UtenteService {

	@Autowired
	UtenteRepo utenteRepo;
	
	@Override
	public List<Utente> getAllUtente() {
		
		return utenteRepo.findAll();
	}

	@Override
	public Utente addUtente(Utente utente) {
		
		return utenteRepo.save(utente) ;
	}

	@Override
	public Utente updateUtente(Utente utente) {
		
		return utenteRepo.save(utente);
	}

	@Override
	public void deleteUtente(int id) {
		Optional<Utente> optionalUtente=utenteRepo.findById(id);
		if (!optionalUtente.isPresent()) {
			throw new MyException("user not found");
		}
		
		 utenteRepo.deleteById(id);

	}

}
