import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = bf.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        String[] st = bf.readLine().split(" ");
        int[] trees = new int[N];
        for(int i = 0 ; i < N ; i ++) trees[i] = Integer.parseInt(st[i]);
        Arrays.sort(trees);
        int r = trees[N - 1];
        int l = 0;
        int mid;
        while(l <= r){
            mid = (l + r) / 2;
            long woods = 0;
            for(int i = 0 ; i < N ; i ++) woods += trees[i] - mid < 0 ? 0 : trees[i] - mid;
            if(woods < M) r = mid - 1;
            else l = mid + 1;
        }
        System.out.println(r);
    }
}
