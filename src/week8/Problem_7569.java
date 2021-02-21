package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//토마토
public class Problem_7569 {
    private static int N, M, H;
    private static int[] dx = {1, 0, -1, 0, 0, 0};
    private static int[] dy = {0, 1, 0 , -1, 0, 0};
    private static int[] dz = {0, 0, 0, 0, 1, -1};
    private static int[][][] box;
    private static ArrayList<Point> tomatoes;

    private static class Point{
        int x;
        int y;
        int z;
        int day;
        private Point(int x, int y, int z, int day){
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }
    private static int bfs(){
        Queue<Point> q = new LinkedList<>();
        boolean[][][] visit = new boolean[N][M][H];
        for(Point p : tomatoes) {
            visit[p.y][p.x][p.z] = true;
            q.offer(p);
        }
        int minday = 0;
        while(!q.isEmpty()){
            Point pos = q.poll();
            minday = Math.max(minday, pos.day);
            for(int i = 0 ; i < 6 ; i ++){
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];
                int nz = pos.z + dz[i];

                if(0 <= nx && nx < M && 0 <= ny && ny < N && 0 <= nz && nz < H){
                    if(!visit[ny][nx][nz] && box[ny][nx][nz] == 0){
                        visit[ny][nx][nz] = true;
                        box[ny][nx][nz] = 1;
                        q.offer(new Point(nx, ny, nz, pos.day + 1));
                    }
                }
            }
        }
        for(int k = 0 ; k < H ; k ++){
            for(int i = 0 ; i < N ; i ++){
                for(int j = 0 ; j < M ; j ++){
                    if(box[i][j][k] == 0) return -1;
                }
            }
        }
        return minday;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        M = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);
        H = Integer.parseInt(s[2]);
        box = new int[N][M][H];
        tomatoes = new ArrayList<>();
        boolean isAll = false;

        for(int k = 0 ; k < H ; k ++){
            for(int i = 0 ; i < N ; i ++){
                s = bf.readLine().split(" ");
                for(int j = 0 ; j < M ; j ++){
                    box[i][j][k] = Integer.parseInt(s[j]);
                    if(box[i][j][k] == 0) isAll = true;
                    else if(box[i][j][k] == 1) tomatoes.add(new Point(j, i, k, 0));
                }
            }
        }
        if(!isAll) System.out.println(0);
        else System.out.println(bfs());
    }
}
