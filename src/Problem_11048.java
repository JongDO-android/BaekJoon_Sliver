import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_11048 {
    private static int N, M;
    private static int[][] dp;
    private static int DP(int[][] maze, int x, int y){
        if(M - 1 < x || N - 1 < y) return 0;
        if(dp[y][x] > -1) return dp[y][x];
        dp[y][x] = maze[y][x] + Math.max(DP(maze, x + 1, y), DP(maze, x, y + 1));
        return dp[y][x];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        dp = new int[N][M];
        for(int i = 0 ; i < N ; i ++) for(int j = 0 ; j < M ; j ++) dp[i][j] = -1;
        int[][] maze = new int[N][M];
        for(int i = 0 ; i < N ; i ++){
            s = bf.readLine().split(" ");
            for(int j = 0 ; j < M ; j ++) maze[i][j] = Integer.parseInt(s[j]);
        }
        System.out.println(DP(maze, 0, 0));
    }
}
