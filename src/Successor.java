/**
 * Created by ousmane on 12/9/16.
 */
public class Successor {

    private TreeNode root;

    private class TreeNode {
        private int elt;
        private TreeNode left, right, next, parent;

        TreeNode(int elt, TreeNode next, TreeNode parent){
            this.elt = elt;
            this.next = next;
            this.next = parent;
        }
    }

    public int getNext(int elt){
        return getNext(root, elt);
    }

    private int getNext(TreeNode x, int elt){
        if(x == null) return -1;
        if(elt < x.elt) {
            return  getNext(x.left, elt);
        }else if(elt > x.elt){
            return getNext(x.right, elt);
        }else {
            return x.next.elt;
        }
    }

    public void put(int elt){
        root = put(root, elt);
    }

    private TreeNode put(TreeNode x, int elt){
        if(x == null) {
            return new TreeNode(elt, null, null);
        }
        if (elt < x.elt){
            x.left = put(x.left, elt);
            x.left.parent = x;
            x.left.next = x.left.parent.right;
        }
        else if(elt > x.elt) {
            x.right = put(x.right, elt);
            x.right.parent = x;
            if(x.right.parent.left != null) {
                x.right.next = x.right.parent.left.left;
            }
        }
        else {
            x.elt = elt;
        }
        x.next = x.left;
        return x;
    }

    public static void main(String[] args){
        Successor successor = new Successor();
        successor.put(5);
        successor.put(3);
        successor.put(2);
        successor.put(6);
        System.out.println("The next element of " + 6 + " is " + successor.getNext(6));

    }
}
