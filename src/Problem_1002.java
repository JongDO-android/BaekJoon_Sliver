import java.util.Scanner;

public class Problem_1002 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for(int i = 0 ; i < T ; i++){
            int[] ary = new int[6];
            for(int j = 0 ; j < 6 ; j ++) ary[j] = scanner.nextInt();
            double dis = Math.sqrt(Math.pow(Math.abs(ary[0] - ary[3]), 2) + Math.pow(Math.abs(ary[1] - ary[4]), 2));
            double gap = (double) ary[2] + (double) ary[5];

            if(dis == 0) {
                if(ary[2] == ary[5]) System.out.println(-1);
                else System.out.println(0);
            }
            else System.out.println(dis < gap ? 2 : dis == gap ? 1 : 0);
        }
    }
}
