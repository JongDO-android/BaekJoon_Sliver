package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_1389 {
    private static class friend{
        int num;
        int dis;
        friend(int num, int dis){
            this.num = num;
            this.dis = dis;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bf.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        boolean[][] relation = new boolean[N][N];
        for(int i = 0 ; i < M ; i ++){
            input = bf.readLine().split(" ");
            int r1 = Integer.parseInt(input[0]) - 1;
            int r2 = Integer.parseInt(input[1]) - 1;

            relation[r1][r2] = true;
            relation[r2][r1] = true;
        }
        int answer = 0;
        int min = 6 * N;
        for(int i = 0 ; i < N ; i ++){
            Queue<friend> q = new LinkedList<>();
            boolean[] visit = new boolean[N];
            visit[i] = true;
            int val = 0;

            for(int j = 0 ; j < N ; j ++) {
                if(relation[i][j]) {
                    visit[j] = true;
                    q.offer(new friend(j, 1));
                }
            }
            while(!q.isEmpty()){
                friend f = q.poll();
                val += f.dis;

                for(int j = 0 ; j < N ; j ++){
                    if(relation[f.num][j] && !visit[j]){
                        visit[j] = true;
                        q.offer(new friend(j, f.dis + 1));
                    }
                }
            }
            if(min > val){
                answer = i + 1;
                min = val;
            }
        }
        System.out.println(answer);
    }
}
