package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2263 {
    private static int[] in, post;
    private static void preOrder(int start, int end, int idx){
        if(start == end) return;
        System.out.print(post[idx] + " ");
        int index = -1;
        for(int i = start ; i < end ; i ++){
            if(post[idx] == in[i]){
                index = i;
                break;
            }
        }
        int l_root = idx - (end - index);
        int r_root = l_root + (end - index) - 1;
        if(l_root > r_root) return;
        preOrder(start, index, l_root);
        preOrder(index + 1, end, r_root);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        in = new int[N];
        post = new int[N];
        String[] s = bf.readLine().split(" ");
        for(int i = 0 ; i < N ; i ++) in[i] = Integer.parseInt(s[i]);

        s = bf.readLine().split(" ");
        for(int i = 0 ; i < N ; i ++) post[i] = Integer.parseInt(s[i]);
        preOrder(0, N, N - 1);
        System.out.println();
    }
}
