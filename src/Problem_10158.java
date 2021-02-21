import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 개미
public class Problem_10158 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int W, H, x, y, T;
        String line = bf.readLine();
        W = Integer.parseInt(line.split(" ")[0]);
        H = Integer.parseInt(line.split(" ")[1]);
        line = bf.readLine();
        x = Integer.parseInt(line.split(" ")[0]);
        y = Integer.parseInt(line.split(" ")[1]);
        T = Integer.parseInt(bf.readLine());

        x = (x + T) % (2 * W);
        y = (y + T) % (2 * H);
        if(W < x) x = 2 * W - x;
        if(H < y) y = 2 * H - y;
        System.out.println(x + " " + y);
    }
}