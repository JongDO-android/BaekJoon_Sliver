package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//안전 영역
public class Problem_2468 {
    private static int N;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] city;
    private static boolean[][] visit;
    private static class Point{
        int x;
        int y;
        private Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static int search(Point p){
        Queue<Point> q = new LinkedList<>();
        q.offer(p);
        while(!q.isEmpty()){
            Point pos = q.poll();
            for(int i = 0 ; i < 4 ; i ++){
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];
                if(0 <= nx && nx < N && 0 <= ny && ny < N){
                    if(!visit[ny][nx]){
                        visit[ny][nx] = true;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
        return 1;
    }
    private static int bfs(int height){
        int domain = 0;
        for(int i = 0 ; i < N ; i ++) for(int j = 0 ; j < N ; j ++) if(city[i][j] <= height) visit[i][j] = true;
        for(int i = 0 ; i < N ; i ++){
            for(int j = 0 ; j < N ; j ++){
                if(!visit[i][j]){
                    domain += search(new Point(j, i));
                }
            }
        }
        return domain;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        city = new int[N][N];
        visit = new boolean[N][N];
        int max = 0;

        for(int i = 0 ; i < N ; i ++){
            String[] s = bf.readLine().split(" ");
            for(int j = 0 ; j < N ; j ++) {
                city[i][j] = Integer.parseInt(s[j]);
                max = Math.max(max, city[i][j]);
            }
        }
        int domain = 1;
        int height = 1;
        while(height <= max){
            visit = new boolean[N][N];
            domain = Math.max(domain, bfs(height));
            height ++;
        }
        System.out.println(domain);
    }
}