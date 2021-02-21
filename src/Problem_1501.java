import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Problem_1501 {
    private static Set<String> set;
    private static Set<String> set2;
    private static int count;

    private static void find(char[] word, int idx, int r){
        if(idx == r) {
            String nword = String.valueOf(word);
            if(set.contains(nword) && !set2.contains(nword)){
                count ++;
                set2.add(nword);
            }
            return;
        }
        for(int i = idx ; i < word.length - 1 ; i ++){
            char temp = word[idx];
            word[idx] = word[i];
            word[i] = temp;

            find(word, idx + 1, r);

            temp = word[i];
            word[i] = word[idx];
            word[idx] = temp;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        set = new HashSet<>();
        set2 = new HashSet<>();
        int N = Integer.parseInt(bf.readLine());
        for(int i = 0 ; i < N ; i ++) set.add(bf.readLine());

        int M = Integer.parseInt(bf.readLine());
        for(int i = 0 ; i < M ; i ++){
            String[] stc = bf.readLine().split(" ");
            for(String word : stc) {
                System.out.println(word);
                find(word.toCharArray(), 1, word.length() - 2);
                set2.clear();
            }

            System.out.println(count);
            count = 0;
        }
    }
}
