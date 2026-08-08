

import java.util.*;

public class problem1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long k = sc.nextLong();

        long[] key = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            key[i] = sc.nextLong();
        }

        ArrayList<Integer>[] tree = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        // Build the tree
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            tree[u].add(v);
            tree[v].add(u);
        }

        // Stack stores: node, parent, path XOR
        Stack<long[]> stack = new Stack<>();

        // Start from root (Server 1)
        stack.push(new long[]{1, 0, key[1]});

        int trustedServers = 0;

        while (!stack.isEmpty()) {

            long[] current = stack.pop();

            int node = (int) current[0];
            int parent = (int) current[1];
            long pathXor = current[2];

            // Check whether current server is trusted
            if (pathXor >= k) {
                trustedServers++;
            }

            // Visit children
            for (int child : tree[node]) {

                if (child != parent) {

                    long childXor = pathXor ^ key[child];

                    stack.push(new long[]{
                            child,
                            node,
                            childXor
                    });
                }
            }
        }

        System.out.println(trustedServers);

        sc.close();
    }
}