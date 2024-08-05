package com.GamesSimplePrj.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GamesSimplePrj.entity.Game;
import com.GamesSimplePrj.service.GamesService;

@RestController
@RequestMapping("/api")
public class GamesController {

	
	@Autowired
	GamesService gameService;
	
	@GetMapping("/games")
	@CrossOrigin
	public ResponseEntity<List<Game>> getAllGames() {
		return new ResponseEntity<List<Game>>(gameService.getAllGames(),HttpStatus.OK);

	}
	
	
	@PostMapping("/games/add")
	@CrossOrigin
	public ResponseEntity<Game> addGames(@RequestBody Game game) {
		return new ResponseEntity<Game>(gameService.addGames(game),HttpStatus.OK);
		
	};
	
	
	
	@DeleteMapping("/games/delete/{id}")
	@CrossOrigin
	public ResponseEntity<Void> deleteGame(@PathVariable Integer id) {
	    try {
	        gameService.deleteGame(id);
	        return ResponseEntity.noContent().build(); // 204 No Content
	    } catch (EmptyResultDataAccessException e) {
	        return ResponseEntity.notFound().build(); // 404 Not Found
	    }
	}

	
	
	@GetMapping("/games/title/{name}")
	@CrossOrigin
	public ResponseEntity<List<Game>> getByTitle(@PathVariable String name) {
	    List<Game> games = gameService.getByTitleContaining(name);
	    if (games.isEmpty()) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.ok(games);
	    }
	}
	
	
	@GetMapping("/games/priceRange/{minPrice}/{maxPrice}")
	@CrossOrigin
	public ResponseEntity<List<Game>> getByPriceRange(@PathVariable double minPrice, @PathVariable double maxPrice) {
	    List<Game> games = gameService.getByPriceRange(minPrice, maxPrice);
	    if (games.isEmpty()) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.ok(games);
	    }
	}
	
	
	
	
	
	
	
	
}
