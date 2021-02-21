import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_2178 {
    private static int N, M;
    private static int[] dir_x = {1, 0, -1, 0};
    private static int[] dir_y = {0, 1, 0, -1};
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
    private static int bfs(boolean[][] maze, boolean[][] visit){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, 1));
        while(!q.isEmpty()){
            Point pos = q.poll();
            int temp_d = pos.d;
            if(pos.x == M - 1 && pos.y == N - 1) return pos.d;
            for(int i = 0 ; i < 4 ; i ++){
                int nx = pos.x + dir_x[i];
                int ny = pos.y + dir_y[i];
                if(0 <= nx && nx < M && 0 <= ny && ny < N){
                    if(!visit[ny][nx] && maze[ny][nx]){
                        visit[ny][nx] = true;
                        q.offer(new Point(nx, ny, temp_d + 1));
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        boolean[][] maze = new boolean[N][M];
        boolean[][] visit = new boolean[N][M];
        for(int row = 0 ; row < N ; row ++){
            String s = bf.readLine();
            for(int col = 0 ; col < M ; col ++) maze[row][col] = s.charAt(col) == '1';
        }
        System.out.println(bfs(maze, visit));
    }
}
