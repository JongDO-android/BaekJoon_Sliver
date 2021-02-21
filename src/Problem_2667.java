import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Problem_2667 {
    private static int N;
    private static int dfs(boolean[][] map, boolean[][] visit, int x, int y){
        if(x < 0 || N - 1 < x || y < 0 || N - 1 < y) return 0;
        if(visit[y][x]) return 0;
        if(map[y][x]){
            visit[y][x] = true;
            return dfs(map, visit, x + 1, y) + dfs(map, visit, x, y + 1)
                    + dfs(map, visit, x - 1, y) + dfs(map, visit, x, y - 1) + 1;
        }
        else return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        boolean[][] visit = new boolean[N][N];
        boolean[][] map = new boolean[N][N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int row = 0 ; row < N ; row ++){
            String s = bf.readLine();
            for(int col = 0 ; col < N ; col ++) map[row][col] = s.charAt(col) == '1';
        }
        for(int row = 0 ; row < N ; row ++){
            for(int col = 0 ; col < N ; col ++) if(!visit[row][col] && map[row][col]) pq.add(dfs(map, visit, col, row));
        }
        System.out.println(pq.size());
        while(!pq.isEmpty()) System.out.println(pq.poll());
    }
}
