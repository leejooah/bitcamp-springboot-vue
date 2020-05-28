package com.lambda.web.soccer;

public class PlayerBuilder {
    private String playerId;
    private String playerName;
    private String ePlayerName;
    private String nickname;
    private String joinYyyy;
    private String position;
    private String backNo;
    private String nation;
    private String birthDate;
    private String solar;
    private String height;
    private String weight;
    private Long playerNo;
    private Team team;

    public PlayerBuilder setPlayerId(String playerId) {
        this.playerId = playerId;
        return this;
    }

    public PlayerBuilder setPlayerName(String playerName) {
        this.playerName = playerName;
        return this;
    }

    public PlayerBuilder setePlayerName(String ePlayerName) {
        this.ePlayerName = ePlayerName;
        return this;
    }

    public PlayerBuilder setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public PlayerBuilder setJoinYyyy(String joinYyyy) {
        this.joinYyyy = joinYyyy;
        return this;
    }

    public PlayerBuilder setPosition(String position) {
        this.position = position;
        return this;
    }

    public PlayerBuilder setBackNo(String backNo) {
        this.backNo = backNo;
        return this;
    }

    public PlayerBuilder setNation(String nation) {
        this.nation = nation;
        return this;
    }

    public PlayerBuilder setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public PlayerBuilder setSolar(String solar) {
        this.solar = solar;
        return this;
    }

    public PlayerBuilder setHeight(String height) {
        this.height = height;
        return this;
    }

    public PlayerBuilder setWeight(String weight) {
        this.weight = weight;
        return this;
    }

    public PlayerBuilder setPlayerNo(Long playerNo) {
        this.playerNo = playerNo;
        return this;
    }

    public PlayerBuilder setTeam(Team team) {
        this.team = team;
        return this;
    }

    public Player createPlayer() {
        return new Player(playerId, playerName, ePlayerName, nickname, joinYyyy, position, backNo, nation, birthDate, solar, height, weight);
    }
}