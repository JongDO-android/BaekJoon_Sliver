import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_10026 {
    private static int N;
    private static void bfs(char[][] map, boolean[][] visit, int x, int y, char target){
        if(x < 0 || N - 1 < x || y < 0 || N - 1 < y) return;
        if(visit[y][x]) return;
        if(map[y][x] == target){
            visit[y][x] = true;
            bfs(map, visit, x + 1, y, map[y][x]);
            bfs(map, visit, x, y + 1, map[y][x]);
            bfs(map, visit, x - 1, y, map[y][x]);
            bfs(map, visit, x, y - 1, map[y][x]);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        char[][] map = new char[N][N];
        char[][] map2 = new char[N][N];
        boolean[][] visit = new boolean[N][N];
        boolean[][] visit2 = new boolean[N][N];
        for(int i = 0 ; i < N ; i ++){
            String str = bf.readLine();
            for(int j = 0 ; j < N ; j ++) {
                map[i][j] = str.charAt(j);
                map2[i][j] = str.charAt(j) == 'G' ? 'R' : str.charAt(j);
            }
        }
        int ans = 0;
        int ans2 = 0;
        for(int i = 0 ; i < N ; i ++){
            for(int j = 0 ; j < N ; j ++){
                if(!visit[i][j]) {
                    bfs(map, visit, j, i, map[i][j]);
                    ans ++;
                }
                if(!visit2[i][j]){
                    bfs(map2, visit2, j, i, map2[i][j]);
                    ans2 ++;
                }
            }
        }
        System.out.println(ans + " " + ans2);
    }
}
