package com.games.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public interface GameController {
	/**
	 * Create a new game based on the parameters from the URL Request
	 * <br /><br />
	 * The standard URL Request to the path /create with two parameters, like:
	 * url.com/create?gameName=MyGame
	 * <br /><br />
	 *  Return JSON response with one value, gameId.
	 * @param gameName Name to identify this game
	 * @return {"gameId":xxxx}.  The Java Method returns the Map<String,Long> which is converted
	 * by Spring to the JSON object.
	 */
	@RequestMapping(value="/create")
	public @ResponseBody Map<String,Long> createGame(@RequestParam String gameName);
	
	/**
	 * Get the status of the game and the list of all players in the game.
	 * <br /><br />
	 * The response will be a JSON Object containing the status, a list of player JSON objects
	 * @param gameId unique identifier for the game
	 * @return JSON Object of game status
	 */
	@RequestMapping(value="/gamestatus")
	public @ResponseBody Map<String, Object> getGameStatus(@RequestParam long gameId);
	
	/**
	 * Start the game.  This should be called when the players have joined and everyone is ready to begin.
	 * @param gameId unique ID for the game that is to be started
	 * @return Map representing a JSON string with a single field for "success" which is either true or false.
	 * example: {"success":true}
	 */
	@RequestMapping("/startgame")
	public @ResponseBody Map<String,Boolean> startGame(@RequestParam long gameId);
}
