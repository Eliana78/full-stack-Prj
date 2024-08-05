package com.GamesSimplePrj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GamesSimplePrj.entity.Game;
import com.GamesSimplePrj.repo.GamesRepo;



@Service
public class GamesServiceImpl implements GamesService {

	@Autowired
	GamesRepo gameRepo;
	
	
	@Override
	public List<Game> getAllGames() {
		return gameRepo.findAll();

	}

	@Override
	public Game addGames(Game game) {
		return gameRepo.save(game);

	}

	@Override
	public void deleteGame(Integer id) {
		gameRepo.deleteById(id);

	}

	@Override
	public List<Game> getByTitleContaining(String name) {
		
		return gameRepo.findByTitleContaining(name);
	};

	@Override
	public List<Game> getByPriceRange(double minPrice, double maxPrice) {
		
		return gameRepo.findByPriceRange(minPrice, maxPrice);
	}

}
