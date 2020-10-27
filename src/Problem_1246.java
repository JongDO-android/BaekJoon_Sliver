import java.util.Arrays;
import java.util.Scanner;
// 온라인 판매
public class Problem_1246 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int max = Integer.MIN_VALUE;
        int A = 0;
        int[] ary = new int[M];
        for(int i = 0 ; i < M ; i ++) ary[i] = scanner.nextInt();
        Arrays.sort(ary);
        for(int i = 0 ; i < M ; i ++){
            int count = M - i <= N ? M - i : N;
            int val = ary[i] * count;
            if(max < val) {
                max = val;
                A = ary[i];
            }
        }
        System.out.println(A + " " + max);
    }
}
