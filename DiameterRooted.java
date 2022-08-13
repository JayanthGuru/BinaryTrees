public class DiameterRooted {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    static int height(Node root){
        if(root == null)    return 0;
        if(root.left==null && root.right==null)     return 0;

        return Math.max(height(root.left),height(root.right))+1;
    }

    static int diameter(Node root){
        if(root == null)    return 0;
        if(root.left == null && root.right==null)   return 0;

        int left = diameter(root.left);
        int right = diameter(root.right);
        
        int lh = height(root.left);
        int rh = height(root.right);
        int viaRoot = lh + rh; 
        if(root.left != null)   viaRoot+=1;
        if(root.right != null)  viaRoot+=1;
        
        return Math.max(left,Math.max(right,viaRoot));
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
        root.right.left.right.left = new Node(9);
        root.right.left.right.left.right = new Node(10);

        System.out.print("Diameter : "+ diameter(root));
        System.out.println();
    }    

}
