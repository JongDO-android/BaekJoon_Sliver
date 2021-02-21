import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_2636 {
    private static int N, M;
    private static int[] dir_x = {1, 0, -1, 0};
    private static int[] dir_y = {0, 1, 0, -1};
    private static int[][] map;

    private static class Point{
        int x;
        int y;
        private Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static int remove(){
        int chz = 0;
        for(int i = 0 ; i < N ; i ++) {
            for(int j = 0 ; j < M ; j ++){
                if(map[i][j] == 2){
                    map[i][j] = 0;
                    chz ++;
                }
            }
        }
        return chz;
    }
    private static void bfs(){
        Queue<Point> q = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];
        q.offer(new Point(0, 0));
        visit[0][0] = true;
        while(!q.isEmpty()){
            Point pos = q.poll();
            if(map[pos.y][pos.x] == 1) {
                map[pos.y][pos.x] ++;
                continue;
            }
            for(int i = 0 ; i < 4 ; i ++){
                Point np = new Point(pos.x + dir_x[i], pos.y + dir_y[i]);
                if(0 <= np.x && np.x < M && 0 <= np.y && np.y < N){
                    if(!visit[np.y][np.x]){
                        visit[np.y][np.x] = true;
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

        for(int i = 0 ; i < N ; i ++){
            s = bf.readLine().split(" ");
            for(int j = 0 ; j < M ; j ++) map[i][j] = Integer.parseInt(s[j]);
        }
        int cheeze = 1;
        int chz = 0;
        int time = 0;
        while(cheeze > 0){
            bfs();
            chz = cheeze;
            cheeze = remove();
            if(cheeze == 0) break;
            time ++;
        }
        System.out.println(time);
        System.out.println(chz);

    }
}
