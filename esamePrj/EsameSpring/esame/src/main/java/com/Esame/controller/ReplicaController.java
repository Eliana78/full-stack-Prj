package com.Esame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Esame.entities.Replica;

import com.Esame.service.ReplicaService;

@RestController
@RequestMapping("/api")
public class ReplicaController {
	
	
	@Autowired
	ReplicaService replicaService;
	
	
	@GetMapping("/repliche")
	@CrossOrigin
	public List<Replica> getAllRepliche(){
		return replicaService.getAllRepliche();
	};

	@PostMapping("/repliche/add")
	@CrossOrigin
	public Replica addReplica(@RequestBody Replica r) {
		return replicaService.addReplica(r);
	};
	
	@DeleteMapping("/repliche/delete")
	@CrossOrigin
	public void deleteReplica(@PathVariable Replica r) {
		replicaService.deleteReplica(r);
	};
	
	
	
	@PutMapping("/repliche/update")
	@CrossOrigin
	public Replica updateReplica(@RequestBody Replica r) {
		return replicaService.updateReplica(r);
	};
	
	
	
	

}
