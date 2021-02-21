import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
// 창고 다각형
public class Problem_2304 {
    public static class Point implements Comparable<Point>{
        int x;
        int y;
        private Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return this.x < o.x ? -1 : 1;
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int max_y = 0;
        int index = 0;
        int answer = 0;
        ArrayList<Point> list = new ArrayList<>();
        for(int i = 0 ; i < N ; i ++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            list.add(new Point(x, y));
        }
        Collections.sort(list);
        for(int i = 0 ; i < N ; i ++){
            if(max_y <= list.get(i).y){
                max_y = list.get(i).y;
                index = i;
            }
        }
        int temp_x = list.get(0).x;
        int temp_y = list.get(0).y;
        for(int i = 1 ; i <= index ; i ++){
            if(temp_y <= list.get(i).y){
                answer += (list.get(i).x - temp_x) * temp_y;
                temp_x = list.get(i).x;
                temp_y = list.get(i).y;
            }
        }
        temp_x = list.get(list.size() - 1).x;
        temp_y = list.get(list.size() - 1).y;
        for(int i = N - 2 ; i >= index ; i --){
            if(temp_y <= list.get(i).y){
                answer += (temp_x - list.get(i).x) * temp_y;
                temp_x = list.get(i).x;
                temp_y = list.get(i).y;
            }
        }
        answer += max_y;
        System.out.println(answer);
    }
}
