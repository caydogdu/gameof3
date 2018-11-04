package com.gameof3.dto;

public class MessageDto {

    private long playerId;

    private String playerName;

    private String content;

    public MessageDto() {
    }

    public MessageDto(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public long getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

}
