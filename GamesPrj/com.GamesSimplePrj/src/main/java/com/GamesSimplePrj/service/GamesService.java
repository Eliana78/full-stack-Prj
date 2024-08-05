package com.GamesSimplePrj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.GamesSimplePrj.entity.Game;

public interface GamesService {

	
	List<Game> getAllGames();
	
	Game addGames(Game game);
	
	void deleteGame(Integer id);
	
	@Query(value = "SELECT * FROM games_games WHERE title LIKE %?1%", nativeQuery = true)
	List<Game> getByTitleContaining(String name);
	
	@Query(value = "SELECT * FROM games_games WHERE price BETWEEN ?1 AND ?2", nativeQuery = true)
	List<Game> getByPriceRange(double minPrice, double maxPrice);

	
}
