package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2503 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] input = new int[N][5];
        int ans = 0;
        for(int i = 0 ; i < N ; i ++){
            String[] s = bf.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            input[i][0] = n / 100;
            input[i][1] = (n % 100) / 10;
            input[i][2] = n % 10;
            input[i][3] = Integer.parseInt(s[1]);
            input[i][4] = Integer.parseInt(s[2]);
        }

        for(int i = 123 ; i < 988 ; i ++){
            int hun = i / 100;
            int ten = (i % 100) / 10;
            int one = i % 10;
            if(hun == ten || ten == one || hun == one) continue;
            if(one == 0 || ten == 0) continue;

            int s;
            int b;
            boolean ac = false;
            for(int j = 0 ; j < N ; j ++){
                s = 0;
                b = 0;
                if(hun == input[j][0]) s ++;
                else if(hun == input[j][1] || hun == input[j][2]) b ++;

                if(ten == input[j][1]) s ++;
                else if(ten == input[j][0] || ten == input[j][2]) b ++;

                if(one == input[j][2]) s ++;
                else if(one == input[j][0] || one == input[j][1]) b ++;

                if(s != input[j][3] || b != input[j][4]) {
                    ac = true;
                    break;
                }
            }
            if(!ac) ans ++;
        }
        System.out.println(ans);
    }
}
