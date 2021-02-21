package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem_17297 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(bf.readLine());

        ArrayList<Integer> mg = new ArrayList<>();
        mg.add(5);
        mg.add(13);

        int pre = 5;
        int cur = 13;

        while(cur < M){
            int temp = cur;
            cur += pre + 1;
            pre = temp;

            mg.add(cur);
        }
        for(int i = mg.size() - 1 ; i > 1 ; i --){
            if(mg.get(i - 1) + 1 < M){
                M -= (mg.get(i - 1) + 1);
                i --;
            }
            else if(mg.get(i - 1) + 1 == M) {
                System.out.println("Messi Messi Gimossi");
                return;
            }
        }
        String s = "Messi Gimossi";
        if(s.charAt(M - 1) == ' ') System.out.println("Messi Messi Gimossi");
        else System.out.println(s.charAt(M - 1));
    }
}
