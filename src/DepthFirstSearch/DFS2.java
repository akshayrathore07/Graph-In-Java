// if graph are disconnected graph

package DepthFirstSearch;

import java.util.ArrayList;

public class DFS2 {
    static class Edge{
        int src;
        int dest;

        public Edge(int s , int d){
            this.src = s;
            this.dest = d;
        }
    }
    public static void createGraph(ArrayList<DFS.Edge> graph[]){
        for (int i=0; i<graph.length; i++){
            graph[i]= new ArrayList<>();
        }

        graph[0].add(new DFS.Edge(0,1));
        graph[0].add(new DFS.Edge(0,2));

        graph[1].add(new DFS.Edge(1,0));
        graph[1].add(new DFS.Edge(1,3));

        graph[2].add(new DFS.Edge(2,0));
        graph[2].add(new DFS.Edge(2,4));

        graph[3].add(new DFS.Edge(3,1));
        graph[3].add(new DFS.Edge(3,4));
        graph[3].add(new DFS.Edge(3,5));

        graph[4].add(new DFS.Edge(4,2));
        graph[4].add(new DFS.Edge(4,3));
        graph[4].add(new DFS.Edge(4,5));

        graph[5].add(new DFS.Edge(5,3));
        graph[5].add(new DFS.Edge(5,4));
        graph[5].add(new DFS.Edge(5,6));

        graph[6].add(new DFS.Edge(6,5));
    }
    public static void dfs(ArrayList<DFS.Edge> graph[] , int curr, boolean vis[]){
        System.out.print(curr+" ");
        vis[curr] = true;

        for (int i=0; i<graph[curr].size(); i++){
            DFS.Edge e = graph[curr].get(i);
            if (vis[e.dest] == false) {
                dfs(graph, e.dest, vis);
            }
        }
    }
    public static void main(String[] args) {
        int v = 7;
        ArrayList<DFS.Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        boolean vis[] = new boolean[v];
        for (int i=0; i<v; i++){
            if (vis[i]==false){
                dfs(graph,0,vis);
            }
        }

        System.out.println();
    }
}
