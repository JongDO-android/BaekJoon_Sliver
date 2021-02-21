import java.util.ArrayList;
import java.util.Scanner;

public class Problem_9095 {
    private static int dp(int n, int target){
        if(n > target) return 0;
        else if(n == target) return 1;
        return dp(n + 1, target) + dp(n + 2, target) + dp(n + 3, target);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i = 0 ; i < T ; i ++) System.out.println(dp(0, scanner.nextInt()));

    }
}
