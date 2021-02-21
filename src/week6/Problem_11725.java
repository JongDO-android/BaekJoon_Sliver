package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//트리의 부모 찾기
public class Problem_11725 {
    private static ArrayList<ArrayList<Integer>> graph;
    private static void dfs(boolean[] visit, int[] answer, int idx){
        ArrayList<Integer> list = graph.get(idx);
        for(Integer i : list) {
            if(!visit[i]){
                visit[i] = true;
                answer[i] = idx + 1;
                dfs(visit, answer, i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        graph = new ArrayList<>();
        int N = Integer.parseInt(bf.readLine());
        for(int i = 0 ; i < N ; i ++) graph.add(new ArrayList<>());

        for(int i = 0 ; i < N - 1 ; i ++){
            String[] s = bf.readLine().split(" ");
            int idx1 = Integer.parseInt(s[0]) - 1;
            int idx2 = Integer.parseInt(s[1]) - 1;

            graph.get(idx1).add(idx2);
            graph.get(idx2).add(idx1);
        }
        int[] answer = new int[N];
        boolean[] visit = new boolean[N];
        dfs(visit, answer, 0);
        for(int i = 1 ; i < N ; i ++) System.out.println(answer[i]);
    }
}
