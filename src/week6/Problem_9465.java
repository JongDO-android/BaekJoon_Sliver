package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 실버 2 스티커
public class Problem_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for(int i = 0 ; i < T ; i ++){
            int N = Integer.parseInt(bf.readLine());
            int[][] map = new int[2][N];
            int[][] dp = new int[2][N + 1];
            String[] s1 = bf.readLine().split(" ");
            String[] s2 = bf.readLine().split(" ");
            for(int j = 0 ; j < N ; j ++) {
                map[0][j] = Integer.parseInt(s1[j]);
                map[1][j] = Integer.parseInt(s2[j]);
            }

            for(int col = 1 ; col < N + 1 ; col ++){
                dp[0][col] = Math.max(map[0][col - 1] + dp[1][col - 1], dp[0][col - 1]);
                dp[1][col] = Math.max(map[1][col - 1] + dp[0][col - 1], dp[1][col - 1]);
            }
            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }
    }
}
