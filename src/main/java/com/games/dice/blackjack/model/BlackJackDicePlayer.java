package com.games.dice.blackjack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.games.dice.model.DicePlayer;

@Entity
public class BlackJackDicePlayer extends DicePlayer{
	
	private BlackJackDiceGame game;
	private int score;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="game_id")
	public BlackJackDiceGame getGame() {
		return game;
	}
	public void setGame(BlackJackDiceGame game) {
		this.game = game;
	}
	
	@Column(name="score")
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
}
}
