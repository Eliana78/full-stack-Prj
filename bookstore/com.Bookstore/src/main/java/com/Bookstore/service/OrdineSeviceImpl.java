package com.Bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bookstore.entities.Ordine;
import com.Bookstore.entities.Utente;
import com.Bookstore.repo.OrdineRepo;

@Service
public class OrdineSeviceImpl implements OrdineService {

	@Autowired
	OrdineRepo ordineRepo;
	
	
	@Override
	public List<Ordine> getAllOrdine() {
		
		return ordineRepo.findAll();
	}

	@Override
	public Ordine addOrdine(Ordine ordine) {
		
		return ordineRepo.save(ordine);
	}

	@Override
	public Ordine updateOrdine(Ordine ordine) {
		
		return ordineRepo.save(ordine);
	}

	@Override
	public void deleteOrdine(int id) {
		ordineRepo.deleteById(id);

	}

	@Override
	public Optional<Ordine> getById(Integer id) {
		
		return ordineRepo.findById(id);
	}

	@Override
	public Optional<Ordine> getByUtente(Utente utente) {
		
		return ordineRepo.findByUtente(utente);
	}

}
