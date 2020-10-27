import java.util.Scanner;
// 막대기
public class Problem_1094 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        System.out.println(Integer.toBinaryString(target).replace("0","").length());
    }
}
