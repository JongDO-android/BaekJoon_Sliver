package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int mod = 1000000000;

        int[][] dp = new int[N + 1][K + 1];

        for(int i = 1 ; i < K + 1 ; i ++) dp[0][i] = 1;

        for(int row = 1 ; row < N + 1 ; row ++){
            for(int col = 1 ; col < K + 1 ; col ++){
                dp[row][col] = (dp[row - 1][col] + dp[row][col - 1]) % mod;
            }
        }

        System.out.println(dp[N][K]);
    }
}
