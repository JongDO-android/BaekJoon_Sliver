import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        int[][] dp = new int[N + 1][K + 1];

        int[] w = new int[N];
        int[] v = new int[N];
        for(int i = 0 ; i < N ; i ++){
            s = bf.readLine().split(" ");
            w[i] = Integer.parseInt(s[0]);
            v[i] = Integer.parseInt(s[1]);
        }

        for(int r = 1 ; r < N + 1 ; r ++){
            for(int c = 1 ; c < K + 1 ; c ++){
                if(w[r - 1] > c) dp[r][c] = dp[r - 1][c];
                else dp[r][c] = Math.max(dp[r - 1][c], v[r - 1] + dp[r][c - w[r - 1]]);
            }
        }
        for(int[] i : dp) System.out.println(Arrays.toString(i));
    }
}
