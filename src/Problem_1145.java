import java.util.Scanner;
// 적어도 대부분의 배수
public class Problem_1145 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] num = new int[5];
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < 5 ; i ++) num[i] = scanner.nextInt();

        for(int i = 0 ; i < 5 ; i ++){
            int val = num[i];
            for(int j = i + 1 ; j < 5 ; j ++){
                int val2 = num[j];
                for(int k = j + 1 ; k < 5 ; k ++) {
                    int l1 = (val * val2) / gcd(val, val2);
                    int l2 = (l1 * num[k]) / gcd(l1, num[k]);

                    if(min > l2) min = l2;
                }
            }
        }
        System.out.println(min);
    }
    private static int gcd(int n, int m){
        if(n % m != 0) return gcd(m, n % m);
        else return m;
    }
}
