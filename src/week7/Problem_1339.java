package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

// 단어 수학
public class Problem_1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String[] words = new String[N];
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0 ; i < N ; i ++) words[i] = bf.readLine();
        for(String word : words){
            int len = word.length();
            for(int i = 0 ; i < word.length() ; i ++){
                String w = word.substring(i, i + 1);
                map.put(w, map.getOrDefault(w, 0) + (int) Math.pow(10, len - i - 1));
            }
        }
        int[] a = new int[map.size()];
        int index = 0;
        int answer= 0;
        int val = 9;

        for(String key : map.keySet()) a[index ++] = map.get(key);
        Arrays.sort(a);
        for(int i = map.size() - 1 ; i >= 0 ; i --) answer += a[i] * val --;
        System.out.println(answer);
    }
}
