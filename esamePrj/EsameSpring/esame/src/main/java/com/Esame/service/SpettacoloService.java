package com.Esame.service;

import java.util.List;


import com.Esame.entities.Replica;
import com.Esame.entities.Spettacolo;

public interface SpettacoloService {

	List<Spettacolo> getAllSpettacoli();
	Spettacolo addSpettacolo(Spettacolo s);
	void deleteSpettacoloById(String id);
	Spettacolo updateSpettacolo(Spettacolo s);
	
}
