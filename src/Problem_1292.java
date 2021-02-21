import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int start = Integer.parseInt(s[0]);
        int end = Integer.parseInt(s[1]);
        int row = 1;
        int idx = 1;
        int val = 0;
        while(idx < start){
            idx += row;
            row ++;
        }
        val += (idx - start) * (row - 1);
        while(idx <= end){
            val += row * row;
            idx += row;
            row ++;
        }
        val -= (idx - end - 1) * (row - 1);
        System.out.println(val);
    }
}
