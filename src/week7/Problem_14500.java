package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 테트로미노
public class Problem_14500 {
    private static int N, M, MAX;
    private static int[][] map;
    private static int[] dx = {1, 0, -1, 0, -1, -1};
    private static int[] dy = {0, 1, 0, -1, -1, 1};
    private static boolean[][] visit;
    private static void dfs(int x, int y, int sum, int count){
        if(x < 0 || M - 1 < x || y < 0 || N - 1 < y) return;
        if(count == 3){
            MAX = Math.max(sum, MAX);
            return;
        }
        for(int i = 0 ; i < 6 ; i ++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(0 <= nx && nx < M && 0 <= ny && ny < N){
                if(!visit[ny][nx]){
                    visit[ny][nx] = true;

                    int cnt = 0;
                    for(int j = 0 ; j < 4 ; j ++){
                        int nnx = nx + dx[j];
                        int nny = ny + dy[j];
                        if(0 <= nnx && nnx < M && 0 <= nny && nny < N){
                            if(!visit[nny][nnx]) cnt ++;
                            else break;
                        }
                        else cnt ++;
                    }
                    if(cnt == 4) {
                        visit[ny][nx] = false;
                        continue;
                    }

                    dfs(nx, ny, sum + map[ny][nx], count + 1);
                    visit[ny][nx] = false;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        MAX = 0;
        map = new int[N][M];
        visit = new boolean[N][M];
        for(int i = 0 ; i < N ; i ++){
            s = bf.readLine().split(" ");
            for(int j = 0 ; j < M ; j ++) map[i][j] = Integer.parseInt(s[j]);
        }
        for(int i = 0 ; i < N ; i ++) {
            for(int j = 0 ; j < M ; j ++) {
                visit[i][j] = true;
                dfs(j, i, map[i][j], 0);
                visit[i][j] = false;
            }
        }
        System.out.println(MAX);
    }
}
