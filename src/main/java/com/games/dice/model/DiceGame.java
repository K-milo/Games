package com.games.dice.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import com.games.model.Game;

@Entity
public abstract class DiceGame extends Game {

}
