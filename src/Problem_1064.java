import java.util.Scanner;

// 평행사변형
public class Problem_1064 {
    private static double getInclination(int x1, int y1, int x2, int y2){
        if(x2 - x1 == 0) return 0;
        return (double) (y2 - y1) / (double) (x2 - x1);
    }
    private static double getDistance(int x1, int y1, int x2, int y2){
        int side1 = Math.abs(x2 - x1);
        int side2 = Math.abs(y2 - y1);
        return Math.sqrt(side1 * side1 + side2 * side2);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[][] point = new int[3][2];
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for(int i = 0 ; i < 3 ; i ++){
            point[i][0] = scanner.nextInt();
            point[i][1] = scanner.nextInt();
        }
        double inc1 = getInclination(point[0][0], point[0][1], point[1][0], point[1][1]);
        double inc2 = getInclination(point[1][0], point[1][1], point[2][0], point[2][1]);

        if(inc1 == inc2) System.out.println(-1);
        else{
            for(int i = 0 ; i < 3 ; i ++){
                double round = 0.0;
                int x1 = point[i][0];
                int y1 = point[i][1];
                for(int j = 0 ; j < 3 ; j ++){
                    int x2 = point[j][0];
                    int y2 = point[j][1];
                    if(i == j) continue;
                    round += getDistance(x1, y1, x2, y2);
                }
                round *= 2;
                if(min > round) min = round;
                if(max < round) max = round;
            }
            System.out.println(max - min);
        }
    }
}
