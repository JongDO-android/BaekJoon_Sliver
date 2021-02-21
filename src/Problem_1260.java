import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_1260 {
    private static boolean[] visit;
    private static int[][] graph;
    private static int N;
    private static void dfs(int start){
        System.out.print((start + 1) + " ");
        for(int i = 0 ; i < N ; i ++){
            if(graph[start][i] == 1 && !visit[i]){
                visit[i] = true;
                dfs(i);
            }
        }
    }
    private static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        visit = new boolean[N];
        visit[start] = true;
        q.offer(start);
        while(!q.isEmpty()) {
            int row = q.poll();
            System.out.print((row + 1) + " ");
            for(int i = 0 ; i < N ; i ++){
                if(graph[row][i] == 1 && !visit[i]){
                    visit[i] = true;
                    q.offer(i);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim(), " ");
        N = Integer.parseInt(st.nextToken());
        graph = new int[N][N];

        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
        visit[start - 1] = true;
        for(int i = 0 ; i < M ; i ++){
            st = new StringTokenizer(bf.readLine().trim(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph[v1-1][v2-1] = 1;
            graph[v2-1][v1-1] = 1;
        }
        dfs(start - 1);
        System.out.println();
        bfs(start - 1);
    }
}

