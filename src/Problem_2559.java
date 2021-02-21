import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2559 수열
public class Problem_2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] tems = bf.readLine().split(" ");
        int T = Integer.parseInt(tems[0]);
        int D = Integer.parseInt(tems[1]);
        int[] tp = new int[T];
        int[] dp = new int[T - D + 1];
        tems = bf.readLine().split(" ");
        for(int i = 0 ; i < T ; i ++) tp[i] = Integer.parseInt(tems[i]);
        for(int i = 0; i < D ; i ++) dp[0] += tp[i];
        int max = dp[0];
        for(int i = 1 ; i < T - D + 1 ; i ++) {
            dp[i] = dp[i - 1] - tp[i - 1] + tp[i + D - 1];
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
