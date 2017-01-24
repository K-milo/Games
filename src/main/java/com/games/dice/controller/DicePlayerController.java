package com.games.dice.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.games.controller.PlayerController;

public interface DicePlayerController extends PlayerController{

//	/**
//	 * The player throw the dices.
//	 * @param playerId unique ID
//	 * @return Map representing the JSON String of the new player's unique id.  The playerId will
//	 * be used for that player's actions in future requests.  Example: {"playerId":xxx}
//	 */
//	@RequestMapping("/throw")
//	public @ResponseBody Map<String,Integer> throwDice(@RequestParam long playerId, @RequestParam int score);
	
}
