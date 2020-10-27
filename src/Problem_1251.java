import java.util.Scanner;

public class Problem_1251 {
    public static void main(String[] args){
        String s = new Scanner(System.in).nextLine();
        StringBuilder sb = new StringBuilder();
        int idx ;
        int cnt = 2;
        char min;
        while(cnt >= 0){
            min = 'z';
            idx = 0;
            for(int i = 0 ; i < s.length() - cnt ; i ++){
                char c = s.charAt(i);
                if(min >= c){
                    min = c;
                    idx = i;
                }
            }
            sb.append(new StringBuffer(s.substring(0, idx + 1)).reverse());
            s = s.substring(idx + 1);
            System.out.println(sb.toString());
            cnt --;
        }
    }
}
