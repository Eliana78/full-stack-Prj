package com.Bookstore.controller;

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

import com.Bookstore.entities.Utente;
import com.Bookstore.service.UtenteService;

@RestController
@RequestMapping("/api")
public class UtenteCtrl {

	@Autowired
	UtenteService utenteService;
	
	
	@GetMapping("/utenti")
	@CrossOrigin
	public List<Utente> getAllUtente(){
		return utenteService.getAllUtente();
	};
	
	
	@PostMapping("/utenti/add")
	@CrossOrigin
	Utente addUtente(@RequestBody Utente utente) {
		return utenteService.addUtente(utente);
	};
	
	@PutMapping("/utenti/update")
	@CrossOrigin
	Utente updateUtente(@RequestBody Utente utente) {
		return utenteService.updateUtente(utente);
	};
	
	
	 //you cab use (@PathVariable("id") int id) If the name of the method 
	//parameter doesn't match the name of the path variable in the URL and you want to clearly bind them.
	@DeleteMapping("/utenti/delete/{id}")
	@CrossOrigin
	void deleteUtente (@PathVariable int id) {
		utenteService.deleteUtente(id);
	};
	
}
