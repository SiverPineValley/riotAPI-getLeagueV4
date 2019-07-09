package org.ajou.team6.riot.getsummonerInfo.riotAPIgetLeagueV4.RiotAPIgetLeagueV4.controller;

import org.ajou.team6.riot.getsummonerInfo.riotAPIgetLeagueV4.RiotAPIgetLeagueV4.domain.StoredLeague;
import org.ajou.team6.riot.getsummonerInfo.riotAPIgetLeagueV4.RiotAPIgetLeagueV4.service.RiotAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class RiotAPIController {
    @Autowired
    RiotAPIService riotAPIService;

    @GetMapping("/getLeagueInfo/by-name/{userName}")
    public StoredLeague getLeaguesByName(@PathVariable String userName) throws IOException {
        return riotAPIService.getLeagueByName(userName);
    }
}
