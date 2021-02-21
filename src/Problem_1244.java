import java.util.Scanner;
//스위치
public class Problem_1244 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        boolean[] swiches = new boolean[N];
        for(int i = 0 ; i < N ; i ++) swiches[i] = scanner.nextInt() != 0;
        int T = scanner.nextInt();
        for(int i = 0 ; i < T ; i ++){
            int gen = scanner.nextInt();
            int num = scanner.nextInt();

            if(gen == 1){
                int temp = num;
                while(temp <= N){
                    swiches[temp - 1] = !swiches[temp - 1];
                    temp += num;
                }
            }
            else if (gen == 2){
                swiches[num - 1] = !swiches[num - 1];
                if(1 < num && num < N){
                    int l = num - 2;
                    int r = num;
                    while(swiches[l] == swiches[r]){
                        swiches[l] = !swiches[l];
                        swiches[r] = !swiches[r];
                        l --;
                        r ++;
                        if(l < 0 || r > N - 1) break;
                    }
                }
            }
        }
        int count = 0;
        for(int i = 0 ; i < N ; i ++){
            if(count == 20) {
                System.out.println();
                count = 0;
            }
            System.out.print((swiches[i] ? 1 : 0) + " ");
            count ++;
        }
    }
}
