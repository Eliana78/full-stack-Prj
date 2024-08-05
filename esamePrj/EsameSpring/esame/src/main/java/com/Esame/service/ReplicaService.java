package com.Esame.service;

import java.util.List;

import com.Esame.entities.Replica;
import com.Esame.entities.Spettacolo;

public interface ReplicaService {

	List<Replica> getAllRepliche();
	Replica addReplica(Replica r);
	void deleteReplica(Replica r);
	Replica updateReplica(Replica r);
	
	
}
