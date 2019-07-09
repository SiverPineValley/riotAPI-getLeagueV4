package org.ajou.team6.riot.getsummonerInfo.riotAPIgetLeagueV4.RiotAPIgetLeagueV4.domain;

import lombok.Data;

import java.util.List;

@Data
public class StoredLeague {
    private String summonerId;
    private List<League> league;
}
