package com.Esame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Esame.entities.Spettacolo;
import com.Esame.repo.SpettacoloRepo;


@Service
public class SpettacoloServiceImpl implements SpettacoloService {

	@Autowired
	SpettacoloRepo spettacoloRepo;
	
	
	@Override
	public List<Spettacolo> getAllSpettacoli() {
		
		return spettacoloRepo.findAll();
	}

	@Override
	public Spettacolo addSpettacolo(Spettacolo s) {
	
		return spettacoloRepo.save(s);
	}

	@Override
	public void deleteSpettacoloById(String id) {
		spettacoloRepo.deleteById(id);;

	}

	@Override
	public Spettacolo updateSpettacolo(Spettacolo s) {
		
		return spettacoloRepo.save(s);
	}

}
