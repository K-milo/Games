package com.games.dice.blackjack.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.games.dice.model.DiceGame;

@Entity
public class BlackJackDiceGame extends DiceGame {

	private Set<BlackJackDicePlayer> players;
	
	@OneToMany(mappedBy="game", fetch=FetchType.EAGER)
	public Set<BlackJackDicePlayer> getPlayers() {
		return players;
	}
	public void setPlayers(Set<BlackJackDicePlayer> players) {
		this.players = players;
	}
}
