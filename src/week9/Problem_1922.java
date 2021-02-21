package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// 네트워크 연결
public class Problem_1922 {
    private static boolean[] selected;
    private static ArrayList<ArrayList<Edge>> graph;
    private static class Edge implements Comparable<Edge>{
        int next;
        int cost;
        private Edge(int next, int cost){
            this.next = next;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    private static int prim(){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int ans = 0;
        while(!q.isEmpty()){
            int n = q.poll();
            selected[n] = true;

            for(Edge e : graph.get(n)){
                if(!selected[e.next]){
                    pq.add(e);
                }
            }
            while(!pq.isEmpty()){
                Edge e = pq.poll();
                if(!selected[e.next]){
                    selected[e.next] = true;
                    q.offer(e.next);
                    ans += e.cost;
                    break;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        selected = new boolean[N];
        graph = new ArrayList<>();
        int M = Integer.parseInt(bf.readLine());

        for(int i = 0 ; i < N ; i ++) graph.add(new ArrayList<>());
        for(int i = 0 ; i < M ; i ++){
            String[] input = bf.readLine().split(" ");
            int n1 = Integer.parseInt(input[0]) - 1;
            int n2 = Integer.parseInt(input[1]) - 1;
            int w = Integer.parseInt(input[2]);

            graph.get(n1).add(new Edge(n2, w));
            graph.get(n2).add(new Edge(n1, w));
        }
        System.out.println(prim());
    }
}
