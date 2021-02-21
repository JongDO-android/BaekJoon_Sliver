package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 로봇 청소기
public class Problem_14503 {
    private static int N, M;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};
    private static int[][] map;

    private static Cleaner cleaner;
    private static class Cleaner{
        int x;
        int y;
        int d;
        int d_count;
        int count;
        private Cleaner(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
            this.d_count = 0;
            this.count = 0;
        }
    }
    private static void clean(){
        int x = cleaner.x;
        int y = cleaner.y;
        int d = cleaner.d == 0 ? 3 : cleaner.d - 1;
        if(cleaner.d_count == 4){
            int nx = x + dx[(cleaner.d + 2) % 4];
            int ny = y + dy[(cleaner.d + 2) % 4];
            if(map[ny][nx] == 1) return;
            else{
                cleaner.x = nx;
                cleaner.y = ny;
                cleaner.d_count = 0;
                clean();
                return;
            }
        }
        if(map[y][x] == 0) {
            map[y][x] = 2;
            cleaner.count ++;
        }
        int nx = x + dx[d];
        int ny = y + dy[d];
        if(0 <= nx && nx < M && 0 <= ny && ny < N){
            if(map[ny][nx] == 0){
                cleaner.x = nx;
                cleaner.y = ny;
                cleaner.d = d;
                cleaner.d_count = 0;
                clean();
            }
            else{
                cleaner.d = d;
                cleaner.d_count += 1;
                clean();
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        s = bf.readLine().split(" ");

        int r = Integer.parseInt(s[0]);
        int c = Integer.parseInt(s[1]);
        int d = Integer.parseInt(s[2]);
        cleaner = new Cleaner(c, r, d);
        map = new int[N][M];
        for(int i = 0 ; i < N ; i ++){
            s = bf.readLine().split(" ");
            for(int j = 0 ; j < M ; j ++) map[i][j] = Integer.parseInt(s[j]);
        }
        clean();
        System.out.println(cleaner.count);
    }
}
