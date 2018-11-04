package com.gameof3.dto;

public class RequestDto {

    private long gameId;

    private long playerId;

    private String adjustment;

    private int number;

    public String getAdjustment() {
        return adjustment;
    }

    public long getGameId() {
        return gameId;
    }

    public int getNumber() {
        return number;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setAdjustment(String adjustment) {
        this.adjustment = adjustment;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

}
