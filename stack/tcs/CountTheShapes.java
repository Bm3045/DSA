import java.util.*;

public class CountTheShapes {

    // Helper function to perform DFS and detect cycles
    static boolean dfs(int node, Map<Integer, List<Integer>> graph, boolean[] visited, int parent) {
        visited[node] = true;

        // Explore all neighbors of the current node
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, graph, visited, node)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true; // A cycle is detected
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of line segments
        int N = sc.nextInt();

        // Adjacency list to represent the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Reading the line segments and constructing the graph
        for (int i = 0; i < N; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            // Convert (x, y) coordinates into a single integer identifier for each point
            int point1 = x1 * 100 + y1;
            int point2 = x2 * 100 + y2;

            // Add the line segment to the graph
            graph.putIfAbsent(point1, new ArrayList<>());
            graph.putIfAbsent(point2, new ArrayList<>());
            graph.get(point1).add(point2);
            graph.get(point2).add(point1);
        }

        // To keep track of visited nodes
        boolean[] visited = new boolean[10001];  // Max possible point is (100, 100)

        // Counting the number of closed figures (cycles)
        int closedFigures = 0;

        // Iterate over all nodes and perform DFS to detect cycles
        for (int node : graph.keySet()) {
            if (!visited[node]) {
                // Perform DFS to detect if the component forms a closed figure
                if (dfs(node, graph, visited, -1)) {
                    closedFigures++;
                }
            }
        }

        // Output the result
        System.out.println(closedFigures);
        sc.close();
    }
}

