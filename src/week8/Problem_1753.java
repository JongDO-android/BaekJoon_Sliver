package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 최단 거리
public class Problem_1753 {
    private static int[] distance;
    private static ArrayList<ArrayList<edge>> graph;
    static class edge implements Comparable<edge>{
        int vertex;
        int weight;
        edge(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
        @Override
        public int compareTo(edge o) {
            return this.weight - o.weight;
        }
    }
    private static void dijkstra(int start){
        PriorityQueue<edge> pq = new PriorityQueue<>(graph.get(start));
        distance[start] = 0;
        while(!pq.isEmpty()){
            edge e = pq.poll();
            if(e.weight > distance[e.vertex]) continue;
            for(edge e2 : graph.get(e.vertex)){
                int nextVertex = e2.vertex;
                int dis = distance[e.vertex] + e2.weight;

                if(dis < distance[nextVertex]){
                    distance[nextVertex] = dis;
                    pq.add(new edge(e2.vertex, dis));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        graph = new ArrayList<>();
        distance = new int[N];
        int start = Integer.parseInt(bf.readLine()) - 1;

        for(int i = 0 ; i < N ; i ++) {
            graph.add(new ArrayList<>());
            distance[i] = Integer.MAX_VALUE;
        }
        for(int i = 0 ; i < M ; i ++){
            s = bf.readLine().split(" ");
            int u = Integer.parseInt(s[0]) - 1;
            int v = Integer.parseInt(s[1]) - 1;
            int w = Integer.parseInt(s[2]);
            graph.get(u).add(new edge(v, w));
            if(u == start) distance[v] = Math.min(distance[v], w);
        }
        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        for(Integer i : distance) {
            if(i == Integer.MAX_VALUE) sb.append("INF");
            else sb.append(i);
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
