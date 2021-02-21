package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 벽 부수고 이동하기
public class Problem_2206 {
    private static int N, M;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] map;
    private static class Point{
        int x;
        int y;
        int d;
        int b;
        private Point(int x, int y, int d, int b){
            this.x = x;
            this.y = y;
            this.d = d;
            this.b = b;
        }
    }
    private static int bfs(){
        Queue<Point> q = new LinkedList<>();
        boolean[][][] visit = new boolean[N][M][2]; // 0 -> 벽 x , 1 -> 벽 부숨
        visit[0][0][0] = true;
        q.offer(new Point(0,0, 1, 0));
        int ans = -1;
        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.x == M - 1 && p.y == N - 1){
                ans = p.d;
                break;
            }
            if(p.b > 1) continue;
            for(int i = 0 ; i < 4 ; i ++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(0 <= nx && nx < M && 0 <= ny && ny < N){
                    if(!visit[ny][nx][p.b]){
                        visit[ny][nx][p.b] = true;
                        q.offer(new Point(nx, ny, p.d + 1, p.b + map[ny][nx]));
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        map = new int[N][M];
        for(int i = 0 ; i < N ; i ++){
            String str = bf.readLine();
            for(int j = 0 ; j < M ; j ++) map[i][j] = str.charAt(j) - '0';
        }
        System.out.println(bfs());
    }
}
