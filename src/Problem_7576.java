import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 7576 토마토
public class Problem_7576 {
    private static int N, M;
    private static int[] dir_x = {1, 0, -1, 0};
    private static int[] dir_y = {0, 1, 0, -1};
    private static int[][] box;
    private static ArrayList<Point> tomatoes;
    private static class Point{
        int x;
        int y;
        int d;
        private Point(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    private static int bfs(){
        Queue<Point> q = new LinkedList<>();
        for(Point p : tomatoes) q.offer(p);
        int min = 0;
        while(!q.isEmpty()){
            Point p = q.poll();
            min = p.d;
            for(int i = 0 ; i < 4 ; i ++){
                Point n_pos = new Point(p.x + dir_x[i], p.y + dir_y[i], p.d + 1);
                if(n_pos.x < 0 || M - 1 < n_pos.x || n_pos.y < 0 || N - 1 < n_pos.y) continue;
                if(box[n_pos.y][n_pos.x] == 0){
                    q.offer(n_pos);
                    box[n_pos.y][n_pos.x] = 1;
                }
            }
        }
        return min;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        tomatoes = new ArrayList<>();
        M = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);
        box = new int[N][M];
        for(int i = 0 ; i < N ; i ++){
            s = bf.readLine().split(" ");
            for(int j = 0 ; j < M ; j ++) {
                box[i][j] = Integer.parseInt(s[j]);
                if(box[i][j] == 1) tomatoes.add(new Point(j, i, 0));
            }
        }
        int m = bfs();
        for(int[] i : box){
            for(int j : i) if(j == 0) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(m);
    }
}
