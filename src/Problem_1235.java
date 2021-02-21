import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Problem_1235 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> hs = new HashSet<>();
        int N = Integer.parseInt(bf.readLine());
        int k = 1;
        String[] stu = new String[N];
        for(int i = 0 ; i < N ; i ++) stu[i] = bf.readLine();
        int len = stu[0].length();
        while(hs.size() != N){
            hs.clear();
            for(String s : stu) hs.add(s.substring(len - k));
            k++;
        }
        System.out.println((k-1));
    }
}
