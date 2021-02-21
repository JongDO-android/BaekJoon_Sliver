import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1003 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        int[] dp = new int[41];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3 ; i < 41 ; i ++) dp[i] = dp[i - 1] + dp[i - 2];
        for(int i = 0 ; i < T ; i ++){
            int n = Integer.parseInt(bf.readLine());
            if(n == 0) System.out.println(1 + " " + 0);
            else if(n == 1) System.out.println(0 + " " + 1);
            else System.out.println(dp[n - 1] + " " + dp[n]);
        }
    }
}
