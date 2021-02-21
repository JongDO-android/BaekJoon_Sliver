import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1183 {
    public static void main(String[] args){

    }

    public static class Problem_1991 {
        private static class Tree{
            Node root;
            private Tree(){
                this.root = null;
            }
            private void setChild(Node n, Node node, char c){
                if(n == null) {
                    root = node;
                    return;
                }
                if(n.c == c){
                    n = node;
                    return;
                }
                setChild(n.L, node, c);
                setChild(n.R, node, c);
            }
        }
        private static class Node{
            char c;
            Node L;
            Node R;
            private Node(char c){
                this.c = c;
                this.L = null;
                this.R = null;
            }
        }
        public static void main() throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(bf.readLine());
            Tree tree = new Tree();
            for(int i = 0 ; i < N ; i ++){
                String[] s = bf.readLine().split(" ");
                Node node = new Node(s[0].charAt(0));
                if(s[1].charAt(0) != '.') node.L = new Node(s[1].charAt(0));
                if(s[2].charAt(0) != '.') node.R = new Node(s[2].charAt(0));

                tree.setChild(tree.root, node, s[0].charAt(0));
            }

        }
    }
}
