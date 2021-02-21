package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 골드 5 연구소
public class Problem_14502 {
    private static int N, M, MAX;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] map;
    private static ArrayList<Point> walls, temp, virus;
    private static class Point{
        int x;
        int y;
        private Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static int infect(){
        Queue<Point> q = new LinkedList<>();
        for(Point p : virus) q.offer(p);
        int[][] t_map = new int[N][M];
        for(int r = 0 ; r < N ; r ++) System.arraycopy(map[r], 0, t_map[r], 0, M);
        while(!q.isEmpty()){
            Point pos = q.poll();
            for(int i = 0 ; i < 4 ; i ++){
                Point np = new Point(pos.x + dx[i], pos.y + dy[i]);
                if(0 <= np.x && np.x < M && 0 <= np.y && np.y < N){
                    if(t_map[np.y][np.x] == 0) {
                        t_map[np.y][np.x] = 2;
                        q.offer(np);
                    }
                }
            }
        }
        int val = 0;
        for(int[] i : t_map) for(int j : i) if(j == 0) val ++;
        return val;
    }
    private static void combination(int i1, int i2){
        if(i1 == 3){
            for(Point p : temp) map[p.y][p.x] = 1;
            MAX = Math.max(MAX, infect());
            for(Point p : temp) map[p.y][p.x] = 0;
            return;
        }
        for(int i = i2 ; i < walls.size() ; i ++){
            temp.set(i1, walls.get(i));
            combination(i1 + 1, i + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        MAX = 0;
        map = new int[N][M];
        walls = new ArrayList<>();
        virus = new ArrayList<>();
        temp = new ArrayList<>();

        for(int i = 0 ; i < 3 ; i ++) temp.add(new Point(0, 0));
        for(int i = 0 ; i < N ; i ++){
            s = bf.readLine().split(" ");
            for(int j = 0 ; j < M ; j ++) {
                map[i][j] = Integer.parseInt(s[j]);
                if(map[i][j] == 0) walls.add(new Point(j, i));
                else if(map[i][j] == 2) virus.add(new Point(j, i));
            }
        }
        combination(0, 0);
        System.out.println(MAX);
    }
}
