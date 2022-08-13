/* 
 * Given a BT and a key, insert the key into BT at the first position available in level order.
*/

import java.util.LinkedList;
import java.util.Queue;

public class InsertBT {
    static class Node{
        int data;
        Node left,right;
        Node(int key){
            data = key;
            left = right = null;
        }
    }

    static Node temp;
    static void insertNode(Node root, int key){
        if(root == null)    {root = new Node(key);return;}

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            temp = q.peek();
            q.remove();
            if(temp.left == null)       {temp.left = new Node(key);return;}
            else                        q.add(temp.left);
            if(temp.right == null)      {temp.right = new Node(key);return;}
            else                        q.add(temp.right);
        }
    }

    static void preOrder(Node root){
        if(root == null)    return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args){
        Node root=  new Node(10);
        root.left = new Node(11);
        root.right = new Node(9);
        root.left.left = new Node(7);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        System.out.print("Before Inserting : ");
        preOrder(root);
        insertNode(root, 12);
        System.out.print("\nAfter Inserting : ");
        preOrder(root); 
    }
}

/*
 * Time Complexity:  O(V) where V is the number of nodes.
 * Auxiliary Space:  O(B) where B is the width of the tree and in the worst case we need to hold all vertices of a level in the queue.
 */
