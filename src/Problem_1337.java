import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1337 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] ary = new int[N];
        int min = 4;
        for(int i = 0 ; i < N ; i ++) ary[i] = Integer.parseInt(bf.readLine());
        for(int i = 0 ; i < N ; i ++){
            int l = 0;
            int r = 0;
            for(int j = 0 ; j < N ; j ++){
                if(ary[i] < ary[j] && ary[j] < ary[i] + 5) r ++;
                else if(ary[i] - 5 < ary[j] && ary[j] < ary[i]) l ++;
            }
            int val = Math.min(4 - r, 4 - l);
            if(val < min) min = val;
        }
        System.out.println(min);
    }
}
