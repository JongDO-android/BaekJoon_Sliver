package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//플로이드
public class Problem_11404 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        int max = 100000 * N;
        int[][] costs = new int[N][N];
        for(int r = 0 ; r < N ; r ++) {
            for(int c = 0 ; c < N ; c ++) {
                if(r == c) costs[r][c] = 0;
                else costs[r][c] = max;
            }
        }
        for(int i = 0 ; i < M ; i ++) {
            String[] s = bf.readLine().split(" ");
            int r = Integer.parseInt(s[0]) - 1;
            int c = Integer.parseInt(s[1]) - 1;
            int w = Integer.parseInt(s[2]);

            costs[r][c] = Math.min(w, costs[r][c]);
        }
       for(int n2 = 0 ; n2 < N ; n2 ++){
           for(int n1 = 0 ; n1 < N ; n1 ++){
               for(int n3 = 0 ; n3 < N ; n3 ++){
                   costs[n1][n3] = Math.min(costs[n1][n3], costs[n1][n2] + costs[n2][n3]);
               }
           }
       }
       for(int[] i : costs) {
           for(int j : i) {
               if(j == max) System.out.print(0 + " ");
               else System.out.print(j + " ");
           }
           System.out.println();
       }
    }
}
