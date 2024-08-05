package com.GamesSimplePrj.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.GamesSimplePrj.entity.Game;


@Repository
public interface GamesRepo extends JpaRepository<Game, Integer> {

	@Query(value = "SELECT * FROM games_games WHERE title LIKE %?1%", nativeQuery = true)
	List<Game> findByTitleContaining(String name);
	
	@Query(value = "SELECT * FROM games_games WHERE price BETWEEN ?1 AND ?2", nativeQuery = true)
	List<Game> findByPriceRange(double minPrice, double maxPrice);

	
}
