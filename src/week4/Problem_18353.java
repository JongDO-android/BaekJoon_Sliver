package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_18353 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String[] s = bf.readLine().split(" ");
        int[] n = new int[N];
        int[] dp = new int[N];
        dp[0] = 1;
        for(int i = 0 ; i < N ; i ++) n[i] = Integer.parseInt(s[i]);
        for(int i = 1 ; i < N ; i ++){
            if(n[i - 1] < n[i]) dp[i] = dp[i - 1] + 1;
            else dp[i] = dp[i - 1] + 1;
        }
        // 3 2 1 4 3 2 1
        System.out.println(dp[N - 1]);
    }
}
