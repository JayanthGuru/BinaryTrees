import java.util.Queue;
import java.util.LinkedList;

public class LevelOrderBT {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }
    
    static void levelOrder(Node root){
        if(root == null)    return;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        Node temp;
        while(!q.isEmpty()){
            temp = q.peek();
            q.remove();
            System.out.print(temp.data+" ");
            if(temp.left != null)    q.add(temp.left);
            if(temp.right != null)   q.add(temp.right);
        }
    }

    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.left.left.left = new Node(6);
        root.left.left.right = new Node(7);
        root.right.left.right = new Node(8);

        System.out.print("Level order : ");
        levelOrder(root);
        System.out.println();
    }

}
