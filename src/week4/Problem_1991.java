package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 트리 순회
public class Problem_1991 {
    private static StringBuilder sb;
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
    private static class Tree{
        Node root;
        private Tree(){
            this.root = null;
        }
        private void setChild(Node n, Node node, char c, boolean b){
            if(n == null) return;
            if(n.c == c) {
                if(b) n.L = node;
                else n.R = node;
                return;
            }
            setChild(n.L, node, c, b);
            setChild(n.R, node, c, b);
        }
        private void preOrder(Node n){
            if(n == null) return;
            sb.append(n.c);
            preOrder(n.L);
            preOrder(n.R);
        }
        private void inOrder(Node n){
            if(n == null) return;
            inOrder(n.L);
            sb.append(n.c);
            inOrder(n.R);
        }
        private void postOrder(Node n){
            if(n == null) return;
            postOrder(n.L);
            postOrder(n.R);
            sb.append(n.c);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Tree tree = new Tree();
        for(int i = 0 ; i < N ; i ++){
            String[] s = bf.readLine().split(" ");
            Node n = new Node(s[0].charAt(0));
            if(tree.root == null) tree.root = n;

            if(s[1].charAt(0) != '.') tree.setChild(tree.root, new Node(s[1].charAt(0)), n.c, true);
            if(s[2].charAt(0) != '.') tree.setChild(tree.root, new Node(s[2].charAt(0)), n.c, false);

        }
        sb = new StringBuilder();
        tree.preOrder(tree.root);
        sb.append('\n');
        tree.inOrder(tree.root);
        sb.append('\n');
        tree.postOrder(tree.root);
        System.out.println(sb);
    }
}
