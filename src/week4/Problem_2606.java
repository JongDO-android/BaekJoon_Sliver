package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 바이러스
public class Problem_2606 {
    private static int val;
    private static ArrayList<ArrayList<Integer>> graph;
    private static void dfs(boolean[] visit, int idx){
        if(visit[idx]) {
            val --;
            return;
        }
        visit[idx] = true;
        ArrayList<Integer> gp = graph.get(idx);

        for(Integer i : gp){
            val ++;
            dfs(visit, i);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int E = Integer.parseInt(bf.readLine());
        graph = new ArrayList<>();
        val = 0;
        boolean[] visit = new boolean[N];
        for(int i = 0 ; i < N ; i ++) graph.add(new ArrayList<>());
        for(int i = 0 ; i < E ; i ++){
            String[] s = bf.readLine().split(" ");
            int v1 = Integer.parseInt(s[0]);
            int v2 = Integer.parseInt(s[1]);
            graph.get(v1 - 1).add(v2 - 1);
            graph.get(v2 - 1).add(v1 - 1);
        }
        dfs(visit, 0);
        System.out.println(val);
    }
}
