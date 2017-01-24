package com.games.dice.blackjack.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.games.dice.blackjack.model.BlackJackDiceGame;
import com.games.dice.blackjack.model.BlackJackDicePlayer;
import com.games.dice.blackjack.service.BlackJackDiceGameService;
import com.games.dice.blackjack.service.BlackJackDicePlayerService;
import com.games.dice.controller.DicePlayerController;

@Controller
@RequestMapping("/blackjack")
public class BlackJackDicePlayerController implements DicePlayerController{

	@Autowired
	private BlackJackDiceGameService gameService;
	
	@Autowired
	private BlackJackDicePlayerService playerService;
	
	@RequestMapping("/join")
	public @ResponseBody Map<String, Long> joinGame(@RequestParam(value="gameid") long gameId, @RequestParam(value="player") String playerName){
		BlackJackDiceGame game = gameService.getGameById(gameId);
		BlackJackDicePlayer player = new BlackJackDicePlayer();
		player.setName(playerName);
		player = gameService.addNewPlayerToGame(game, player);
		return Collections.singletonMap("playerId", player.getId());
	}

	@RequestMapping("/throw")
	public @ResponseBody Map<String,Integer> throwDice(@RequestParam(value="gameid") long gameId, @RequestParam(value="playerid") long playerId, @RequestParam int score){
		BlackJackDiceGame game = gameService.getGameById(gameId);
		
		if(game.isStarted()){
			BlackJackDicePlayer player = playerService.getPlayerById(playerId);
			player = playerService.scoreDices(player, score);
			return Collections.singletonMap("success", score);
		}
		return Collections.singletonMap("failure", 0);
	}

	
}
