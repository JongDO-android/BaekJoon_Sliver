package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bf.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);
        int[] home = new int[N];


        for(int i = 0 ; i < N ; i ++){
            home[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(home);
        int left = 1;
        int right = home[N - 1] - home[0];

        while(left <= right){
            int mid = (left + right) / 2;
            int count = 1;
            int val = home[0];

            for(int h : home){
                if(h - val >= mid){
                    count ++;
                    val = h;
                }
            }
            if(count >= C) left = mid + 1;
            else right = mid - 1;

        }
        System.out.println(right);
    }
}
