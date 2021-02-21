package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_1012 {
    static int N, M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static void bfs(int[][] map, boolean[][] visit, int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visit[y][x] = true;
        while(!q.isEmpty()){
            Point pos = q.poll();

            for(int i = 0 ; i < 4 ; i ++){
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if(0 <= nx && nx < M && 0 <= ny && ny < N){
                    if(!visit[ny][nx] && map[ny][nx] == 1){
                        visit[ny][nx] = true;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        for(int t = 0 ; t < T ; t ++){
            String[] input = bf.readLine().split(" ");

            M = Integer.parseInt(input[0]);
            N = Integer.parseInt(input[1]);
            int K = Integer.parseInt(input[2]);

            int answer = 0;
            int[][] map = new int[N][M];
            boolean[][] visit = new boolean[N][M];
            for(int i = 0 ; i < K ; i ++){
                input = bf.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);

                map[y][x] = 1;
            }

            Queue<Point> q = new LinkedList<>();
            for(int i = 0 ; i < N ; i ++){
                for(int j = 0 ; j < M ; j ++){
                    if(!visit[i][j] && map[i][j] == 1){
                        bfs(map, visit, j, i);
                        answer ++;
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
