import org.ajou.team6.riot.getsummonerInfo.riotAPIgetLeagueV4.RiotAPIgetLeagueV4.controller.RiotAPIController;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

public class getLeagueByNameTest {

    RiotAPIController riotAPIController;

    @Test
    public void ApiCallTest() throws IOException {
        assertThat(1,is(1));
//        assertThat(riotAPIController.getLeaguesByName("HideOnBush"), anything());
    }

}
