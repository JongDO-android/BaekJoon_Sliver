import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1347 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int dir = 0;
        int N = Integer.parseInt(bf.readLine());
        String route = bf.readLine();
        StringBuilder map = new StringBuilder();
        map.append(".");
        for(int i = 0 ; i < N ; i ++){
            if(route.charAt(i) == 'R') dir = dir + 1 < 4 ? dir + 1 : 0;
            else if(route.charAt(i) == 'L') dir = dir - 1 < 0 ? 3 : dir - 1;
            else{
                if(dir == 0) map.append("\n.");
                else if(dir == 1) map.append(".");
                else if(dir == 2) map.append(".\n");
                else map.append(".");
                dir = 0;
            }
        }
        System.out.println(map.toString());
    }
}
