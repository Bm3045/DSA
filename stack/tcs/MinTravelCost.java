import java.util.*;

public class MinTravelCost {
    static class Flight {
        String to;
        int cost;
        int takeOffTime;
        int landingTime;

        public Flight(String to, int cost, int takeOffTime, int landingTime) {
            this.to = to;
            this.cost = cost;
            this.takeOffTime = takeOffTime;
            this.landingTime = landingTime;
        }
    }

    // Convert time to minutes for easier comparison
    private static int convertToMinutes(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3, 5));
        if (time.endsWith("Pm") && hour != 12) hour += 12;
        if (time.endsWith("Am") && hour == 12) hour = 0;
        return hour * 60 + minute;
    }

    public static int findMinCost(
            Map<String, List<Flight>> graph, String start, String end, int startTime, int endTime) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        Map<String, Integer> minCost = new HashMap<>();

        pq.add(new int[]{0, startTime, start.hashCode()});
        minCost.put(start, 0);

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentCost = current[0];
            int currentTime = current[1];
            String currentCity = new String(new char[]{(char) current[2]});

            if (currentCity.equals(end)) return currentCost;

            if (!graph.containsKey(currentCity)) continue;

            for (Flight flight : graph.get(currentCity)) {
                if (flight.takeOffTime < currentTime || flight.landingTime > endTime) continue;

                int newCost = currentCost + flight.cost;
                if (newCost < minCost.getOrDefault(flight.to, Integer.MAX_VALUE)) {
                    minCost.put(flight.to, newCost);
                    pq.add(new int[]{newCost, flight.landingTime, flight.to.hashCode()});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Map<String, List<Flight>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            String from = input[0];
            String to = input[1];
            int takeOff = convertToMinutes(input[2]);
            int landing = convertToMinutes(input[3]);
            int cost = Integer.parseInt(input[4]);

            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(new Flight(to, cost, takeOff, landing));
        }

        String[] query = sc.nextLine().split(" ");
        String start = query[0];
        String end = query[1];
        int startTime = convertToMinutes(query[2]);
        int endTime = convertToMinutes(query[3]);

        int result = findMinCost(graph, start, end, startTime, endTime);
        System.out.println(result == -1 ? "Impossible" : result);
    }
}
