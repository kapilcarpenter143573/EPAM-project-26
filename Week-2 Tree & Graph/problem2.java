import java.util.*;

public class problem2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();

        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build undirected graph
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u].add(v);
            graph[v].add(u);
        }

        // Distance from City 1
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new LinkedList<>();

        // Start BFS from City 1
        distance[1] = 0;
        queue.add(1);

        int count = 0;

        while (!queue.isEmpty()) {

            int current = queue.poll();

            // Count city if shortest distance <= D
            if (distance[current] <= d) {
                count++;
            }

            for (int neighbor : graph[current]) {

                // Visit only unvisited cities
                if (distance[neighbor] == -1) {

                    distance[neighbor] = distance[current] + 1;
                    queue.add(neighbor);
                }
            }
        }

        System.out.println(count);

        sc.close();
    }
}