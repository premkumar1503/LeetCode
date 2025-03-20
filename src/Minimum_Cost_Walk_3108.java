import java.util.Arrays;
import java.util.Scanner;

class DisjointSet {
    int[] parent, rank, cost;

    // Constructor to initialize DSU
    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        cost = new int[n];

        // Initialize each node as its own parent (self loop)
        for (int i = 0; i < n; i++) parent[i] = i;

        // Initialize cost with max possible value (all bits 1)
        Arrays.fill(cost, (1 << 17) - 1); // 131071 in decimal
    }

    // Find operation with path compression
    public int find(int u) {
        if (parent[u] != u)
            parent[u] = find(parent[u]); // Path compression
        return parent[u];
    }

    // Union operation (combines two sets)
    public void union(int u, int v, int weight) {
        int rootU = find(u), rootV = find(v);
        if (rootU == rootV) {
            cost[rootU] &= weight; // If already in same component, update cost
            return;
        }

        // Union by rank (attach smaller tree under larger tree)
        if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
            cost[rootV] &= (cost[rootU] & weight);
        } else if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
            cost[rootU] &= (cost[rootV] & weight);
        } else {
            parent[rootV] = rootU;
            rank[rootU]++;
            cost[rootU] &= (cost[rootV] & weight);
        }
    }

    // Get minimum cost between two nodes
    public int getMinCost(int u, int v) {
        return find(u) == find(v) ? cost[find(u)] : -1;
    }
}

class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] queries) {
        DisjointSet ds = new DisjointSet(n);

        // Process edges to build the connected components
        for (int[] edge : edges) {
            ds.union(edge[0], edge[1], edge[2]);
        }

        // Process queries
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = ds.getMinCost(queries[i][0], queries[i][1]);
        }

        return result;
    }
}
    // Main method to test with sample input
public class Minimum_Cost_Walk_3108
{
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);

        // Input: number of nodes and edges
        System.out.print("Enter number of nodes (n): ");
        int n = scanner.nextInt();

        System.out.print("Enter number of edges: ");
        int e = scanner.nextInt();
        int[][] edges = new int[e][3];

        System.out.println("Enter edges (format: u v weight):");
        for (int i = 0; i < e; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
            edges[i][2] = scanner.nextInt();
        }
    }
}



