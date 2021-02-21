import java.util.Scanner;

public class Problem_1436 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long start = 666;
        String s = "666";
        int i = 0;
        while(i < N){
            if(Long.toString(start).contains(s)) i ++;
            start ++;
        }
        System.out.println(start-1);
    }
}
