package com.Esame.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Esame.entities.Cliente;
import com.Esame.service.ClienteService;

@RestController
@RequestMapping("/api/clienti")
public class ClienteController {

	@Autowired
	public ClienteService clienteService;
	
	@GetMapping
	@CrossOrigin
	public List<Cliente> getAllClienti(){
		return clienteService.getAllClienti();
	};

	
	@PostMapping("/add")
	@CrossOrigin
	public Cliente addCliente(@RequestBody Cliente c) {
		return clienteService.addCliente(c);
	};
	
	@DeleteMapping("delete/{id}")
	@CrossOrigin
	public void deleteCliente(@PathVariable int id) {
		clienteService.deleteCliente(id);
	};
	
	@PutMapping("/update")
	@CrossOrigin
	public Cliente updateCliente(@RequestBody Cliente c) {
		return clienteService.addCliente(c);
	};
	
	
	@GetMapping("/id/{id}")
	@CrossOrigin
	public ResponseEntity<Cliente> getClienteById(@PathVariable int id){
		Optional<Cliente> clienteOptional=clienteService.getClienteById(id);
		
		if(clienteOptional.isPresent()) {
			return ResponseEntity.ok(clienteOptional.get());
		}else {
			return ResponseEntity.notFound().build()
;		}
	};
	
	
	
	
	
}
