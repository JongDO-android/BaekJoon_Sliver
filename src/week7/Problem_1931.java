package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Problem_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] time = new int[N][2];
        for(int i = 0 ; i < N ; i ++){
            String[] s = bf.readLine().split(" ");
            time[i][0] = Integer.parseInt(s[0]);
            time[i][1] = Integer.parseInt(s[1]);
        }
        Arrays.sort(time, (o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            else return o1[1] - o2[1];
        });

        int end = time[0][1];
        int answer = 1;
        for(int i = 1 ; i < N ; i ++) {
            if(end <= time[i][0]){
                end = time[i][1];
                answer ++;
            }
        }
        System.out.println(answer);
    }
}
