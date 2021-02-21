package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 골드바흐의 추측
public class Problem_9020 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        boolean[] prime = new boolean[10001];
        for(int i = 2 ; i < 10001 ; i ++){
            if(prime[i]) continue;
            for(int j = 2 * i ; j < 10001 ; j += i) prime[j] = true;
        }
        for(int i = 0 ; i < T ; i ++) {
            int n = Integer.parseInt(bf.readLine());
            int n1 = n / 2;
            int n2 = n / 2;
            while(prime[n1] || prime[n2]){
                n1 --;
                n2 ++;
            }
            System.out.println(n1 + " " + n2);
        }
    }
}
