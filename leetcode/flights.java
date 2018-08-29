class Solution {

    class Flight {
        int src;
        int dst;
        int cost;
        int stops;

        Flight(int src, int dst, int cost, int stops) {
            this.src = src;
            this.dst = dst;
            this.cost = cost;
            this.stops = stops;
        }

        @Override
        public String toString() {
            return "{src: " + this.src + ", dst: " + this.dst + ", cost: " + this.cost + ", stops: " + this.stops + "}";
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (src == dst) return 0;
        if (flights.length == 0) return -1;
        // initialize starting flights
        LinkedList<Flight> queue = new LinkedList<>();
        Map<Integer, List<Flight>> remFlights = new HashMap<>();
        Map<Integer, Integer> minMap = new HashMap<>();
        minMap.put(src, 0);
        for (int i = 0; i < flights.length; i++) {
            if (src == flights[i][0]) {
                queue.add(new Flight(flights[i][0], flights[i][1], flights[i][2], 0));
            }
            if (!remFlights.containsKey(flights[i][0])) remFlights.put(flights[i][0], new ArrayList<>());
            remFlights.get(flights[i][0]).add(new Flight(flights[i][0], flights[i][1], flights[i][2], 0));
        }
        Integer cheapestPrice = null;
        while (!queue.isEmpty()) {
            Flight currFlight = queue.pop();
            if (currFlight.stops > K) continue;
            if (currFlight.dst == dst && currFlight.stops <= K) {
                if (cheapestPrice == null) cheapestPrice = currFlight.cost;
                else cheapestPrice = Math.min(cheapestPrice, currFlight.cost);
            }
            minMap.put(currFlight.dst, Math.min(minMap.getOrDefault(currFlight.dst, currFlight.cost), currFlight.cost));
            if (!remFlights.containsKey(currFlight.dst)) continue;
            List<Flight> nxtFlights = remFlights.get(currFlight.dst);
            for (int i = 0; i < nxtFlights.size(); i++) {
                Flight nxtFlight = nxtFlights.get(i);
                if (nxtFlight.src == currFlight.dst && currFlight.stops + 1 <= K && currFlight.cost + nxtFlight.cost < minMap.getOrDefault(nxtFlight.dst, currFlight.cost + nxtFlight.cost + 1)) {
                    queue.add(new Flight(nxtFlight.src, nxtFlight.dst, currFlight.cost + nxtFlight.cost, currFlight.stops + 1));
                }
            }
        }
        return cheapestPrice == null ? -1 : cheapestPrice;
    }
}