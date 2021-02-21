package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_1865 {
    private static int N, M, W;
    private static int[][] edge;
    private static int[] dist;
    private static boolean bellmanFord(){
        int INF = 10000 * N;
        Arrays.fill(dist, INF);
        dist[1] = 0;
        for(int i = 1 ; i < N + 1 ; i ++){
            for(int j = 0 ; j < 2 * M + W ; j ++){
                int curCity = edge[j][0];
                int nextCity = edge[j][1];
                int time = edge[j][2];

                if(dist[curCity] != INF){
                    dist[nextCity] = Math.min(dist[nextCity], dist[curCity] + time );
                }
            }
        }
        for (int[] e : edge) {
            int curCity = e[0];
            int nextCity = e[1];
            int time = e[2];

            if (dist[curCity] != INF && dist[nextCity] > dist[curCity] + time) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(bf.readLine());

        for(int i = 0 ; i < TC ; i ++){
            String[] s = bf.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            M = Integer.parseInt(s[1]);
            W = Integer.parseInt(s[2]);
            edge = new int[2 * M + W][3];
            dist = new int[N + 1];
            for(int j = 0 ; j < 2 * M ; j += 2){
                s = bf.readLine().split(" ");
                int n1 = Integer.parseInt(s[0]);
                int n2 = Integer.parseInt(s[1]);
                int time = Integer.parseInt(s[2]);
                edge[j][0] = n1;
                edge[j][1] = n2;
                edge[j][2] = time;

                edge[j + 1][0] = n2;
                edge[j + 1][1] = n1;
                edge[j + 1][2] = time;
            }
            for(int j = 2 * M ; j < 2 * M + W ; j ++){
                s = bf.readLine().split(" ");
                int n1 = Integer.parseInt(s[0]);
                int n2 = Integer.parseInt(s[1]);
                int time = -Integer.parseInt(s[2]);
                edge[j][0] = n1;
                edge[j][1] = n2;
                edge[j][2] = time;
            }
            if(bellmanFord()) System.out.println("YES");
            else System.out.println("NO");

        }
    }
}
