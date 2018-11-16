package com.gameof3.dto;

public class RequestDto {

    private long gameId;

    private long playerId;

    private String adjustment;

    public String getAdjustment() {
        return adjustment;
    }

    public long getGameId() {
        return gameId;
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

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

}
