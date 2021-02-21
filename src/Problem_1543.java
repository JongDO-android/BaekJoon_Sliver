import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        String target = bf.readLine();
        int len = s.length();
        s = s.replaceAll(target, "");
        System.out.println((len - s.length()) / target.length());
    }
}
