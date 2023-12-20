package DijkstrasAlgorithm;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ClassRoom {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s , int d,int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i=0; i< graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,3,7));
        graph[1].add(new Edge(1,2,1));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
    }

    public static class Pair implements Comparable<Pair> {
        int node;
        int dist;

        public Pair(int n , int d){
            this.node = n;
            this.dist=d;
        }
        @Override
        public int compareTo(Pair p2){
            return this.dist-p2.dist;
        }
    }

    public static void dijkstra(ArrayList<Edge> graph[] , int src , int v){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dis[] = new int[v];

        for (int i=0; i<v; i++){
            if (i != src){
                dis[i]= Integer.MAX_VALUE;

            }
        }
        boolean vis[] = new boolean[v];
        pq.add(new Pair(0,0));

        // bfs
        while (!pq.isEmpty()){
            Pair curr = pq.remove(); // shortest
            if (!vis[curr.node]){
                vis[curr.node]=true;

                for (int i=0; i<graph[curr.node].size(); i++){
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int V = e.dest;

                    if (dis[u]+e.wt<dis[V]){ // relaxation
                        dis[V]=dis[u]+e.wt;
                        pq.add(new Pair(V , dis[V]));
                    }
                }
            }
        }
        for (int i=0; i<v; i++){
            System.out.print(dis[i]+" ");
        }
    }
    public static void main(String[] args) {
        int v = 6;

        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        dijkstra(graph,0,v);
    }
}
