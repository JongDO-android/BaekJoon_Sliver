import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
// 17135 캐슬 디펜스
public class Problem_17135 {
    private static int max, N, M, D;
    private static int[] dir_x = {-1, 0, 1};
    private static int[] dir_y = {0, -1, 0};
    private static int[][] board;
    private static Queue<Point> enemy;
    private static class Point{
        int x, y, d;
        private Point(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    // 궁수가 쏠 수 있는 적의 위치를 enemy에 넣어주는 메소드
    private static void find_Enemy(int[][] t_board, Point a_pos){
        Queue<Point> q = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];
        q.add(a_pos);
        while(!q.isEmpty()){
            Point pos = q.poll();
            if(pos.d > D) return;
            if(t_board[pos.y][pos.x] == 1){
                enemy.add(pos);
                return;
            }
            for(int i = 0 ; i < 3 ; i++){
                Point n_pos = new Point(pos.x + dir_x[i], pos.y + dir_y[i], pos.d + 1);
                if(0 <= n_pos.x && n_pos.x < M && 0 <= n_pos.y){
                    if(!visit[n_pos.y][n_pos.x]){
                        q.add(n_pos);
                        visit[n_pos.y][n_pos.x] = true;
                    }
                }
            }
        }
    }
    //궁수를 배치할 수 있는 모든 경우의 수에서 없앨 수 있는 적의 수를 갱신
    private static void arrange_Archer(int x1, int x2, int x3){
        int H = N;
        int val = 0;
        int[][] t_board = new int[N][M];
        for(int row = 0 ; row < N ; row ++) System.arraycopy(board[row], 0, t_board[row], 0, M);
        while(H > 0){
            find_Enemy(t_board, new Point(x1, H - 1, 1));
            find_Enemy(t_board, new Point(x2, H - 1, 1));
            find_Enemy(t_board, new Point(x3, H - 1, 1));
            while(!enemy.isEmpty()){
                Point e_pos = enemy.poll();
                if(t_board[e_pos.y][e_pos.x] == 1) val ++;
                t_board[e_pos.y][e_pos.x] = 0;
            }
            H --;
        }
        max = Math.max(max, val);
        if(x1 != M - 3){
            if(x2 != M - 2){
                if(x3 != M - 1) arrange_Archer(x1, x2, x3 + 1);
                else arrange_Archer(x1, x2 + 1, x2 + 2);
            }
            else arrange_Archer(x1 + 1, x1 + 2, x1 + 3);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] NMD = bf.readLine().split(" ");
        N = Integer.parseInt(NMD[0]);
        M = Integer.parseInt(NMD[1]);
        D = Integer.parseInt(NMD[2]);
        max = 0;
        board = new int[N][M];
        enemy = new LinkedList<>();
        for(int i = 0 ; i < N ; i ++) {
            String[] line = bf.readLine().split(" ");
            for(int j = 0 ; j < M ; j ++) board[i][j] = Integer.parseInt(line[j]);
        }
        arrange_Archer(0, 1, 2);
        System.out.println(max);
    }
}