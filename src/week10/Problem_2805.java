package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bf.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int wood = Integer.parseInt(input[1]);
        int[] woods = new int[N];

        input = bf.readLine().split(" ");
        for(int i = 0 ; i < N ; i ++) woods[i] = Integer.parseInt(input[i]);

        Arrays.sort(woods);
        int min = 0;
        int max = woods[N - 1];

        while(min <= max){
            int mid = (min + max) / 2;
            long count = 0;

            for(int w : woods) if(w > mid) count += w - mid;

            if(count < wood) max = mid - 1;
            else min = mid + 1;
        }
        System.out.println(max);
    }
}
