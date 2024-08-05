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

import com.Esame.entities.Teatro;
import com.Esame.service.TeatroService;

@RestController
@RequestMapping("/api")
public class TeatroController {

	@Autowired
	TeatroService teatroService;
	
	
	@GetMapping("/teatri")
	@CrossOrigin
	public 	List<Teatro> getAllTeatri(){
		return teatroService.getAllTeatri();
	};
	
	@PostMapping("/teatri/add")
	@CrossOrigin
	public Teatro addTeatro(@RequestBody Teatro t) {
		return teatroService.addTeatro(t);
	};
	
	@DeleteMapping("/teatri/delete")
	@CrossOrigin
	public void deleteTeatro(@PathVariable Teatro t) {
		teatroService.deleteTeatro(t);
	};
	
	@PutMapping("/teatri/update")
	@CrossOrigin
	public Teatro updateTeatro(@RequestBody Teatro t) {
		return teatroService.updateTeatro(t);
	};
	
	
	
	
}
