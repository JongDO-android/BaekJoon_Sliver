package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Z
public class Problem_1074 {
    private static int r, c, l1, l2, r1, r2;
    private static void find(int N, int quad){
        if(N == 0) {
            System.out.println(quad);
            return;
        }
        int mr = (l1 + r1) / 2;
        int mc = (l2 + r2) / 2;

        int val = 0;
        int val2 = (int) Math.pow(4, N - 1);
        if(r < mr) {
            r1 = mr;
            if(c < mc) r2 = mc;
            else {
                val = 1;
                l2 = mc;
            }
        }
        else{
            l1 = mr;
            if(c < mc) {
                val = 2;
                r2 = mc;
            }
            else {
                val = 3;
                l2 = mc;
            }
        }
        find(N - 1, quad + val * val2);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        r = Integer.parseInt(s[1]);
        c = Integer.parseInt(s[2]);
        l1 = 0;
        l2 = 0;

        r1 = (int) Math.pow(2, N);
        r2 = (int) Math.pow(2, N);

        find(N, 0);
    }
}
