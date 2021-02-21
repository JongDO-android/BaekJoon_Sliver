import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Problem_1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0 ; i < N ; i ++) {
            String key = bf.readLine();
            hm.put(key, hm.getOrDefault(key, 0) + 1);
        }
        int max = 0;
        String mbook = "";
        for(String key : hm.keySet()) {
            if(max < hm.get(key)) {
                max = hm.get(key);
                mbook = key;
            }
            else if(max == hm.get(key)){
                if(mbook.compareTo(key) > 0) mbook = key;
            }
        }
        System.out.println(mbook);
    }
}
