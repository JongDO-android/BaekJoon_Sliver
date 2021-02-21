package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 아기 상어
public class Problem_16236 {
    private static int N, time;
    private static int[] dx = {0, -1, 1, 0};
    private static int[] dy = {-1, 0, 0, 1};
    private static int[][] bowl;

    private static class Point implements Comparable<Point>{
        int x;
        int y;
        int dis;
        private Point(int x, int y, int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }

        @Override
        public int compareTo(Point o) {
            if(this.dis == o.dis){
                if(this.y == o.y) return this.x - o.x;
                else return this.y - o.y;
            }
            else return this.dis - o.dis;
        }
    }
    private static class shark{
        int x;
        int y;
        int eat;
        int size;
        private shark(int x, int y){
            this.x = x;
            this.y = y;
            this.eat = 0;
            this.size = 2;
        }
    }
    private static boolean bfs(shark sk){
        PriorityQueue<Point> q = new PriorityQueue<>();
        boolean[][] visit = new boolean[N][N];
        q.offer(new Point(sk.x, sk.y, 0));
        visit[sk.y][sk.x] = true;
        while(!q.isEmpty()){
            Point p = q.poll();
            if(sk.size > bowl[p.y][p.x] && bowl[p.y][p.x] > 0){
                bowl[p.y][p.x] = 0;
                sk.eat ++;
                sk.x = p.x;
                sk.y = p.y;
                time += p.dis;
                if(sk.size == sk.eat) {
                    sk.eat = 0;
                    sk.size ++;
                }
                return true;
            }
            for(int i = 0 ; i < 4 ; i ++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(0 <= nx && nx < N && 0 <= ny && ny < N){
                    if(!visit[ny][nx] && bowl[ny][nx] <= sk.size){
                        visit[ny][nx] = true;
                        q.offer(new Point(nx, ny, p.dis + 1));
                    }
                }
            }

        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        time = 0;
        bowl = new int[N][N];
        shark sk = new shark(0, 0);
        for(int i = 0 ; i < N ; i ++){
            String[] s = bf.readLine().split(" ");
            for(int j = 0 ; j < N ; j ++){
                bowl[i][j] = Integer.parseInt(s[j]);
                if(bowl[i][j] == 9) {
                    bowl[i][j] = 0;
                    sk.x = j;
                    sk.y = i;
                }
            }
        }
        while(true) if(!bfs(sk)) break;
        System.out.println(time);
    }
}
