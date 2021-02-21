package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

//파티
public class Problem_1238 {
    private static int N;
    private static int[] dist;
    private static ArrayList<ArrayList<Edge>> edges;
    private static class Edge implements Comparable<Edge>{
        int next;
        int time;
        private Edge(int next, int time){
            this.next = next;
            this.time = time;
        }

        @Override
        public int compareTo(Edge o) {
            return this.time - o.time;
        }
    }
    private static void dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>(edges.get(start));

        Arrays.fill(dist, 1000 * N);
        for(Edge e0 : edges.get(start)) dist[e0.next] = e0.time;
        dist[start] = 0;
        while(!pq.isEmpty()){
            Edge e = pq.poll();

            for(Edge n_edge : edges.get(e.next)){
                if(dist[n_edge.next] > dist[e.next] + n_edge.time){
                    dist[n_edge.next] = dist[e.next] + n_edge.time;
                    pq.add(new Edge(n_edge.next, e.time + n_edge.time));
                }
            }
        }
    }
    // 다익스트라
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int X = Integer.parseInt(input[2]) - 1;
        dist = new int[N];
        edges = new ArrayList<>();

        for(int i = 0 ; i < N ; i ++) edges.add(new ArrayList<>());
        for(int i = 0 ; i < M ; i ++){
            input = bf.readLine().split(" ");
            int n1 = Integer.parseInt(input[0]) - 1;
            int n2 = Integer.parseInt(input[1]) - 1;
            int w = Integer.parseInt(input[2]);

            edges.get(n1).add(new Edge(n2, w));
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        dijkstra(X);
        for(int i = 0 ; i < N ; i ++) map.put(i, dist[i]);
        for(int i = 0 ; i < N ; i ++) {
            if(i != X) {
                dijkstra(i);
                max = Math.max(map.get(i) + dist[X], max);
            }
        }
        System.out.println(max);
    }
    // 플로이드 와샬
    /*public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int X = Integer.parseInt(input[2]) - 1;
        int[][] route = new int[N][N];

        for(int i = 0 ; i < N ; i ++) {
            Arrays.fill(route[i], 1000 * N);
            route[i][i] = 0;
        }
        for(int i = 0 ; i < M ; i ++){
            input = bf.readLine().split(" ");
            int n1 = Integer.parseInt(input[0]) - 1;
            int n2 = Integer.parseInt(input[1]) - 1;
            route[n1][n2] = Integer.parseInt(input[2]);
        }
        for(int n2 = 0 ; n2 < N ; n2 ++){
            for(int n1 = 0 ; n1 < N ; n1 ++){
                for(int n3 = 0 ; n3 < N ; n3 ++){
                    route[n1][n3] = Math.min(route[n1][n3], route[n1][n2] + route[n2][n3]);
                }
            }
        }
        int max = 0;
        for(int i = 0 ; i < N ; i ++){
            max = Math.max(max, route[i][X] + route[X][i]);
        }
        System.out.println(max);
    }*/
}
