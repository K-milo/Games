package com.games.dice.blackjack.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.games.dice.blackjack.model.BlackJackDiceGame;
import com.games.dice.blackjack.model.BlackJackDicePlayer;
import com.games.dice.blackjack.service.BlackJackDiceGameService;
import com.games.dice.controller.DiceGameController;

@Controller
@RequestMapping("/blackjack")
public class BlackJackDiceGameController implements DiceGameController {

	@Autowired
	private BlackJackDiceGameService gameService;
	
	@RequestMapping(value="/create")
	public @ResponseBody Map<String,Long> createGame(@RequestParam(value="gamename") String gameName){
		BlackJackDiceGame game = new BlackJackDiceGame();
		game.setName(gameName);
		
		game = gameService.saveGame(game);
		
		return Collections.singletonMap("gameId", game.getId());
	}
	
	@RequestMapping(value="/gamestatus")
	public @ResponseBody Map<String, Object> getGameStatus(@RequestParam(value="gameid") long gameId){
		BlackJackDiceGame game = gameService.getGameById(gameId);
		Collection<BlackJackDicePlayer> players = game.getPlayers();
		
		Map<String, Object> results = new HashMap<String, Object>();
		results.put("isStarted", game.isStarted());
		results.put("players", players);
		
		return results;
	}
	
	@RequestMapping("/startgame")
	public @ResponseBody Map<String,Boolean> startGame(@RequestParam(value="gameid") long gameId){
		BlackJackDiceGame game = gameService.getGameById(gameId);
		if(!game.isStarted()){
			try{
				game = gameService.startGame(game);
				return Collections.singletonMap("success", true);
			}catch(Exception e){
				//Failure of some sort starting the game. Probably IllegalStateException
			}
		}
		return Collections.singletonMap("success", false);
	}
}
