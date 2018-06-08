package Grafos;

import EstructurasLineales.NodeInt;
import EstructurasLineales.Queue;

public class MatrixGraph {
    public int V;
    private int[][] adj;

    MatrixGraph(int v) {
        V = v;
        adj = new int[V][V];
    }

    public void addEdge(int v, int w, int cost) {
        adj[v][w] = cost;
    }

    public int[] BFS(int s) {
        boolean visited[] = new boolean[V];

        Queue queue = new Queue();
        int[] bfs = new int[V];
        int count = 0;

        visited[s] = true;
        queue.enqueue(new NodeInt(s));

        while (queue.length() != 0) {
            s = ((NodeInt) queue.dequeue()).value;
            bfs[count] = s;
            count++;

            for (int i = 0; i < adj.length; i++) {
                if (adj[s][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    queue.enqueue(new NodeInt(i));
                }
            }
        }

        return bfs;
    }

    private int[] DFSUtil(int v, boolean visited[], int[] dfs, int count) {
        visited[v] = true;
        dfs[count] = v;
        count++;

        for (int i = 0; i < adj.length; i++)
            if (adj[v][i] != 0 && !visited[i])
                return DFSUtil(i, visited, dfs,count);
        
        return null;
    }

    public int[] DFS(int v) {
        boolean visited[] = new boolean[V];
        int[] dfs = new int[V];
        return DFSUtil(v, visited, dfs, 0);
    }
    
}
