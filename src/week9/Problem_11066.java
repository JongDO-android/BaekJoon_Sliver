package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_11066 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for(int i = 0 ; i < T ; i ++){
            int N = Integer.parseInt(bf.readLine());
            String[] input = bf.readLine().split(" ");
            int[] data = new int[N];
            for(int j = 0 ; j < N ; j ++) data[j] = Integer.parseInt(input[j]);

        }
    }
}
