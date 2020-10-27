import java.util.Scanner;

// 킹
public class Problem_1063 {
    private static String k_pos;
    private static String s_pos;
    private static void move(int[] dir){
        char row = (char) ((int) k_pos.charAt(0) + dir[0]);
        char col = (char) ((int) k_pos.charAt(1) + dir[1]);

        if(row <'A' || 'H' < row || col < '1' || '8' < col) return;
        StringBuilder temp = new StringBuilder();
        StringBuilder temp2 = new StringBuilder();
        temp.append(row);
        temp.append(col);
        if(s_pos.equals(temp.toString())){
            char row2 = (char) ((int) s_pos.charAt(0) + dir[0]);
            char col2 = (char) ((int) s_pos.charAt(1) + dir[1]);
            if(row2 <'A' || 'H' < row2 || col2 < '1' || '8' < col2) return;

            temp2.append(row2);
            temp2.append(col2);
            s_pos = temp2.toString();
        }
        k_pos = temp.toString();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        k_pos = input.split(" ")[0];
        s_pos = input.split(" ")[1];
        int N = Integer.parseInt(input.split(" ")[2]);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i ++) {
            sb.append(sc.nextLine());
            sb.append(" ");
        }

        int[] dir = new int[2];
        for(int i = 0 ; i < sb.length() ; i ++){
            char move = sb.charAt(i);
            if(move == ' ') {
                move(dir);
                dir = new int[2];
                continue;
            }
            switch(move){
                case 'B':
                    dir[1] = -1;
                    break;
                case 'T':
                    dir[1] = 1;
                    break;
                case 'L':
                    dir[0] = -1;
                    break;
                case 'R':
                    dir[0] = 1;
                    break;
            }
        }
        System.out.println(k_pos);
        System.out.println(s_pos);
    }
}
