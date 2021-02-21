package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Problem_18513 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        ArrayList<Integer> st = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        s = bf.readLine().split(" ");
        for(int i = 0 ; i < N ; i ++) st.add(Integer.parseInt(s[i]));
        int dis = 1;
        int answer = 0;
        while(hs.size() < K){
            for(Integer i : st){
                if(!st.contains(i + dis) && !hs.contains(i + dis)) {
                    answer += dis;
                    hs.add(i + dis);
                    if(hs.size() == K) break;
                }
                if(!st.contains(i - dis) && !hs.contains(i - dis)) {
                    answer += dis;
                    hs.add(i - dis);
                    if(hs.size() == K) break;
                }
            }
            dis ++;
        }
        System.out.println(answer);
    }
}
