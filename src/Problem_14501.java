import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] T = new int[N];
        int[] P = new int[N];
        int[] dp = new int[N + 1];
        for(int i = 0 ; i < N ; i ++) {
            String[] s = bf.readLine().split(" ");
            T[i] = Integer.parseInt(s[0]);
            P[i] = Integer.parseInt(s[1]);
        }
        for(int i = N - 1 ; i >= 0 ; i --){
            if(i + T[i] <= N) dp[i] = Math.max(dp[i + 1], P[i] + dp[i + T[i]]);
            else dp[i] = dp[i + 1];
        }
        System.out.println(dp[0]);
    }
}
