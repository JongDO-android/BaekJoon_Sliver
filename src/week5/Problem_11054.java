package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 골드 3 가장 긴 바이토닉 부분 수열
public class Problem_11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] ary = new int[N];
        int[][] dp = new int[2][N];
        int max = 0;
        String[] s = bf.readLine().split(" ");
        for(int i = 0 ; i < N ; i ++) ary[i] = Integer.parseInt(s[i]);

        for(int i = 0 ; i < N ; i ++){
            if(dp[0][i] == 0) dp[0][i] = 1;
            for(int j = 0 ; j < i ; j ++){
               if(ary[j] < ary[i]){
                   dp[0][i] = Math.max(dp[0][i], dp[0][j] + 1);
               }
            }
        }
        for(int i = N - 1 ; i >= 0 ; i --){
            if(dp[1][i] == 0) dp[1][i] = 1;
            for(int j = N - 1 ; j > i ; j --){
                if(ary[j] < ary[i]){
                    dp[1][i] = Math.max(dp[1][i], dp[1][j] + 1);
                }
            }
            max = Math.max(dp[0][i] + dp[1][i] - 1, max);
        }
        System.out.println(max);
    }
}
