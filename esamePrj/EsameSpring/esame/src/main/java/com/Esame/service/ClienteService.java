package com.Esame.service;

import java.util.List;
import java.util.Optional;

import com.Esame.entities.Cliente;

public interface ClienteService {

	
	List<Cliente> getAllClienti();
	Cliente addCliente(Cliente c);
	void deleteCliente(int id);
	Cliente updateCliente(Cliente c);
	
	Optional<Cliente> getClienteById(int id);
	
	
	
}
