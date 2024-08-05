package com.Bookstore.controller;

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

import com.Bookstore.entities.Ordine;
import com.Bookstore.entities.Utente;
import com.Bookstore.service.OrdineService;

@RestController
@RequestMapping("/api")

public class OrdineCtrl {

	@Autowired
	OrdineService ordineService;
	
	@GetMapping("/ordini")
	@CrossOrigin
	public List<Ordine> getAllOrdine(){
		return ordineService.getAllOrdine();
	};
	
	
	@PostMapping("/ordini/add")
	@CrossOrigin
	public Ordine addOrdine(@RequestBody Ordine ordine) {
		return ordineService.addOrdine(ordine);
	};
	
	@PutMapping("/ordini/update")
	@CrossOrigin
	public Ordine updateOrdine(Ordine ordine) {
		return ordineService.updateOrdine(ordine);
	};
	
	
	@DeleteMapping("/ordini/delete/{id}")
	@CrossOrigin
	public void deleteOrdine (@PathVariable int id) {
		ordineService.deleteOrdine(id);
	};
	
	
	@GetMapping("/ordini/{id}")
	@CrossOrigin
	public ResponseEntity<Ordine> getById(@PathVariable Integer id){
		Optional<Ordine> optionalOrdine= ordineService.getById(id);
		if (optionalOrdine.isPresent()) {
		return ResponseEntity.ok(optionalOrdine.get());
	}else {
		return ResponseEntity.notFound().build();}
		
	}
	
	
	@GetMapping("/ordini/utente/{utente}")
	@CrossOrigin
	public ResponseEntity<Ordine> getByUtente(@PathVariable Utente utente){
		Optional<Ordine> optionalOrdine= ordineService.getByUtente(utente);
		if (optionalOrdine.isPresent()) {
			return ResponseEntity.ok(optionalOrdine.get());
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
}
