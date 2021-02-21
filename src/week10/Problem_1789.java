package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(bf.readLine());

        long start = 1;
        long sum = 0;
        int answer = 0;

        while(true){
            sum += start ++;
            answer ++;

            if(sum > S){
                answer --;
                break;
            }
        }
        System.out.println(answer);
    }
}
