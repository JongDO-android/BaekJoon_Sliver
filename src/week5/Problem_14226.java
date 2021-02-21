package week5;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem_14226 {
    private static int S;
    private static class emoticon implements Comparable<emoticon> {
        int n;
        int time;
        int copy;
        private emoticon(int n, int time, int copy){
            this.n = n;
            this.time = time;
            this.copy = copy;
        }

        @Override
        public int compareTo(emoticon e) {
            return this.time - e.time;
        }
    }
    private static int bfs(){
        PriorityQueue<emoticon> q = new PriorityQueue<>();
        q.add(new emoticon(1, 0, 0));
        boolean[][] visit = new boolean[2001][2001];
        visit[1][0] = true;
        visit[1][1] = true;
        int answer = 0;
        while(!q.isEmpty()){
            emoticon e = q.poll();
            if(e.n == S){
                answer = e.time;
                break;
            }
            if(e.n + e.n < 2 * S){
                if(!visit[e.n + e.n][e.n]){
                    visit[e.n + e.n][e.n] = true;
                    q.offer(new emoticon(e.n + e.n, e.time + 2, e.n));
                }
            }
            if(e.n + e.copy < 2 * S){
                if(!visit[e.n + e.copy][e.copy]){
                    visit[e.n + e.copy][e.copy] = true;
                    q.offer(new emoticon(e.n + e.copy, e.time + 1, e.copy));
                }
            }
            if(e.n - 1 > 0){
                if(!visit[e.n - 1][e.copy]){
                    visit[e.n - 1][e.copy] = true;
                    q.offer(new emoticon(e.n - 1, e.time + 1, e.copy));
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        S = sc.nextInt();
        System.out.println(bfs());
    }
}
