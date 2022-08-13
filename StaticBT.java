public class StaticBT {

    Node root;
    StaticBT(int key){
        root = new Node(key);
    }
    StaticBT(){
        root = null;
    }


    public static void main(String[] args){
        StaticBT BT = new StaticBT();
        BT.root = new Node(1);
        BT.root.left = new Node(2);
        BT.root.right = new Node(3);
        BT.root.left.left = new Node(4);
        BT.root.left.right = new Node(5);
        BT.root.right.right = new Node(6);
        
        /* 
                                1
                             /      \
                           2          3
                         /   \      /   \
                        4     5          6
        */
    }
}

class Node{
    int data;
    Node left,right;

    Node(int data){
        this.data = data;
        left = right = null;
    }
}
