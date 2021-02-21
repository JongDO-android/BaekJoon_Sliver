package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_1937 {
    private static int N;
    private static int[][] forest;
    private static int[][] memo;

    private static int dfs(int x, int y, int p_num){
        if(x < 0 || N - 1 < x || y < 0 || N - 1 < y) return 0;
        if(p_num >= forest[y][x]) return 0;
        if(memo[y][x] > 0) return memo[y][x];

        int cur = forest[y][x];
        memo[y][x] = Math.max(memo[y][x], dfs(x + 1, y, cur) + 1);
        memo[y][x] = Math.max(memo[y][x], dfs(x, y + 1, cur) + 1);
        memo[y][x] = Math.max(memo[y][x], dfs(x - 1, y, cur) + 1);
        memo[y][x] = Math.max(memo[y][x], dfs(x, y - 1, cur) + 1);

        return memo[y][x];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        forest = new int[N][N];
        memo = new int[N][N];

        for(int i = 0 ; i < N ; i ++){
            String[] input = bf.readLine().split(" ");
            for(int j = 0 ; j < N ; j ++) forest[i][j] = Integer.parseInt(input[j]);
        }
        int answer = 0;
        for(int i = 0 ; i < N ; i ++){
            for(int j = 0 ; j < N ; j ++){
                answer = Math.max(answer, dfs(j, i, 0));
            }
        }
        for(int[] i : memo) System.out.println(Arrays.toString(i));
        System.out.println(answer);
    }
}
