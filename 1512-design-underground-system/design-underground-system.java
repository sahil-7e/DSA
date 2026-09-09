import java.util.*;

class UndergroundSystem {
    private static class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    private static class Route {
        long totalTime;
        int trips;
    }

    private final Map<Integer, CheckIn> active;
    private final Map<String, Route> routes;

    public UndergroundSystem() {
        active = new HashMap<>();
        routes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        active.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = active.remove(id);

        String key = checkIn.station + "#" + stationName;

        Route route = routes.computeIfAbsent(key, k -> new Route());

        route.totalTime += t - checkIn.time;
        route.trips++;
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "#" + endStation;
        Route route = routes.get(key);

        return (double) route.totalTime / route.trips;
    }
}