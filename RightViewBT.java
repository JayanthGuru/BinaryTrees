import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class RightViewBT {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }
    
    //This approach uses an ArrayList to store all the node of the level and then print the right most element of that level. 
    static void rightView1(Node root){
        Queue<Node> q = new LinkedList<Node>();
        if(root == null)    return;
        q.add(root);
        q.add(null);
        Node temp;
        ArrayList<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            temp = q.peek();
            q.remove();
            if(temp == null){
                System.out.print(list.get(list.size()-1)+" ");
                if(q.size() == 0)   break;
                q.add(null);
                continue;
            }
            //System.out.print(temp.data+" ");
            list.add(temp.data);
            if(temp.left != null)    q.add(temp.left);
            if(temp.right != null)   q.add(temp.right);
        }
    }

    //This approach uses recursive way to see if there is any right most element in the new level(kind of greedly checking only right most).
    static int max_level = Integer.MIN_VALUE;
    static void rightView2(Node root, int curr_level){
        if(root == null)    return;
        if(max_level < curr_level){
            System.out.print(root.data+" ");
            max_level = curr_level;
        }
        rightView2(root.right, curr_level+1);
        rightView2(root.left, curr_level+1);
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

        //System.out.print("Level order : ");
        rightView1(root);
        System.out.println();
        rightView2(root,0);
        System.out.println();
    }

}


/*
 * Time Comp : O(n)
 * Approach 1 uses extra space of O(n) for list + O(n) max queue size
 * Approach 2 uses no extra space other than stack space of recursion.
 */