import java.util.Scanner;

// 빗물
public class Problem_14719 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int temp = 0;
        int answer = 0;
        for(int i = 0 ; i < col ; i ++){
            int height = scanner.nextInt();
            if(temp <= height) temp = height;
            else answer += temp - height;
        }
        System.out.println(answer);
    }
}
