import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s1 = bf.readLine();
        String s2 = bf.readLine();

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int row = 1 ; row < dp.length ; row ++){
            for(int col = 1 ; col < dp[0].length ; col ++){
                if(s1.charAt(row - 1) == s2.charAt(col - 1))
                    dp[row][col] = dp[row - 1][col - 1] + 1;
                else dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
            }
        }
        System.out.println(dp[s1.length()][s2.length()]);
    }
}
