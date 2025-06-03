import java.util.*;

public class BusCount {
    
    // Dijkstra's algorithm to find the shortest path from the start node
    public static int[] dijkstra(int[][] graph, int start) {
        int n = graph.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, start});
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentDist = current[0];
            int u = current[1];
            
            if (currentDist > dist[u]) {
                continue;
            }
            
            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0) {
                    int newDist = currentDist + graph[u][v];
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        pq.offer(new int[]{newDist, v});
                    }
                }
            }
        }
        
        return dist;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Reading the number of locations
        int M = sc.nextInt();
        
        // Reading the distance matrix
        int[][] graph = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        
        // Reading the number of employees at each location (excluding the office)
        int[] employees = new int[M - 1];
        for (int i = 0; i < M - 1; i++) {
            employees[i] = sc.nextInt();
        }
        
        // Reading the bus capacity
        int busCapacity = sc.nextInt();
        
        // Step 1: Find the shortest path from the office (location 0) to all other locations
        int[] shortestPaths = dijkstra(graph, 0);
        
        // Step 2: Calculate the number of buses needed
        int totalBuses = 0;
        for (int i = 0; i < M - 1; i++) {
            // The number of buses needed for location i+1 (since employees[i] corresponds to location i+1)
            int busesNeeded = (int) Math.ceil((double) employees[i] / busCapacity);
            totalBuses += busesNeeded;
        }
        
        // Step 3: Output the result
        System.out.println(totalBuses);
        
        sc.close();
    }
}

