package com.gameof3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "game_id")
    private Long gameId;

    @Column(name = "name")
    private String name;

    @Column(name = "index")
    private Long index;

    public Long getGameId() {
        return gameId;
    }

    public Long getId() {
        return id;
    }

    public Long getIndex() {
        return index;
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

    public void setIndex(Long index) {
        this.index = index;
    }

    public void setName(String name) {
        this.name = name;
    }

}