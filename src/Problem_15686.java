
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 치킨 배달
public class Problem_15686 {
    private static int N, M, min;
    private static ArrayList<Point> chicken, home, temp;
    private static class Point{
        int x;
        int y;
        private Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static void combination(int i1, int i2){
        if(i1 == M){
            int t_min = 0;
            for(Point pos : home){
                int m = Integer.MAX_VALUE;
                for(Point p : temp){
                    int val = Math.abs(pos.x - p.x) + Math.abs(pos.y - p.y);
                    if(val < m) m = val;
                }
                t_min += m;
            }
            min = Math.min(t_min, min);
            return;
        }
        for(int i = i2 ; i < chicken.size() ; i ++){
            temp.set(i1, chicken.get(i));
            combination(i1 + 1, i + 1);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        chicken = new ArrayList<>();
        home = new ArrayList<>();
        temp = new ArrayList<>();
        min = Integer.MAX_VALUE;

        for(int i = 0 ; i < M ; i ++) temp.add(new Point(0, 0));
        for(int i = 0 ; i < N ; i ++){
            s = bf.readLine().split(" ");
            for(int j = 0 ; j < N ; j ++) {
                int h = Integer.parseInt(s[j]);
                if(h == 2) chicken.add(new Point(j, i));
                else if(h == 1) home.add(new Point(j, i));
            }
        }
        combination(0, 0);
        System.out.println(min);
    }
}
