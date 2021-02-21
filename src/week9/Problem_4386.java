package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Problem_4386 {
    static class Point{
        double x;
        double y;
        Point(double x, double y){
            this.x = x;
            this.y = y;
        }
    }
    static class Edge implements Comparable<Edge>{
        int n1;
        int n2;
        double dis;
        Edge(int n1, int n2, double dis){
            this.n1 = n1;
            this.n2 = n2;
            this.dis = dis;
        }

        @Override
        public int compareTo(Edge o) {
            if(o.dis > this.dis) return -1;
            else return 1;
        }
    }
    private static int find(int[] parent, int n){
        if(parent[n] == n) return n;
        else return parent[n] = find(parent, parent[n]);
    }
    static void union(int[] parent, int n1, int n2){
        n1 = find(parent, n1);
        n2 = find(parent, n2);
        if(n1 < n2) parent[n2] = n1;
        else parent[n1] = n2;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] parent = new int[N];
        Point[] stars = new Point[N];
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i = 0 ; i < N ; i ++){
            parent[i] = i;
            String[] input = bf.readLine().split(" ");
            double x = Double.parseDouble(input[0]);
            double y = Double.parseDouble(input[1]);

            stars[i] = new Point(x, y);
            Point p1 = stars[i];
            for(int j = 0 ; j < i ; j ++){
                Point p2 = stars[j];
                edges.add(new Edge(i, j, Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2))));
            }
        }
        Collections.sort(edges);
        double answer = 0.0;
        int count = 0;
        for(Edge e : edges){
            int n1 = find(parent, e.n1);
            int n2 = find(parent, e.n2);

            if(n1 != n2){
                union(parent, e.n1, e.n2);
                answer += e.dis;
                count ++;
                if(count == N - 1) break;
            }
        }
        System.out.println(String.format("%.2f", answer));

    }
}
