import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_1197 {
    private static int[] parent;
    private static int getParent(int val){
        if(val == parent[val]) return val;
        parent[val] = getParent(parent[val]);
        return parent[val];
    }
    private static void union(int val1, int val2){
        int root1 = getParent(val1);
        int root2 = getParent(val2);
        if(root1 != root2) parent[root1] = val2;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim(), " ");
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int[][] graph = new int[E][3];
        parent = new int[N + 1];
        for(int i = 1 ; i <= N ; i ++) parent[i] = i;
        for(int i = 0 ; i < E ; i ++) {
            st = new StringTokenizer(bf.readLine().trim(), " ");
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(graph, (int[] i1, int[] i2) -> i1[2] - i2[2]);
        int w = 0;
        for(int[] i : graph) {
            int i1 = getParent(i[0]);
            int i2 = getParent(i[1]);
            if(i1 == i2) continue; // Cycle
            w += i[2];
            union(i1, i2);
        }
        System.out.println(w);
    }
}
