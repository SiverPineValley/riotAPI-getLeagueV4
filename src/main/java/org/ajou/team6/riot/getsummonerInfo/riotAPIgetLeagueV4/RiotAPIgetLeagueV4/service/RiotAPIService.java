package org.ajou.team6.riot.getsummonerInfo.riotAPIgetLeagueV4.RiotAPIgetLeagueV4.service;

import lombok.extern.slf4j.Slf4j;
import org.ajou.team6.riot.getsummonerInfo.riotAPIgetLeagueV4.RiotAPIgetLeagueV4.api.OpenRiotApiClient;
import org.ajou.team6.riot.getsummonerInfo.riotAPIgetLeagueV4.RiotAPIgetLeagueV4.domain.League;
import org.ajou.team6.riot.getsummonerInfo.riotAPIgetLeagueV4.RiotAPIgetLeagueV4.domain.StoredLeague;
import org.ajou.team6.riot.getsummonerInfo.riotAPIgetLeagueV4.RiotAPIgetLeagueV4.domain.Summoner;
import org.ajou.team6.riot.getsummonerInfo.riotAPIgetLeagueV4.RiotAPIgetLeagueV4.repository.RiotAPIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class RiotAPIService {

    @Autowired
    OpenRiotApiClient riotApiClient;
    @Autowired
    RiotAPIRepository riotAPIRepository;

    public StoredLeague getLeagueByName(String userName) throws IOException {
        String summonerId = riotApiClient.requestEncryptedSummonerIdByName(userName).getId();
        List<League> leagues = riotApiClient.requestLeagueByEncryptedId( summonerId );
        StoredLeague storedLeague = new StoredLeague();
        storedLeague.setSummonerId(summonerId);
        storedLeague.setLeague(leagues);

        if(riotAPIRepository.findStoredLeague(summonerId) == null) riotAPIRepository.insertStoredLeague(storedLeague);
        else riotAPIRepository.updateStoredLeague(summonerId, leagues);
        return riotAPIRepository.findStoredLeague(summonerId);
    }
}
