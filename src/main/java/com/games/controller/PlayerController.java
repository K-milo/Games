package com.games.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("player")
public interface PlayerController {

	/**
	 * Have a new player join a game.
	 * @param gameId unique ID for the game to be joined
	 * @param playerName player name
	 * @return Map representing the JSON String of the new player's unique id.  The playerId will
	 * be used for that player's actions in future requests.  Example: {"playerId":xxx}
	 */
	@RequestMapping("/join")
	public @ResponseBody Map<String,Long> joinGame(@RequestParam long gameId, @RequestParam String playerName);
	
}
