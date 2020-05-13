package wooteco.subway.admin.dto;

import java.util.List;

import wooteco.subway.admin.domain.Station;

public class RouteResponse {
    List<Station> stations;
    int distance;
    int duration;

    public RouteResponse() {
    }

    public RouteResponse(final List<Station> stations, final int distance, final int duration) {
        this.stations = stations;
        this.distance = distance;
        this.duration = duration;
    }

    public List<Station> getStations() {
        return stations;
    }

    public int getDistance() {
        return distance;
    }

    public int getDuration() {
        return duration;
    }
}
