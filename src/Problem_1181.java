import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
//단어 정렬
public class Problem_1181 {
    public static void main(String[] args){
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) return o1.compareTo(o2);
                else return o1.length() - o2.length();
            }
        });
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        for(int i = 0 ; i < N ; i++){
            String input = scanner.nextLine();
            if(!pq.contains(input)) pq.add(input);
        }
        while(!pq.isEmpty()) System.out.println(pq.poll());
    }
}
