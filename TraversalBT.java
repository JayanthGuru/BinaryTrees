public class TraversalBT {
    static class Node{
        int data;
        Node left,right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    static void preOrder(Node root){
        if(root == null)    return;//{System.out.print("N ");return;}
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void inOrder(Node root){
        if(root == null)    return;//{System.out.print("N ");return;}
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    static void postOrder(Node root){
        if(root == null)    return;//{System.out.print("N ");return;}
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.print("Pre Order : ");
        preOrder(root);
        System.out.print("\nIn Order : ");
        inOrder(root);
        System.out.print("\nPost Order : ");
        postOrder(root);
    }
}
