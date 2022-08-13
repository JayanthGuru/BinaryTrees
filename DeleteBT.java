/*
 * QUESTION
 * Given a BT, delete a node from it by making sure that the tree shrinks from the bottom(i.e the deleted node is replaced by the bottom most 
 * and right most node). 
*/

/*
 * Starting at the root, find the deepest and right most node of the BT and the node which we want to delete.
 * Replace the deepest rightmost nodes data with the nodes to be deleted.
 * Then delete the deepest right most node.
*/

import java.util.LinkedList;
import java.util.Queue;

public class DeleteBT {
    static class Node{
        int data;
        Node left,right;
        Node(int key){
            data = key;
            left = right = null;
        }
    }

    static void preOrder(Node root){
        if(root == null)    return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }



    static Node keyNode;
    static Node temp;

    static void deleteDeepest(Node root, Node delNode){

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            temp = q.peek();
            q.remove();
            if(temp.left != null){
                if(temp.left == delNode){
                    temp.left = null;
                    return;
                }
                q.add(temp.left);
            }
            if(temp.right != null){
                if(temp.right == delNode){
                    temp.right = null;
                    return;
                }
                q.add(temp.right);
            }              
        }
    }

    static void deleteBT(Node root, int key){

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            temp = q.peek();
            q.remove();
            if(temp.data == key)                 keyNode = temp;
            if(temp.left != null)                q.add(temp.left);
            if(temp.right != null)               q.add(temp.right);
        }

        if(keyNode != null){
            int x = temp.data;
            deleteDeepest(root,temp);
            keyNode.data = x;
        }

    }

    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.right.left.right = new Node(6);

        System.out.print("Before Deleting : ");
        preOrder(root);
        deleteBT(root, 1);
        System.out.print("\nAfter Deleting : ");
        preOrder(root); 
    }
}


/*
 * Time complexity: O(n) where n is no number of nodes
 * Auxiliary Space: O(n) size of queue
*/