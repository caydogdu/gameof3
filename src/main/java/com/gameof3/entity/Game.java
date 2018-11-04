package com.gameof3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.gameof3.dto.GameDto;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "turn")
    private Long turn;

    @Column(name = "number")
    private int number;

    @Column(name = "game_over")
    private boolean gameOver;

    @Column(name = "game_started")
    private boolean gameStarted;

    public GameDto asDTO() {
        GameDto dto = new GameDto();
        dto.setId(getId());
        dto.setName(getName());
        dto.setTurn(getTurn());
        dto.setNumber(getNumber());
        dto.setGameOver(isGameOver());
        dto.setGameStarted(isGameStarted());
        return dto;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public Long getTurn() {
        return turn;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setTurn(Long turn) {
        this.turn = turn;
    }

    public void switchTurn() {
        setTurn((getTurn() + 1) % 2);
    }

}