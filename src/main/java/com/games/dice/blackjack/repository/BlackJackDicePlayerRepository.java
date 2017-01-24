package com.games.dice.blackjack.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.games.dice.blackjack.model.BlackJackDicePlayer;

@Repository
public interface BlackJackDicePlayerRepository extends CrudRepository<BlackJackDicePlayer, Long>{

}
