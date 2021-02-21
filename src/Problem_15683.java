import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
// 감시
public class Problem_15683 {
    private static int N, M, MIN;
    private static int[] dir_x = {1, 0, -1, 0};
    private static int[] dir_y = {0, 1, 0, -1};
    private static int[][] office;
    private static int[] list;
    private static ArrayList<cctv> CCTV;
    private static class cctv {
        int x;
        int y;
        int num;
        ArrayList<Integer> dir;
        private cctv(int x, int y, int num){
            this.x = x;
            this.y = y;
            this.num = num;
            dir = new ArrayList<>();
            dir.add(0);
            if(num != 5){
                dir.add(1);
                if(num != 2){
                    dir.add(2);
                    dir.add(3);
                }
            }
        }
        private void watch(int[][] office, int dir){
            switch (num){
                case 1:
                    check(office, dir);
                    break;
                case 2:
                    check(office, dir);
                    check(office, (dir + 2) % 4);
                    break;
                case 3:
                    check(office, dir);
                    check(office, (dir + 1) % 4);
                    break;
                case 4:
                    check(office, dir);
                    check(office, (dir + 1) % 4);
                    check(office, (dir + 2) % 4);
                    break;
                case 5:
                    check(office, 0);
                    check(office, 1);
                    check(office, 2);
                    check(office, 3);
                    break;
            }
        }
        private void check(int[][] office, int dir){
            int tx = x + dir_x[dir];
            int ty = y + dir_y[dir];
            if(dir == 0 || dir == 2){
                while(0 <= tx && tx < M){
                    if(office[ty][tx] == 6) break;
                    if(office[ty][tx] == 0) office[ty][tx] = -1;
                    tx += dir_x[dir];
                }
            }
            else{
                while(0 <= ty && ty < N){
                    if(office[ty][tx] == 6) break;
                    if(office[ty][tx] == 0) office[ty][tx] = -1;
                    ty += dir_y[dir];
                }
            }
        }
    }
    private static void combination(int i1, int i2){
        if(i1 == CCTV.size()){
            int[][] temp = copy(office);
            for(int i = 0 ; i < list.length ; i ++){
                cctv ct = CCTV.get(i);
                ct.watch(temp, list[i]);
            }
            MIN = Math.min(MIN, getMin(temp));
            return;
        }
        for(int i = i2 ; i < CCTV.size() ; i ++){
            cctv ct = CCTV.get(i);
            for(Integer dir : ct.dir){
                list[i1] = dir;
                combination(i1 + 1, i + 1);
            }
        }
    }
    private static int[][] copy(int[][] office){
        int[][] temp = new int[N][M];
        for(int row = 0 ; row < N ; row ++) System.arraycopy(office[row], 0, temp[row], 0 , M);
        return temp;
    }
    private static int getMin(int[][] t_office){
        int val = 0;
        for(int[] i : t_office) for(int j : i) if(j == 0) val ++;
        return val;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        CCTV = new ArrayList<>();
        MIN = M * N;
        office = new int[N][M];

        for(int i = 0 ; i < N ; i ++){
            s = bf.readLine().split(" ");
            for(int j = 0 ; j < M ; j ++){
                office[i][j] = Integer.parseInt(s[j]);
                if(office[i][j] != 0 && office[i][j] != 6) CCTV.add(new cctv(j, i, office[i][j]));
            }
        }
        list = new int[CCTV.size()];
        combination(0, 0);
        System.out.println(MIN);
    }
}
