package com.games.dice.blackjack.service;



import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.games.dice.blackjack.model.BlackJackDiceGame;
import com.games.dice.blackjack.model.BlackJackDicePlayer;
import com.games.dice.blackjack.repository.BlackJackDiceGameRepository;
import com.games.dice.blackjack.repository.BlackJackDicePlayerRepository;
import com.games.service.GameService;


@Service
public class BlackJackDiceGameService implements GameService<BlackJackDiceGame, BlackJackDicePlayer>{

	@Autowired
	private BlackJackDiceGameRepository gameRepository;
	
	@Autowired
	private BlackJackDicePlayerRepository playerRepository;
	
	@Override
	public BlackJackDiceGame getGameById(long id) {
		BlackJackDiceGame game = gameRepository.findOne(id);
		return game;
	}
	
	@Override
	public BlackJackDiceGame saveGame(BlackJackDiceGame game){
		return gameRepository.save(game);
	}
	
	@Override
	public BlackJackDiceGame startGame(BlackJackDiceGame game){
		game = gameRepository.save(game);
		if(game.getPlayers().size() < 2){
			throw new IllegalStateException("Not Enough Players");
		}
		if(game.getPlayers().size() > 10){
			throw new IllegalStateException("Too Many Players");
		}
		if(game.isStarted()){
			throw new IllegalStateException("Game already started");
		}
		
		//Set started flag
		game.setStarted(true);
		//Save and return the updated game
		return gameRepository.save(game);
	}
	
	@Override
	public BlackJackDicePlayer addNewPlayerToGame(BlackJackDiceGame game, BlackJackDicePlayer player){
		if(game.isStarted()){
			throw new IllegalStateException("Game in progress, no new players may join");
		}
		game = gameRepository.save(game);
		
		player.setGame(game);
		
		player = playerRepository.save(player);
		if(player == null){
			return null;
		}
		return player;
	}
	
	@Override
	public BlackJackDicePlayer savePlayer(BlackJackDicePlayer player){
		return playerRepository.save(player);
	}

}
