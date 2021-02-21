package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1780 {
    private static int N;
    private static int[] answer;
    private static int[][] paper;
    private static void cut(int s_x, int s_y, int val){
        int num = paper[s_y][s_x];
        boolean b = false;

        for(int i = s_y ; i < s_y + val ; i ++){
            for(int j = s_x ; j < s_x + val ; j ++){
                if(num != paper[i][j]){
                    b = true;
                    break;
                }
            }
            if(b) break;
        }
        if(b){
            for(int i = s_y ; i < s_y + val ; i += val / 3){
                for(int j = s_x ; j < s_x + val ; j += val / 3){
                    cut(j, i, val / 3);
                }
            }
        }
        else answer[num + 1] ++;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        answer = new int[3];
        paper = new int[N][N];

        for(int i = 0 ; i < N ; i ++){
            String[] input = bf.readLine().split(" ");
            for(int j = 0 ; j < N ; j ++) paper[i][j] = Integer.parseInt(input[j]);
        }
        cut(0, 0, N);
        for(int i : answer) System.out.println(i);
    }
}
