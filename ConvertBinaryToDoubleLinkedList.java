/**
 * Created by ousmane on 12/26/16.
 */
public class ConvertBinaryToDoubleLinkedList {
    TreeNode root = null;
    TreeNode header = null;

    protected class TreeNode {
        private TreeNode left, right, prev, next;
        private int elt;

        public TreeNode(int elt){
            this.elt = elt;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public void setPrev(TreeNode prev) {
            this.prev = prev;
        }

        public void setNext(TreeNode next) {
            this.next = next;
        }

        public void setElt(int elt) {
            this.elt = elt;
        }

        public TreeNode getNext(){
            return this.next;
        }
    }

    public void put(int elt){
        root = put(root, elt);
    }

    private TreeNode put(TreeNode x, int elt){
        if(x == null) return new TreeNode(elt);
        if(elt < x.elt) x.left = put(x.left, elt);
        else if(elt > x.elt) x.right = put(x.right, elt);
        else {
            x.elt = elt;
        }
        return x;
    }

    public void printTree(){
        printTree(root);
    }

    public void buildTree(){
        put(4);
        put(2);
        put(3);
        put(1);
        put(0);
        put(5);
        put(6);
    }

    private void printTree(TreeNode x){
        if(x == null) return;
        printTree(x.left);
        TreeNode current = null;
        if(header == null){
            header = x;
            header.setPrev(x.left);
            header.setNext(x.right);
        }else {
            current = header;
            while (current.getNext() != null){
                current = current.getNext();
            }
            TreeNode newNode = new TreeNode(x.elt);
            current.setNext(newNode);
            newNode.setPrev(current);
        }
        System.out.print(x.elt + " ");
        printTree(x.right);
    }

    public void printDoublyLinkedList() {
        TreeNode current = header;
        while (current != null){
            System.out.print(current.elt + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args){
        ConvertBinaryToDoubleLinkedList cv = new ConvertBinaryToDoubleLinkedList();
        cv.buildTree();
        cv.printTree();
        System.out.println();
        cv.printDoublyLinkedList();
    }
}
