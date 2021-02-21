package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 동전 1
public class Problem_2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        int[] money = new int[N];
        int[][] dp = new int[N + 1][K + 1];
        for(int i = 0 ; i < N ; i ++) money[i] = Integer.parseInt(bf.readLine());
        for(int i = 1 ; i < N + 1 ; i ++) dp[i][0] = 1;

        for(int row = 1 ; row < N + 1 ; row ++){
            for(int col = 1 ; col < K + 1; col ++){
                if(col >= money[row - 1]) dp[row][col] = dp[row][col - money[row - 1]] + dp[row - 1][col];
                else dp[row][col] = dp[row - 1][col];
            }
        }
        System.out.println(dp[N][K]);
    }
}
