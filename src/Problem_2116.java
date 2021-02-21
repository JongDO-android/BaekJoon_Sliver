import java.util.Scanner;

public class Problem_2116 {
    private static int[][] dp;
    private static int DP(int[][] dice, int row, int val){
        if(row > dice.length - 1) return 0;
        int idx = -1;
        int u_idx;
        for(int i = 0 ; i < 6 ; i ++){
            if(val == dice[row][i]) {
                idx = i;
                break;
            }
        }
        if(dp[row][idx] > 0) return dp[row][idx];
        int max = 0;
        if(idx == 0 || idx == 5) u_idx = 5 - idx;
        else if(idx == 1 || idx == 3) u_idx = 4 - idx;
        else u_idx = 6 - idx;

        for(int i = 0 ; i < 6 ; i ++) if(i != idx && i != u_idx && max < dice[row][i]) max = dice[row][i];
        dp[row][idx] = Math.max(DP(dice, row + 1, dice[row][u_idx]) + max, dp[row][idx]);
        return dp[row][idx];
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] dice = new int[N][6];
        dp = new int[N][6];
        int max = 0;
        for(int i = 0 ; i < N ; i ++) for(int j = 0 ; j < 6 ; j ++) dice[i][j] = scanner.nextInt();
        for(int i = 0 ; i < 6 ; i ++) {
            int val = DP(dice, 0, dice[0][i]);
            if(max < val) max = val;
        }
        for(int[] i : dp){
            for(int j : i) System.out.print(j + " ");
            System.out.println();
        }
        System.out.println(max);
    }
}
