package com.Esame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Esame.entities.Biglietto;
import com.Esame.repo.BigliettoRepo;


@Service
public class BigliettoServiceImpl implements BigliettoService {

	@Autowired
	BigliettoRepo bigliettoRepo;
	
	
	@Override
	public List<Biglietto> getAllBiglietti() {
		
		return bigliettoRepo.findAll();
	}

	@Override
	public Biglietto addBiglietto(Biglietto b) {
		
		return bigliettoRepo.save(b);
	}

	@Override
	public void deleteBiglietto(int id) {
			bigliettoRepo.deleteById(id);

	}

	@Override
	public Biglietto updateBiglietto(Biglietto b) {
		
		return bigliettoRepo.save(b);
	}

}
