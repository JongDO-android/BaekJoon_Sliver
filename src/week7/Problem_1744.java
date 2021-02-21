package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

// 수 묶기
public class Problem_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> plus = new ArrayList<>();
        ArrayList<Integer> minus = new ArrayList<>();

        for(int i = 0 ; i < N ; i ++){
            int n = Integer.parseInt(bf.readLine());
            if(n == 0) map.put(0, map.getOrDefault(0, 0) + 1);
            else if(n == 1) map.put(1, map.getOrDefault(1, 0) + 1);
            else{
                if(n > 1) plus.add(n);
                else minus.add(n);
            }
        }
        plus.sort(Collections.reverseOrder());
        Collections.sort(minus);
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for(Integer i : plus){
            if(stack.isEmpty()) stack.push(i);
            else sum += stack.pop() * i;
        }
        if(!stack.isEmpty()) sum += stack.pop();
        stack.clear();

        for(Integer i : minus){
            if(stack.isEmpty()) stack.push(i);
            else sum += stack.pop() * i;
        }
        if(!stack.isEmpty()){
            int val = stack.pop();
            if(map.containsKey(0)) val = 0;
            sum += val;
        }
        sum += map.getOrDefault(1, 0);

        System.out.println(sum);
    }
}
