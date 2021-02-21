package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_1463 {
    static class toOne{
        int num;
        int count;
        toOne(int num, int count){
            this.num = num;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        Queue<toOne> q = new LinkedList<>();
        q.offer(new toOne(N, 0));
        while(!q.isEmpty()){
            toOne val = q.poll();
            if(val.num == 1) {
                System.out.println(val.count);
                break;
            }
            int num = val.num;
            int count = val.count;

            if(num % 3 == 0) q.offer(new toOne(num / 3, count + 1));
            if(num % 2 == 0) q.offer(new toOne(num / 2, count + 1));
            q.offer(new toOne(num - 1, count + 1));
        }
    }
}
