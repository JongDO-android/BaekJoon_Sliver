package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem_3190 {
    private static int N;
    private static int[] d_time; // 방향 전환 하는 시간을 담을 배열
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static boolean[][] apple; // 사과가 있는 배열
    private static boolean[][] snake; // 뱀의 경로를 담을 배열
    private static class Point{
        int x;
        int y;
        private Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static class Snake{
        ArrayList<Point> sk; // 뱀 경로
        int dir; // 뱀의 방향
        private Snake(){
            this.sk = new ArrayList<>();
            this.dir = 0;
            sk.add(new Point(0, 0));
        }
    }
    private static int dummy(){
        Snake sn = new Snake();
        int time = 0;
        while(true){
            sn.dir += d_time[time];
            if(sn.dir < 0) sn.dir = 3;
            else sn.dir %= 4;
            time ++;
            int nx = sn.sk.get(sn.sk.size() - 1).x + dx[sn.dir];
            int ny = sn.sk.get(sn.sk.size() - 1).y + dy[sn.dir];

            if(0 <= nx && nx < N && 0 <= ny && ny < N){
                if(snake[ny][nx]) break;
                if(apple[ny][nx]){
                    apple[ny][nx] = false;
                    snake[ny][nx] = true;
                }
                else{
                    snake[sn.sk.get(0).y][sn.sk.get(0).x] = false; // 뱀 꼬리 false
                    snake[ny][nx] = true;
                    sn.sk.remove(0);
                }
                sn.sk.add(new Point(nx, ny));
            }
            else break;
        }
        return time;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        int T = Integer.parseInt(bf.readLine());

        apple = new boolean[N][N];
        snake = new boolean[N][N];
        snake[0][0] = true;

        for(int i = 0 ; i < T ; i ++){
            String[] s = bf.readLine().split(" ");
            int r = Integer.parseInt(s[0]);
            int c = Integer.parseInt(s[1]);
            apple[r - 1][c - 1] = true;
        }
        d_time = new int[10001];
        T = Integer.parseInt(bf.readLine());
        for(int i = 0 ; i < T ; i++){
            String[] s = bf.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            if(s[1].equals("L")) d_time[x] = -1;
            else d_time[x] = 1;
        }
        System.out.println(dummy());
    }
}
