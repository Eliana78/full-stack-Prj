package com.Esame.service;

import java.util.List;

import com.Esame.entities.Biglietto;

public interface BigliettoService {

	

	List<Biglietto> getAllBiglietti();
	Biglietto addBiglietto(Biglietto b);
	void deleteBiglietto(int id);
	Biglietto updateBiglietto(Biglietto b);
	
}
