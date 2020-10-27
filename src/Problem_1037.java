import java.util.Scanner;
import java.util.Arrays;
// 약수
public class Problem_1037 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] ary = new int[sc.nextInt()];

        for(int i = 0 ; i < ary.length ; i ++) ary[i] = sc.nextInt();
        Arrays.sort(ary);
        long answer = ary[0] * ary[ary.length - 1];
        System.out.println(answer);
    }
}
