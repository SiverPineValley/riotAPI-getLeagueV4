package org.ajou.team6.riot.getsummonerInfo.riotAPIgetLeagueV4.RiotAPIgetLeagueV4.repository;

import com.mongodb.MongoClient;
import org.ajou.team6.riot.getsummonerInfo.riotAPIgetLeagueV4.RiotAPIgetLeagueV4.domain.League;
import org.ajou.team6.riot.getsummonerInfo.riotAPIgetLeagueV4.RiotAPIgetLeagueV4.domain.StoredLeague;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RiotAPIRepository {
    @Autowired
    MongoTemplate mongoTemplate = new MongoTemplate(new MongoClient(), "Leagues");

    public void insertStoredLeague(StoredLeague storedLeague) {
        mongoTemplate.insert(storedLeague, "storedLeague");
    }

    public StoredLeague findStoredLeague(String summonerId) {
        Query query = Query.query(Criteria.where("summonerId").is(summonerId));
        return mongoTemplate.findOne(query, StoredLeague.class, "storedLeague");
    }

    public StoredLeague updateStoredLeague(String summonerId, List<League> league) {
        Criteria criteria = new Criteria("summonerId");
        criteria.is(summonerId);

        Query query = new Query(criteria);
        //업데이트 할 항목 정의
        Update update = new Update();
        update.set("league", league);

        mongoTemplate.updateFirst(query, update,"storedLeague");
        return mongoTemplate.findOne(query, StoredLeague.class);
    }

}
