package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Problem_1774 {
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o){
            Point p = (Point) o;
            return this.x == p.x && this.y == p.y;
        }
    }
    static class Edge implements Comparable<Edge>{
        Point p1;
        Point p2;
        double dis;
        Edge(Point p1, Point p2, double dis){
            this.p1 = p1;
            this.p2 = p2;
            this.dis = dis;
        }

        @Override
        public int compareTo(Edge e) {
            if(this.dis > e.dis) return 1;
            else return -1;
        }
    }
    private static int getParent(int[] parent, int n){
        if(n == parent[n]) return n;
        else return parent[n] = getParent(parent, parent[n]);
    }
    private static void union(int[] parent, int n1, int n2){
        n1 = getParent(parent, n1);
        n2 = getParent(parent, n2);
        if(n1 != n2){
            if(n1 < n2) parent[n2] = n1;
            else parent[n1] = n2;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[] parent = new int[N];
        ArrayList<Edge> edges = new ArrayList<>();
        ArrayList<Point> lst = new ArrayList<>();

        for(int i = 0 ; i < N ; i ++) parent[i] = i;

        for(int i = 0 ; i < N ; i ++){
            input = bf.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            Point p1 = new Point(x, y);
            lst.add(p1);
            for(int j = 0 ; j < i ; j ++){
                Point p2 = lst.get(j);
                edges.add(new Edge(p1, p2, Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2))));
            }
        }
        for(int i = 0 ; i < M ; i ++){
            input = bf.readLine().split(" ");
            int n1 = Integer.parseInt(input[0]) - 1;
            int n2 = Integer.parseInt(input[1]) - 1;

            union(parent, n1, n2);
        }
        Collections.sort(edges);
        int count = 0;
        double answer = 0.0;
        for(Edge e : edges){
            int n1 = lst.indexOf(e.p1);
            int n2 = lst.indexOf(e.p2);

            if(getParent(parent, n1) != getParent(parent, n2)){
                union(parent, n1, n2);
                count ++;
                answer += e.dis;
            }
            if(count == N - 1) break;
        }
        System.out.println(String.format("%.2f", answer));
    }
}
