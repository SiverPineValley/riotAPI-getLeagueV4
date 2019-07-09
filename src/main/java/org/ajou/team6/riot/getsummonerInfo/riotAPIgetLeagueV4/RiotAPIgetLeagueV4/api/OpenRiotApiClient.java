package org.ajou.team6.riot.getsummonerInfo.riotAPIgetLeagueV4.RiotAPIgetLeagueV4.api;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.ajou.team6.riot.getsummonerInfo.riotAPIgetLeagueV4.RiotAPIgetLeagueV4.domain.League;
import org.ajou.team6.riot.getsummonerInfo.riotAPIgetLeagueV4.RiotAPIgetLeagueV4.domain.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
@Slf4j
public class OpenRiotApiClient {
    private String key = null;
    private String openEncryptedIdUrl = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
    private String openLeagueUrl = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/";
    private String requestParam = "?api_key={key}";

    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    @PostConstruct
    public void loadOpenRiotApiKey() throws IOException {
        key = new String ( Files.readAllBytes( Paths.get("key") ) );
    }

    public String getOpenRiotApiKey() {
        return key;
    }

    public Summoner requestEncryptedSummonerIdByName(String userName) throws IOException {
        if(key == null) loadOpenRiotApiKey();
        String RealUrl = openEncryptedIdUrl + userName + requestParam;
//        log.info(RealUrl + " " + getOpenRiotApiKey());
        return restTemplate.exchange(RealUrl,HttpMethod.GET, null, Summoner.class, getOpenRiotApiKey()).getBody();
    }

    public List<League> requestLeagueByEncryptedId(String id) {
        String RealUrl = openLeagueUrl + id + requestParam;
        return restTemplate.exchange(RealUrl,HttpMethod.GET, null, new ParameterizedTypeReference<List<League>>() {}, getOpenRiotApiKey()).getBody();
    }
}
