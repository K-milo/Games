package com.games.service;

public interface GameService<TGame, TPlayer> {

	/**
	 * Get the game from the persistent context based on the unique identifier
	 * @param id unique id for the game
	 * @return {@link Game} from the persistent context
	 */
	public TGame getGameById(long id);
	
	/**
	 * Save any changes to the {@link Game} object to the persistent context
	 * @param game game to be saved
	 * @return saved game attached to the persistent context
	 */
	public TGame saveGame(TGame game);
	
	/**
	 * Start a game. This begins the current game tracking.  Setup of the game is completed.  If it
	 * is a tournament, all players should be registered at this time.<br /><br />
	 * 
	 * This will assign starting positions to all of the players.  This will not start the blind level,
	 * that will happen at the start of the first hand.
	 * @param game
	 * @return
	 */
	public TGame startGame(TGame game);
	
	/**
	 * Add a new player to an existing game
	 * @param game game to add the player to
	 * @param player {@link Player} to add to the game
	 * @return Player with persisted context.  Null if the game is not accepting new players.
	 */
	public TPlayer addNewPlayerToGame(TGame game, TPlayer player);
	
	/**
	 * Persist any changes to a {@link Player} domain object.  Or create a new one.
	 * @param player Player to be saved
	 * @return Player attached to the persistent context
	 */
	public TPlayer savePlayer(TPlayer player);
	
	
}
