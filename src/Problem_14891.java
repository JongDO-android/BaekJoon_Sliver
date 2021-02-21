import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_14891 {
    private static String[] gears;
    private static void Rotate(boolean[] visit, int num, int dir){
        if(visit[num]) return;
        visit[num] = true;
        if(num != 3) if(gears[num].charAt(2) != gears[num + 1].charAt(6)) Rotate(visit, num + 1, 0 - dir);
        if(num != 0) if(gears[num].charAt(6) != gears[num - 1].charAt(2)) Rotate(visit, num - 1, 0 - dir);

        if(dir == 1) gears[num] = gears[num].charAt(7) + gears[num].substring(0, 7);
        else gears[num] = gears[num].substring(1) + gears[num].charAt(0);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        gears = new String[4];
        for(int i = 0 ; i < 4 ; i ++) gears[i] = bf.readLine();
        int K = Integer.parseInt(bf.readLine());
        for(int i = 0 ; i < K ; i ++){
            String[] rotate = bf.readLine().split(" ");
            boolean[] visit = new boolean[4];
            int num = Integer.parseInt(rotate[0]) - 1;
            int dir = Integer.parseInt(rotate[1]);
            Rotate(visit, num, dir);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 3 ; i >= 0 ; i --) sb.append(gears[i].charAt(0));
        System.out.println(Integer.parseInt(sb.toString(), 2));
    }
}
