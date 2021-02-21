package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
public class Problem_13549 {
    private static int N, K;
    private static int[] d1 = {2, 1, -1};
    private static int[] d2 = {2, -1, 1};
    private static class location{
        int n;
        int dis;
        private location(int n, int dis){
            this.n = n;
            this.dis = dis;
        }
    }
    private static int bfs(int[] d){
        Queue<location> q = new LinkedList<>();
        q.offer(new location(N, 0));
        boolean[] visit = new boolean[100001];
        visit[N] = true;
        int dis = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            location loc = q.poll();
            if(loc.n >= K){
                dis = Math.min(dis, loc.n - K + loc.dis);
                continue;
            }
            for(int i = 0 ; i < 3 ; i ++){
                location loc2;
                if(d[i] == 2) loc2 = new location(loc.n * d[i], loc.dis);
                else loc2 = new location(loc.n + d[i], loc.dis + 1);
                if(0 <= loc2.n && loc2.n < 100001){
                    if(!visit[loc2.n]){
                        visit[loc2.n] = true;
                        q.offer(loc2);
                    }
                }
            }
        }
        return dis;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);
        int min = Math.min(bfs(d1), bfs(d2));

        System.out.println(min);
    }
}
