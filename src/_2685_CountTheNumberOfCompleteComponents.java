import java.util.*;

class CompleteComponentsCounter {
    public int countCompleteComponents(int n, int[][] edges) {

        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int completeCount = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, graph, visited, component);

                // Step 3: Check if the component is complete
                if (isComplete(component, graph)) {
                    completeCount++;
                }
            }

        }

        return completeCount;
    }


    private void dfs(int node, List<Set<Integer>> graph, boolean[] visited, List<Integer> component) {
        visited[node] = true;
        component.add(node);
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited, component);
            }
        }
    }

    // Check if the component is a complete graph
    private boolean isComplete(List<Integer> component, List<Set<Integer>> graph) {
        int size = component.size();
        for (int node : component) {
            if (graph.get(node).size() != size - 1) {
                return false;
            }
        }
        return true;
    }
}
public class _2685_CountTheNumberOfCompleteComponents
{
    public static void main(String[] args)
    {
        CompleteComponentsCounter obj = new CompleteComponentsCounter();
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {3, 4}};
        System.out.println(obj.countCompleteComponents(n, edges));
    }
}
