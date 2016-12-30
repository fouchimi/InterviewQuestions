import java.util.LinkedList;

/**
 * Created by ousmane on 11/17/16.
 */
public class ReverseTree {

    private Node root = null;
    private int[] arr;

    private class Node {
        private int elt;
        private Node left, right;
        private int N;

        public Node(Node left, int elt, Node right, int N){
            this.left = left;
            this.elt = elt;
            this.right = right;
            this.N = N;
        }
    }

    public int size(){
        return size(root);
    }

    private int size(Node x){
        if(x == null) return 0;
        else return x.N;
    }

    public void put(int elt){
        root = put(root, elt);
    }

    private Node put(Node x, int elt){
        if(x == null) return new Node(null, elt, null, 1);
        else if(x.left == null && x.right == null) x.left = put(x.left, elt);
        else if(x.left != null && x.right == null) x.right = put(x.right, elt);
        else if(x.left != null && x.right != null) x.left = put(x.left, elt);
        else x.elt = elt;
        x.N = size(x.left) + size(x.right) +1;
        return x;
    }

    public void levelOrder(){
        if(root == null) return;
        LinkedList<Node> queue = new LinkedList<>();
        arr = new int[size()];
        int i=0;
        queue.add(root);
        while (!queue.isEmpty()){
            Node current = queue.peek();
            arr[i++] = current.elt;
            System.out.print(current.elt + " ");
            if(current.left != null) queue.addLast(current.left);
            if(current.right != null) queue.addLast(current.right);
            queue.pop();
        }
        System.out.println();
    }

    public void printReverseTree(){
        printReverseTree(arr, 0, size());
    }

    private void printReverseTree(int[] A, int low, int high){
        int mid = low + (high - low)/2;
        if(mid <= low) {
            System.out.print(A[0]);
            return;
        }
        for(int i=mid; i< high; i++){
            System.out.print(A[i] + " ");
        }
        printReverseTree(A, low, mid);

    }

    public static void main(String[] args){
        ReverseTree tree  = new ReverseTree();
        tree.put(1);
        tree.put(2);
        tree.put(3);
        tree.put(4);
        tree.put(5);
        tree.put(6);
        tree.put(7);
        tree.levelOrder();
        tree.printReverseTree();
    }
}
