import java.util.Scanner;
//요세푸스 문제
public class Problem_1158 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int idx = 0;
        int count = 0;
        int shoot = 0;
        boolean[] kill = new boolean[N];
        System.out.print("<");
        while(true){
            if(kill[idx]) idx = (idx + 1) % N;
            else{
                if(count == K - 1){
                    kill[idx] = true;
                    System.out.print((idx+1));
                    count = 0;
                    shoot ++;
                    if(shoot == N) break;
                    else System.out.print(", ");
                }
                else {
                    idx = (idx + 1) % N;
                    count ++;
                }
            }
        }
        System.out.print(">");
    }
}
