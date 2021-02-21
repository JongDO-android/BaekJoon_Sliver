import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//트리의 지름
public class Problem_1967 {
    private static int max, far;
    private static ArrayList<ArrayList<Node>> graph;
    private static class Node{
        int n;
        int w;
        private Node(int n, int w){
            this.n = n;
            this.w = w;
        }
    }
    private static void dfs(boolean[] visit, int n, int val){
        ArrayList<Node> list = graph.get(n);
        for(Node node : list){
            if(!visit[node.n]){
                visit[node.n] = true;
                dfs(visit, node.n, val + node.w);
                visit[node.n] = false;
            }
        }
        if(max < val){
            max = val;
            far = n;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        graph = new ArrayList<>();
        max = 0;
        for(int i = 0 ; i < N ; i ++) graph.add(new ArrayList<>());
        for(int i = 0 ; i < N - 1 ; i ++){
            String[] s = bf.readLine().split(" ");
            int p = Integer.parseInt(s[0]);
            int c = Integer.parseInt(s[1]);
            int w = Integer.parseInt(s[2]);
            graph.get(p - 1).add(new Node(c - 1, w));
            graph.get(c - 1).add(new Node(p - 1, w));
        }
        boolean[] visit = new boolean[N];
        visit[0] = true;
        dfs(visit, 0, 0);

        visit = new boolean[N];
        visit[far] = true;
        dfs(visit, far, 0);
        System.out.println(max);
    }
}
