public class HeightBT {
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
        if(root.left == null && root.right==null)   return 0;

        return Math.max(height(root.left),height(root.right))+1;
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

        System.out.print("Height order : "+height(root));
        System.out.println();
    }
}
