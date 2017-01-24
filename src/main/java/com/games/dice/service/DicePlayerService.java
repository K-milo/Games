package com.games.dice.service;

import com.games.service.PlayerService;

public interface DicePlayerService<TPlayer> extends PlayerService<TPlayer>{

	/**
	 * The Player's scores dices
	 * @param player {@link Player} who throw dices
	 * @param score of dices.
	 * @return player {@link Player}
	 */
	public TPlayer scoreDices(TPlayer player, int score);
}
