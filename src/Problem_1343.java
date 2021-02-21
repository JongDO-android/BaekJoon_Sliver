import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String target = bf.readLine() + ".";
        String A = "AAAA";
        String B = "BB";
        StringBuilder sb = new StringBuilder();
        int len = 0;
        boolean b = false;
        for(int i = 0 ; i < target.length() ; i ++){
            if(target.charAt(i) == 'X') len ++;
            else{
                while(len >= 4) {
                    sb.append(A);
                    len -= 4;
                }
                while(len >= 2){
                    sb.append(B);
                    len -= 2;
                }
                if(len != 0) {
                    System.out.println(-1);
                    b = true;
                    break;
                }
                sb.append('.');
            }
        }
        if(!b) System.out.println(sb.toString().substring(0, sb.length() - 1));
    }
}
