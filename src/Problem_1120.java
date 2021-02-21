import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] AB = bf.readLine().split(" ");
        String A = AB[0];
        String B = AB[1];
        int range = B.length() - A.length();
        int min = B.length();
        for(int i = 0 ; i <= range ; i ++){
            String temp = B.substring(i, i + A.length());
            int count = 0;
            if(temp.equals(A)){
                min = 0;
                break;
            }
            for(int j = 0 ; j < A.length() ; j ++) if(A.charAt(j) != temp.charAt(j)) count ++;
            if(count < min) min = count;
        }
        System.out.println(min);
    }
}
