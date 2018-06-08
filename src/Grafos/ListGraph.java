package Grafos;

import EstructurasLineales.List;
import EstructurasLineales.NodeInt;
import EstructurasLineales.Queue;

public class ListGraph {

    public int V;
    private List[] adj;

    ListGraph(int v) {
        V = v;
        adj = new List[V];
        for (int i = 0; i < v; ++i) {
            adj[i] = new List();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].insertAtEnd(new NodeInt(w));
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

            for (int i = 0; i < adj[s].length(); i++) {
                int n = ((NodeInt) adj[s].get(i)).value;
                if (!visited[n]) {
                    visited[n] = true;
                    queue.enqueue(new NodeInt(n));
                }
            }
        }

        return bfs;
    }

    private int[] DFSUtil(int v, boolean visited[], int[] dfs, int count) {
        visited[v] = true;
        dfs[count] = v;
        count++;

        for (int i = 0; i < adj[v].length(); i++) {
            int n = ((NodeInt) adj[v].get(i)).value;
            if (!visited[n])
                return DFSUtil(n, visited, dfs, count);
        }
        
        return null;
    }

    public int[] DFS(int v) {
        boolean visited[] = new boolean[V];
        int[] dfs = new int[V];
        return DFSUtil(v, visited, dfs, 0);
    }

}
