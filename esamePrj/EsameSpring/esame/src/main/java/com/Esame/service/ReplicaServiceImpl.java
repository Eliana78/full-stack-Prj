package com.Esame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Esame.entities.Replica;
import com.Esame.repo.ReplicaRepo;


@Service
public class ReplicaServiceImpl implements ReplicaService {

	@Autowired
	ReplicaRepo replicaRepo;
	
	@Override
	public List<Replica> getAllRepliche() {
		
		return replicaRepo.findAll();
	}

	@Override
	public Replica addReplica(Replica r) {
		
		return replicaRepo.save(r);
	}

	@Override
	public void deleteReplica(Replica r) {
	replicaRepo.delete(r);

	}

	@Override
	public Replica updateReplica(Replica r) {
		
		return replicaRepo.save(r);
	}

}
