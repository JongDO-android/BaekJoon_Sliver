package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_18353 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] soldiers = new int[N];
        int[] dp = new int[N];
        String[] s = bf.readLine().split(" ");
        for(int i = 0 ; i < N ; i ++) soldiers[i] = Integer.parseInt(s[i]);
        for(int i = 1 ; i < N ; i ++){
            for(int j = 0 ; j <= i; j ++){
                if(soldiers[i] < soldiers[j]) dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
        }
        Arrays.sort(dp);
        System.out.println(N - dp[N - 1] - 1);
    }
}
