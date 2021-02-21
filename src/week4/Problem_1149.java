package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 실버 1 RGB 거리
public class Problem_1149 {
    private static int N;
    private static int[][] RGB, dp;
    private static int dynamic(int row, int rgb){
        if(row >= N) return 0;
        if(dp[row][rgb] > 0) return dp[row][rgb];

        dp[row][rgb] = RGB[row][rgb];
        switch (rgb){
            case 0 :
                dp[row][rgb] += Math.min(dynamic(row + 1, 1), dynamic(row + 1, 2));
                break;
            case 1:
                dp[row][rgb] += Math.min(dynamic(row + 1, 0), dynamic(row + 1, 2));
                break;
            case 2:
                dp[row][rgb] += Math.min(dynamic(row + 1, 0), dynamic(row + 1, 1));
                break;
        }
        return dp[row][rgb];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        RGB = new int[N][3];
        dp = new int[N][3];
        for(int i = 0 ; i < N ; i ++){
            String[] rgb = bf.readLine().split(" ");
            for(int j = 0 ; j < 3 ; j ++) RGB[i][j] = Integer.parseInt(rgb[j]);
        }
        int min = Math.min(dynamic(0, 0), Math.min(dynamic(0, 1), dynamic(0, 2)));
        System.out.println(min);
    }
}
