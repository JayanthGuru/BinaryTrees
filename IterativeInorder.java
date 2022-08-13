import java.util.Stack;

public class IterativeInorder {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    static void iterativeInOrder(Node root){
        Stack<Node> s = new Stack<>();
        Node curr = root;
        while(curr!=null || s.size()>0){
            while(curr != null){
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            System.out.print(curr.data+" ");
            curr = curr.right;
        }

    }

    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.print("InOrder traversal : ");
        iterativeInOrder(root);
        System.out.println();
    }
    

}
