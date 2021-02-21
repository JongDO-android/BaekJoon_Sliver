import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_1759{
    private static char[] words;
    private static int L, C, vnum, cnum;
    private static StringBuilder sb;
    private static boolean isVowel(int c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    private static void combination(boolean[] visit, int idx){
        for(int i = idx ; i < C ; i ++){
            sb.append(words[i]);
            if(isVowel(words[i])) vnum ++;
            else cnum ++;

            combination(visit, i + 1);

            sb.deleteCharAt(sb.length() - 1);
            if(isVowel(words[i])) vnum --;
            else cnum --;
        }
        if(sb.length() == L) {
            if(vnum > 0 && cnum > 1) System.out.println(sb);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        L = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);

        s = bf.readLine().split(" ");
        sb = new StringBuilder();
        words = new char[C];
        boolean[] visit = new boolean[C];
        for(int i = 0 ; i < C ; i ++) words[i] = s[i].charAt(0);
        Arrays.sort(words);
        combination(visit, 0);
    }
}
