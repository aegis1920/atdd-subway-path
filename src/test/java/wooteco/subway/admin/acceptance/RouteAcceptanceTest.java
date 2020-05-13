package wooteco.subway.admin.acceptance;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import wooteco.subway.admin.dto.LineResponse;
import wooteco.subway.admin.dto.RouteResponse;
import wooteco.subway.admin.dto.StationResponse;

public class RouteAcceptanceTest extends AcceptanceTest {
    @Test
    void findRoute() {
        StationResponse stationResponse1 = createStation("강남역");
        StationResponse stationResponse2 = createStation("역삼역");
        StationResponse stationResponse3 = createStation("선릉역");
        StationResponse stationResponse4 = createStation("양재역");
        StationResponse stationResponse5 = createStation("양재시민숲역");

        LineResponse lineResponse1 = createLine("신분당선");
        LineResponse lineResponse2 = createLine("2호선");

        addLineStation(lineResponse1.getId(), null, stationResponse1.getId());
        addLineStation(lineResponse1.getId(), stationResponse1.getId(), stationResponse4.getId());
        addLineStation(lineResponse1.getId(), stationResponse4.getId(), stationResponse5.getId());

        addLineStation(lineResponse2.getId(), null, stationResponse1.getId());
        addLineStation(lineResponse2.getId(), stationResponse1.getId(), stationResponse2.getId());
        addLineStation(lineResponse2.getId(), stationResponse2.getId(), stationResponse3.getId());

        RouteResponse routeResponse = findShortestRoute("양재시민의숲역", "선릉역");

        assertThat(routeResponse.getStations().size()).isEqualTo(5);
        assertThat(routeResponse.getDistance()).isEqualTo(40);
        assertThat(routeResponse.getDuration()).isEqualTo(40);
    }


}
