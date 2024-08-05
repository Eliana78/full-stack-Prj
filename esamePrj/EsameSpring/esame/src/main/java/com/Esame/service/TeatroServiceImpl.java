package com.Esame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Esame.entities.Teatro;
import com.Esame.repo.TeatroRepo;


@Service
public class TeatroServiceImpl implements TeatroService {

	@Autowired
	TeatroRepo teatroRepo;
	
	@Override
	public List<Teatro> getAllTeatri() {
		return teatroRepo.findAll();
	}

	@Override
	public Teatro addTeatro(Teatro t) {
	
		return teatroRepo.save(t);
	}

	@Override
	public void deleteTeatro(Teatro t) {
		teatroRepo.delete(t);

	}

	@Override
	public Teatro updateTeatro(Teatro t) {
		
		return teatroRepo.save(t);
	}

}
