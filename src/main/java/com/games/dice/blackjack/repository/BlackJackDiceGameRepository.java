package com.games.dice.blackjack.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.games.dice.blackjack.model.BlackJackDiceGame;

@Repository
public interface BlackJackDiceGameRepository extends CrudRepository<BlackJackDiceGame, Long>{

}
