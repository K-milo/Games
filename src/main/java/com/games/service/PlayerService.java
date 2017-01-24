package com.games.service;

public interface PlayerService <TPlayer>{

	/**
	 * Get the {@link Player} domain object based on the unique id for that player
	 * @param playerId unique id for the player
	 * @return Player object
	 */
	public TPlayer getPlayerById(long playerId);
	
	
}
