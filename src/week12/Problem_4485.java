package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem_4485 {
    private static int N;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] dist;
    private static int[][] map;
    private static class Point implements Comparable<Point>{
        int x;
        int y;
        int cost;
        Point(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return this.cost - o.cost;
        }
    }
    private static int dijkstra(){
        PriorityQueue<Point> pq = new PriorityQueue<>();
        int start = map[0][0];
        dist[0][0] = start;

        pq.add(new Point(1, 0, map[0][1] + start));
        pq.add(new Point(0, 1, map[1][0] + start));

        while(!pq.isEmpty()){
            Point p = pq.poll();

            for(int i = 0 ; i < 4 ; i ++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(0 <= nx && nx < N && 0 <= ny && ny < N){
                    if(dist[ny][nx] > p.cost + map[ny][nx]){
                        dist[ny][nx] = p.cost + map[ny][nx];
                        pq.add(new Point(nx, ny, p.cost + map[ny][nx]));
                    }
                }
            }
        }
        return dist[N - 1][N - 1];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = 2;
        int count = 1;
        while(true){
            N = Integer.parseInt(bf.readLine());
            if(N == 0) break;
            map = new int[N][N];
            dist = new int[N][N];
            for(int i = 0 ; i < N ; i ++) Arrays.fill(dist[i], N * N * 10);

            for(int i = 0 ; i < N ; i ++){
                String[] input = bf.readLine().split(" ");
                for(int j = 0 ; j < N ; j ++) map[i][j] = Integer.parseInt(input[j]);
            }

            System.out.println("Problem " + count + ": " + dijkstra());
            count ++;
        }
    }
}
