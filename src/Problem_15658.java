import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//실버 3 - 연산자 끼워넣기(2)
public class Problem_15658 {
    private static int N, MAX, MIN;
    private static int[] nums, opers;
    private static void permutation(int r, int val){
        if(r == N - 1) {
            MAX = Math.max(MAX, val);
            MIN = Math.min(MIN, val);
            return;
        }
        for(int i = 0 ; i < 4 ; i ++){
            if(opers[i] == 0) continue;
            switch (i){
                case 0 :
                    opers[i] --;
                    permutation(r + 1, val + nums[r + 1]);
                    opers[i] ++;
                    break;
                case 1 :
                    opers[i] --;
                    permutation(r + 1, val - nums[r + 1]);
                    opers[i] ++;
                    break;
                case 2 :
                    opers[i] --;
                    permutation(r + 1, val * nums[r + 1]);
                    opers[i] ++;
                    break;
                case 3 :
                    opers[i] --;
                    permutation(r + 1, val / nums[r + 1]);
                    opers[i] ++;
                    break;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        nums = new int[N];
        opers = new int[4];
        MAX = Integer.MIN_VALUE;
        MIN = Integer.MAX_VALUE;
        String[] n_str = bf.readLine().split(" ");
        for(int i = 0 ; i < N ; i ++) nums[i] = Integer.parseInt(n_str[i]);

        n_str = bf.readLine().split(" ");
        for(int i = 0 ; i < 4 ; i ++) opers[i] = Integer.parseInt(n_str[i]);

        permutation(0, nums[0]);
        System.out.println(MAX);
        System.out.println(MIN);
    }
}
