package com.Esame.service;

import java.util.List;

import com.Esame.entities.Teatro;

public interface TeatroService {

	
	List<Teatro> getAllTeatri();
	Teatro addTeatro(Teatro t);
	void deleteTeatro(Teatro t);
	Teatro updateTeatro(Teatro t);
}
