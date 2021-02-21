package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_10971 {
    private static int start, N, min;
    private static int[][] w;
    private static boolean[] visit;
    private static void dfs(int cur, int cost, int count){
        if(cost > min) return;
        if(count == N){
            if(w[cur][start] > 0) min = Math.min(min, cost + w[cur][start]);
            return;
        }

        for(int i = 0 ; i < N ; i ++){
            if(!visit[i] && w[cur][i] > 0){
                visit[i] = true;
                dfs(i, cost + w[cur][i], count + 1);
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        min = Integer.MAX_VALUE;
        w = new int[N][N];

        for(int i = 0 ; i < N ; i ++){
            String[] input = bf.readLine().split(" ");
            for(int j = 0 ; j < N ; j ++){
                w[i][j] = Integer.parseInt(input[j]);
            }
        }
        start = 0;
        visit = new boolean[N];
        dfs(start, 0, 1);
        System.out.println(min);
    }
}
