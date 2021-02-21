import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1012 {
    private static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for(int i = 0 ; i < T ; i ++){
            String[] s = bf.readLine().split(" ");
            M = Integer.parseInt(s[0]);
            N = Integer.parseInt(s[1]);
            int B = Integer.parseInt(s[1]);
            boolean[][] farm = new boolean[N][M];
            for(int j = 0 ; j < B ; j ++) {
                s = bf.readLine().split(" ");
            }
        }
    }
}
