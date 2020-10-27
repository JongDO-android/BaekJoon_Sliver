import java.util.PriorityQueue;
import java.util.Scanner;
public class Problem_1059 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int T = sc.nextInt();
        for(int i = 0 ; i < T ; i ++) pq.add(sc.nextInt());
        int N = sc.nextInt();
        int sm = 0;
        int big = 0;
        while(!pq.isEmpty()){
            int small = pq.poll();
            if(N < small) {
                big = small;
                break;
            }
            else sm = small;
        }
        System.out.println(getCount(sm, big, N));
    }
    private static int getCount(int small, int big, int N){
        int s_gap = N - small - 1;
        int b_gap = big - N;

        return s_gap * b_gap + (big - N - 1);
    }
}
