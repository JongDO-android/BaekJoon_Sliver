package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 리모콘
public class Problem_1107 {
    private static int num, MIN;
    private static boolean[] broken;
    private static StringBuilder sb;
    private static void dfs(){
        if(sb.length() > Integer.toString(num).length() + 1) return;
        for(int i = 0 ; i < 10 ; i ++){
            if(!broken[i]){
                sb.append(i);
                int val = Integer.parseInt(sb.toString());
                MIN = Math.min(MIN, Math.abs(num - val) + sb.length());
                dfs();
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s1 = bf.readLine();
        num = Integer.parseInt(s1);

        int N = Integer.parseInt(bf.readLine());
        MIN = Math.abs(100 - num);
        broken = new boolean[10];
        sb = new StringBuilder(0);

        if(N > 0){
            String[] s = bf.readLine().split(" ");
            for(int i = 0 ; i < N ; i ++) broken[Integer.parseInt(s[i])] = true;
        }
        dfs();
        System.out.println(MIN);
    }
}
