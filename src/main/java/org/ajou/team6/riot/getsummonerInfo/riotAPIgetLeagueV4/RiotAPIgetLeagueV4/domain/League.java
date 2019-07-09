package org.ajou.team6.riot.getsummonerInfo.riotAPIgetLeagueV4.RiotAPIgetLeagueV4.domain;

import lombok.Data;

@Data
public class League {
    private String queueType;
    private String summonerName;
    private Boolean hotStreak;
    private int wins;
    private Boolean veteran;
    private int losses;
    private String rank;
    private String leagueId;
    private Boolean inactive;
    private Boolean freshBlood;
    private String tier;
    private String summonerId;
    private int leaguePoints;
    private MiniSeriesDTO miniSeries;

    @Data
    public class MiniSeriesDTO {
        private int wins;
        private int losses;
        private int target;
        private String progress;
    }
}