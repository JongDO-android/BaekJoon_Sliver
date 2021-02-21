package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
// 골드 5 치즈
public class Problem_2638 {
    private static int N, M;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] map;
    private static class Point{
        int x;
        int y;
        private Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static boolean remain(){
        for(int[] i : map) for(int j : i) if(j == 1) return true;
        return false;
    }
    private static void melt(){
        ArrayList<Point> target = new ArrayList<>();
        for(int i = 1 ; i < N - 1 ; i ++){
            for(int j = 1 ; j < M - 1 ; j ++){
                int cnt = 0;
                if(map[i][j] == 1){
                    for(int d = 0 ; d < 4 ; d ++) if(map[i + dy[d]][j + dx[d]] == 0) cnt ++;
                    if(cnt >= 2) target.add(new Point(j, i));
                }
            }
        }
        for(Point p : target) map[p.y][p.x] = 0;
    }
    private static void detach(boolean[][] visit, Point p, int cnt){
        Queue<Point> q = new LinkedList<>();
        visit[p.y][p.x] = true;
        map[p.y][p.x] = cnt;
        q.offer(p);
        while(!q.isEmpty()){
            Point pos = q.poll();
            for(int i = 0 ; i < 4 ; i ++){
                Point np = new Point(pos.x + dx[i], pos.y + dy[i]);
                if(0 <= np.x && np.x < M && 0 <= np.y && np.y < N){
                    if(!visit[np.y][np.x] && map[np.y][np.x] != 1){
                        visit[np.y][np.x] = true;
                        map[np.y][np.x] = cnt;
                        q.offer(np);
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        map = new int[N][M];
        boolean[][] visit = new boolean[N][M];
        for(int i = 0 ; i < N ; i ++){
            s = bf.readLine().split(" ");
            for(int j = 0 ; j < M ; j ++) map[i][j] = Integer.parseInt(s[j]);
        }
        int cnt = 0;
        for(int i = 0 ; i < N ; i ++){
            for(int j = 0 ; j < M ; j ++){
                if(!visit[i][j] && map[i][j] == 0) {
                    detach(visit, new Point(j, i), cnt);
                    cnt = 2;
                }
            }
        }
        int ans = 0;
        while(remain()){
            melt();
            visit = new boolean[N][M];
            detach(visit, new Point(0,0), 0);

            ans ++;
        }
        System.out.println(ans);
    }
}
