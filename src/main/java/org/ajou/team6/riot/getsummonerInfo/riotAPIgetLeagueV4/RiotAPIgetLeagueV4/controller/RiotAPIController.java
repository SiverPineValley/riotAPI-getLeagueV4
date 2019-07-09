package org.ajou.team6.riot.getsummonerInfo.riotAPIgetLeagueV4.RiotAPIgetLeagueV4.controller;

import org.ajou.team6.riot.getsummonerInfo.riotAPIgetLeagueV4.RiotAPIgetLeagueV4.domain.StoredLeague;
import org.ajou.team6.riot.getsummonerInfo.riotAPIgetLeagueV4.RiotAPIgetLeagueV4.service.RiotAPIService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;

@Controller
public class RiotAPIController {
    @GetMapping("/getLeagueInfo/by-name/{userName}")
    public StoredLeague getLeaguesByName(@PathVariable String userName) throws IOException {
        return RiotAPIService.getLeagueByName(userName);
    }
}
