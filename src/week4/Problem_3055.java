package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_3055 {
    private static int R, C;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static char[][] map;
    private static ArrayList<Point> waters;
    private static class Point{
        int x;
        int y;
        int m;
        private Point(int x, int y){
            this.x = x;
            this.y = y;
            this.m = 0;
        }
    }
    private static int bfs(Point sp, Point tp){
        int m = 0;
        Queue<Point> q = new LinkedList<>();
        for(Point p : waters) q.offer(p);
        q.offer(sp);

        while(!q.isEmpty()){
            Point p = q.poll();
            if(map[p.y][p.x] == 'D'){
                m = p.m;
                break;
            }
            for(int i = 0 ; i < 4 ; i ++){
                Point np = new Point(p.x + dx[i], p.y + dy[i]);
                if(0 <= np.x && np.x < C && 0 <= np.y && np.y < R){
                    if(map[np.y][np.x] == '.'){ // 탐색 할 좌표가 비어 있는 경우
                        if(map[p.y][p.x] == '*') map[np.y][np.x] = '*'; // 탐색 중인 좌표가 물이면 물로 채워줌
                        else if(map[p.y][p.x] == 'S') { // 고슴도치면 고슴도치로 채워줌
                            map[np.y][np.x] = 'S';
                            np.m = p.m + 1;
                        }

                        q.offer(np);
                    }
                    else if(map[np.y][np.x] == 'D'){ // 고슴도치를 탐색할 때, 다음 탐색할 좌표가 비버의 굴인 경우
                        if(map[p.y][p.x] == 'S'){
                            np.m = p.m + 1;
                            q.offer(np);
                        }
                    }
                }
            }
        }
        return m;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        map = new char[R][C];
        waters = new ArrayList<>();
        Point sp = new Point(0, 0);
        Point tp = new Point(0, 0);

        for(int i = 0 ; i < R ; i ++) {
            String ss = bf.readLine();
            for(int j = 0 ; j < C ; j ++) {
                map[i][j] = ss.charAt(j);
                if(map[i][j] == '*') waters.add(new Point(j, i)); // 물이 있는 좌표 추가
                else if(map[i][j] == 'S') sp = new Point(j, i); // 고슴도치 좌표
                else if(map[i][j] == 'D') tp = new Point(j, i); // 비버의 굴 좌표
            }
        }
        int min = bfs(sp, tp);
        if(min == 0) System.out.println("KAKTUS");
        else System.out.println(min);
    }
}
