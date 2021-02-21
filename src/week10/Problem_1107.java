package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Problem_1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        int min = Math.abs(N - 100);

        HashSet<Integer> set = new HashSet<>();
        if(M != 0) {
            String[] input = bf.readLine().split(" ");
            for(int i = 0 ; i < M ; i ++) set.add(Integer.parseInt(input[i]));
        }
        for(int i = 0 ; i < 1000001 ; i ++){
            String val = Integer.toString(i);
            boolean b = false;

            for(Integer j : set){
                String v = Integer.toString(j);
                if(val.contains(v)){
                    b = true;
                    break;
                }
            }
            if(!b){
                min = Math.min(min, Math.abs(i - N) + val.length());
            }

        }
        System.out.println(min);
    }
}
