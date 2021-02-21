package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 골드 2 낚시왕
public class Problem_17143 {
    private static int R, C;
    private static int[][][] bowl;
    private static void mShark(int[][][] t_bowl, int r, int c){
        int tr = r;
        int tc = c;
        int m = bowl[r][c][1];
        int dir = bowl[r][c][2];
        switch (dir){
            case 1:
                if(r - m < 1){
                    int val = Math.abs(r - m - 1);
                    if(val / R == 0){
                        dir = 2;
                        r = 1 + val;
                    }
                    else r = R - val % (R - 1);
                }
                else r -= m;
                break;
            case 2:
                if(r + m > R){
                    int val = r + m - R;
                    if(val / R == 0){
                        dir = 1;
                        r = R - val;
                    }
                    else r = 1 + val % (R - 1);
                }
                else r += m;
                break;
            case 3:
                if(c + m > C) {
                    int val = c + m - C;
                    if(val / C == 0){
                        dir = 4;
                        c = C - val;
                    }
                    else c = 1 + val % (C - 1);
                }
                else c += m;
                break;
            case 4:
                if(c - m < 1){
                    int val = Math.abs(c - m - 1);
                    if(val / C == 0){
                        dir = 3;
                        c = 1 + val;
                    }
                    else c = C - val % (C - 1);
                }
                else c -= m;
                break;
        }
        if(t_bowl[r][c][0] < bowl[tr][tc][0]){
            t_bowl[r][c][0] = bowl[tr][tc][0];
            t_bowl[r][c][1] = bowl[tr][tc][1];
            t_bowl[r][c][2] = dir;
        }
    }
    private static int[][][] move(){
        int[][][] t_bowl = new int[R + 1][C + 1][3];
        for(int i = 1 ; i < R + 1 ; i ++){
            for(int j = 1 ; j < C + 1 ; j ++) if(bowl[i][j][0] > 0) mShark(t_bowl, i, j);
        }
        return t_bowl;
    }
    private static int get(int c){
        for(int i = 1 ; i < R + 1 ; i ++){
            if(bowl[i][c][0] > 0) {
                int size = bowl[i][c][0];
                bowl[i][c][0] = 0;
                return size;
            }
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        int M = Integer.parseInt(s[2]);
        int answer = 0;
        bowl = new int[R + 1][C + 1][3];
        for(int i = 0 ; i < M ; i ++){
            s = bf.readLine().split(" ");
            int r = Integer.parseInt(s[0]);
            int c = Integer.parseInt(s[1]);
            int speed = Integer.parseInt(s[2]);
            int dir = Integer.parseInt(s[3]);
            int size = Integer.parseInt(s[4]);

            bowl[r][c][0] = size;
            bowl[r][c][1] = dir < 3 ? speed % (2 * (R - 1)) : speed % (2 * (C - 1));
            bowl[r][c][2] = dir;
        }
        for(int i = 1; i < C + 1 ; i ++) {
            answer += get(i);
            bowl = move();
        }
        System.out.println(answer);
    }
}
