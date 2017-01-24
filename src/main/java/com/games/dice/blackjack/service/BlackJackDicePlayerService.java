package com.games.dice.blackjack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.games.dice.blackjack.model.BlackJackDicePlayer;
import com.games.dice.blackjack.repository.BlackJackDicePlayerRepository;
import com.games.dice.service.DicePlayerService;

@Service
public class BlackJackDicePlayerService implements DicePlayerService<BlackJackDicePlayer>{

	@Override
	public BlackJackDicePlayer getPlayerById(long playerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlackJackDicePlayer scoreDices(BlackJackDicePlayer player, int score) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Autowired
//	private BlackJackDicePlayerRepository playerRepository;
//	
//	@Override
//	public BlackJackDicePlayer getPlayerById(long playerId) {
//		BlackJackDicePlayer player = playerRepository.findOne(playerId);
//		return player;
//	}
//
//	@Override
//	public BlackJackDicePlayer scoreDices(BlackJackDicePlayer player, int score) {
//		player.setScore(score);
//		return playerRepository.save(player);
//	}

}
