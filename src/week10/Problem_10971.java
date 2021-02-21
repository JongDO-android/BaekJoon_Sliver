package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_10971 {
    private static int N, MIN;
    private static int[][] map;
    private static boolean[] visit;
    private static void dfs(int cur, int cost, int count){
        if(MIN < cost) return;
        if(count == N){
            if(map[cur][0] > 0) MIN = Math.min(MIN, cost + map[cur][0]);
            return;
        }
        for(int i = 0 ; i < N; i ++){
            if(!visit[i] && map[cur][i] > 0){
                visit[i] = true;
                dfs(i, cost + map[cur][i], count + 1);
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        MIN = Integer.MAX_VALUE;
        map = new int[N][N];
        visit = new boolean[N];
        visit[0] = true;
        for(int i = 0 ; i < N ; i ++){
            String[] input = bf.readLine().split(" ");
            for(int j = 0 ; j < N ; j ++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        dfs(0,0, 1);
        System.out.println(MIN);
    }
}
