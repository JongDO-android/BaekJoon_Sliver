package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 경로 찾기
public class Problem_11403 {
    private static int N;
    private static int[][] graph;
    private static boolean[] visit;
    private static void dfs(int[][] answer, int row, int vertex){
        for(int i = 0 ; i < N ; i ++){
            if(graph[row][i] == 1 && !visit[i]){
                visit[i] = true;
                answer[vertex][i] = 1;
                dfs(answer, i, vertex);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        graph = new int[N][N];
        int[][] answer = new int[N][N];
        for(int i = 0 ; i < N ; i ++){
            String[] s = bf.readLine().split(" ");
            for(int j = 0 ; j < N ; j ++) graph[i][j] = Integer.parseInt(s[j]);
        }

        for(int i = 0 ; i < N ; i ++) {
            visit = new boolean[N];
            dfs(answer, i, i);
        }
        for(int[] i : answer) {
            for(int j : i) System.out.print(j + " ");
            System.out.println();
        }
    }
}
