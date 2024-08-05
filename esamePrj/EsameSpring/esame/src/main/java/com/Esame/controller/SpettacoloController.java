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

import com.Esame.entities.Spettacolo;
import com.Esame.service.SpettacoloService;

@RestController
@RequestMapping("/api/spettacoli")
public class SpettacoloController {

	

	    @Autowired
	    SpettacoloService spettacoloService;

	    @GetMapping
	    @CrossOrigin
	    public List<Spettacolo> getAllSpettacoli() {
	        return spettacoloService.getAllSpettacoli();
	    }

	    @PostMapping("/add")
	    @CrossOrigin
	    public Spettacolo addSpettacolo(@RequestBody Spettacolo s) {
	        return spettacoloService.addSpettacolo(s);
	    }

	    @DeleteMapping("/delete/{id}")
	    @CrossOrigin
	    public void deleteSpettacolo(@PathVariable String id) {
	        spettacoloService.deleteSpettacoloById(id);
	    }

	    @PutMapping("/update")
	    @CrossOrigin
	    public Spettacolo updateSpettacolo(@RequestBody Spettacolo s) {
	        return spettacoloService.updateSpettacolo(s);
	    }
	}

	
	

