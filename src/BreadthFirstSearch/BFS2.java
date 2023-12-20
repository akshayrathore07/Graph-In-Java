// if graph are disconnected graph

package BreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS2 {
    static class Edge{
        int src;
        int dest;

        public Edge(int s , int d){
            this.src = s;
            this.dest = d;
        }
    }
    public static void createGraph(ArrayList<BFS.Edge> graph[]){
        for (int i=0; i<graph.length; i++){
            graph[i]= new ArrayList<>();
        }

        graph[0].add(new BFS.Edge(0,1));
        graph[0].add(new BFS.Edge(0,2));

        graph[1].add(new BFS.Edge(1,0));
        graph[1].add(new BFS.Edge(1,3));

        graph[2].add(new BFS.Edge(2,0));
        graph[2].add(new BFS.Edge(2,4));

        graph[3].add(new BFS.Edge(3,1));
        graph[3].add(new BFS.Edge(3,4));
        graph[3].add(new BFS.Edge(3,5));

        graph[4].add(new BFS.Edge(4,2));
        graph[4].add(new BFS.Edge(4,3));
        graph[4].add(new BFS.Edge(4,5));

        graph[5].add(new BFS.Edge(5,3));
        graph[5].add(new BFS.Edge(5,4));
        graph[5].add(new BFS.Edge(5,6));

        graph[6].add(new BFS.Edge(6,5));
    }
    public static void bfs(ArrayList<BFS.Edge> graph[] , int v,boolean vis[],int start ){
        Queue<Integer> q = new LinkedList<>();


        q.add(start);

        while (!q.isEmpty()){
            int curr = q.remove();

            if (vis[curr] == false){
                System.out.print(curr +" ");
                vis[curr] = true;
                for (int i=0; i<graph[curr].size(); i++){
                    BFS.Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void main(String[] args) {
        int v = 7;
        ArrayList<BFS.Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        boolean vis[] = new boolean[v];
        for (int i=0; i<v; i++){
            if (vis[i] == false){
                bfs(graph,v,vis,i);
            }
        }
        System.out.println();
    }
}
