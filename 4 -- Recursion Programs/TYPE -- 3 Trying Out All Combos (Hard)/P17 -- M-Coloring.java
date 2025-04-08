import java.util.List;
import java.util.ArrayList;

class M_Coloring {
    public static boolean isColoringPossible(int node, List<Integer>[] G, int N, int M, int[] colorArray) {
        // Base Case
        if(node == N) return true;
        for(int color = 1; color <= M; color++) {
            if(isSafe(node, color, colorArray, G)) {
                colorArray[node] = color;
                
                if(isColoringPossible(node + 1, G, N, M, colorArray) == true) {
                    return true; // No further checking
                }
                else {
                    colorArray[node] = 0;
                }
            }
        }
        return false; // Not possible to color using m colors
    }
    public static boolean isSafe(int node, int color, int[] colorArray, List<Integer>[] G) {
        for(int it : G[node]) {
            if(colorArray[it] == color) return false;
        }
        return true;
    }
    public static void main(String args[]) {
        int N = 4, M = 2; // No.of nodes & colors
        
        // int[] G = new int[N];
        @SuppressWarnings("unchecked") // Tells compiler that it knows what it does
        List<Integer>[] G = new ArrayList[N];
        for(int i = 0; i < G.length; i++) {
            G[i] = new ArrayList<>();
        }
        // Edge b.w 0 & 1
        G[0].add(1);
        G[1].add(0);
        // Edge b.w 0 & 2
        G[0].add(2);
        G[2].add(0);
        // Edge b.w 0 & 3
        G[0].add(3);
        G[3].add(0);
        // Edge b.w 1 & 2
        G[1].add(2);
        G[2].add(1);
        // Edge b.w 1 & 3
        G[1].add(3);
        G[3].add(1);
        
        // System.out.println("Graph:");
        // for(List<Integer> i : G) {
        //     System.out.print(i + " ");
        // }
        
        int[] colorArray = new int[N];
        if(isColoringPossible(0, G, N, M, colorArray)) {
            System.out.println("Coloring using given m colors is possible");
        } else {
            System.out.println("Coloring using given m colors is not possible");
        }
        
    }
}

// GFG Solution -- Slightly a different syntax
/*
class Solution {
    
    boolean isSafe(int node, int color, List<List<Integer>> adj, int[] colorArray) {
        for (int neighbor : adj.get(node)) {
            if (colorArray[neighbor] == color) {
                return false;
            }
        }
        return true;
    }

    boolean isPossible(int node, int v, int m, List<List<Integer>> adj, int[] colorArray) {
        if (node == v) return true; // All nodes colored

        for (int color = 1; color <= m; color++) {
            if (isSafe(node, color, adj, colorArray)) {
                colorArray[node] = color;
                if (isPossible(node + 1, v, m, adj, colorArray)) {
                    return true;
                }
                colorArray[node] = 0; // backtrack
            }
        }
        return false; // No color can be assigned
    }

    boolean graphColoring(int v, List<int[]> edges, int m) {
        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); // Since it's an undirected graph
        }

        int[] colorArray = new int[v];
        return isPossible(0, v, m, adj, colorArray);
    }
} 
*/