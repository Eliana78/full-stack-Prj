package com.Esame.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Esame.entities.Cliente;
import com.Esame.repo.ClienteRepo;



@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepo clienteRepo;
	
	
	@Override
	public List<Cliente> getAllClienti() {
		
		return clienteRepo.findAll();
	}

	@Override
	public Cliente addCliente(Cliente c) {
		
		return clienteRepo.save(c);
	}

	@Override
	public void deleteCliente(int id) {
		clienteRepo.deleteById(id);

	}

	@Override
	public Cliente updateCliente(Cliente c) {
		
		return clienteRepo.save(c);
	}

	@Override
	public Optional<Cliente> getClienteById(int id) {
		
		return clienteRepo.findById(id);
	}

}
