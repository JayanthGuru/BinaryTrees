import java.util.Queue;
import java.util.LinkedList;

public class LevelWiseBT {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }
    
    static void levelWise(Node root){
        Queue<Node> q = new LinkedList<Node>();
        if(root == null)    return;
        q.add(root);
        q.add(null);
        Node temp;
        while(!q.isEmpty()){
            temp = q.peek();
            q.remove();
            if(temp == null){
                if(q.size() == 0)   break;
                System.out.println();
                q.add(null);
                continue;
            }
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

        // System.out.print("Level order : ");
        levelWise(null);
        System.out.println();
    }

}

/*
 * VERY IMP CONCEPT
 * 
 * at any point of time the queue size will be containing at max n/2 node so space comp - O(n).
 * Time comp - O(n) to process all nodes.
 * by inserting null into queue when ever we get a null we can guarenty that a level is completed.
 * 
 */