package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem_1939 {
    private static int des, mid;
    private static ArrayList<ArrayList<Edge>> road;
    private static boolean[] visit;

    private static class Edge{
        int next;
        int cost;
        Edge(int next, int cost){
            this.next = next;
            this.cost = cost;
        }
    }
    public static boolean dfs(int cur){
        if(cur == des) return true;
        if(visit[cur]) return false;
        visit[cur] = true;

        for(Edge e : road.get(cur)){
            if(e.cost >= mid) {
                if(dfs(e.next)) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bf.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        road = new ArrayList<>();
        for(int i = 0 ; i < N ; i ++) road.add(new ArrayList<>());

        int min = 1000000000;
        int max = 1;

        for(int i = 0 ; i < M ; i ++){
            input = bf.readLine().split(" ");
            int A = Integer.parseInt(input[0]) - 1;
            int B = Integer.parseInt(input[1]) - 1;
            int W = Integer.parseInt(input[2]);

            max = Math.max(max, W);
            min = Math.min(min, W);

            road.get(A).add(new Edge(B, W));
            road.get(B).add(new Edge(A, W));
        }

        input = bf.readLine().split(" ");
        int val = 0;
        int start = Integer.parseInt(input[0]) - 1;
        des = Integer.parseInt(input[1]) - 1;

        while(min <= max){
            mid = (min + max) / 2;
            visit = new boolean[N];

            if(!dfs(start)) max = mid - 1;
            else {
                val = mid;
                min = mid + 1;
            }
        }
        System.out.println(val);
    }
}
