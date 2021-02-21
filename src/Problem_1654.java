import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim(), " ");
        int K = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());
        int[] ary = new int[K];
        for(int i = 0 ; i < K ; i ++) ary[i] = Integer.parseInt(bf.readLine());
        long r = ary[K - 1];
        long l = 1;
        long mid;
        Arrays.sort(ary);
        while(l <= r){
            mid = (l + r) / 2;
            long num = 0;
            for(int i = 0 ; i < K ; i ++) num += ary[i] / mid;
            if(num >= len) l = mid + 1;
            else r = mid - 1;

        }
        System.out.println(r);
    }
}
