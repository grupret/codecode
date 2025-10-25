package com.codecode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreathFirstSearch {


    public static void Bfs(ArrayList<ArrayList<Integer>> adj, int V, int s, boolean[] vistited) {


        Queue<Integer> q = new LinkedList<Integer>();
        vistited[s] = true;
        q.add(s);
        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.println(u + "");
            for (int v : adj.get(u)) {
                if (!vistited[v]) {
                    vistited[v] = true;
                    q.add(v);
                }
            }
        }

    }

    public static void BFSDIr(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean visited[] = new boolean[V + 1];
        int connectedComponent = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                connectedComponent++;
                Bfs(adj, V, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        //create a graph
        //use Queue
        //remove cycles
        //O(V+E)

        int v = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);


        //call the function
        BFSDIr(adj, v);
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

}
