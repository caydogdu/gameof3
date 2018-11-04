package com.gameof3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "game_id")
    private Long gameId;

    @Column(name = "name")
    private String name;

    public Long getGameId() {
        return gameId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}