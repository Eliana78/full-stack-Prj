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

import com.Esame.entities.Biglietto;
import com.Esame.service.BigliettoService;

@RestController
@RequestMapping("/api")
public class BiglietteriaController {

	@Autowired
	BigliettoService bigliettoService;

	@GetMapping("/biglietti")
	@CrossOrigin
	public List<Biglietto> getAllBiglietti(){
		return bigliettoService.getAllBiglietti();
	};
	
	
	
	@PostMapping("/biglietti/add")
	@CrossOrigin
	public Biglietto addBiglietto(@RequestBody Biglietto b) {
		return bigliettoService.addBiglietto(b);
	};
	
	
	@DeleteMapping("biglietti/delete/{id}")
	@CrossOrigin
	public void deleteBiglietto(@PathVariable int id) {
		bigliettoService.deleteBiglietto(id);
	};
	
	
	@PutMapping("biglietti/update")
	@CrossOrigin
	public Biglietto updateBiglietto(@RequestBody Biglietto b) {
		return bigliettoService.updateBiglietto(b);
	};
	
	
	
	
	
}
