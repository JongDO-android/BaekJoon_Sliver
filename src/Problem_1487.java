import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1487 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] bft = new int[N][2];
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < N ; i ++){
            String[] s = bf.readLine().split(" ");
            bft[i][0] = Integer.parseInt(s[0]);
            bft[i][1] = Integer.parseInt(s[1]);
            if(max < bft[i][0]) max = bft[i][0];
            if(min > bft[i][0]) min = bft[i][0];
        }
        int[][] dp = new int[N + 1][max - min + 1];
        int cost = 0;
        max = 0;
        for(int row = 1 ; row < N + 1 ; row ++){
            for(int col = 0 ; col < dp[0].length ; col ++){
                if(col + min <= bft[row -1][0]) dp[row][col] = col + min - bft[row - 1][1];
                dp[row][col] += dp[row - 1][col];
                if(row == N && max < dp[row][col]){
                    max = dp[row][col];
                    cost = col + min;
                }
            }
        }
        System.out.println(cost);
    }
}

