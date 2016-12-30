/**
 * Created by ousmane on 12/10/16.
 */
public class BSTSequences {

    private TreeNode root = null;

    private class TreeNode {
        private int elt;
        private TreeNode left, right;

        public TreeNode(int elt){
            this.elt = elt;
        }
    }

    public void printArraySequence(){
        printArraySequence(root);
    }

    private void printArraySequence(TreeNode x){
        if(x != null) {
            printFromLeft(x);
            System.out.println();
            printFromRight(x);
        }
    }

    private void printFromLeft(TreeNode x) {
        if(x == null) return;
        System.out.print(x.elt + " ");
        printFromLeft(x.left);
        printFromLeft(x.right);
    }

    private void printFromRight(TreeNode x){
        if(x == null) return;
        System.out.print(x.elt + " ");
        printFromRight(x.right);
        printFromRight(x.left);
    }


    public void put(int elt){
        root = put(root, elt);
    }

    private TreeNode put(TreeNode x, int elt){
        if(x == null) return new TreeNode(elt);
        if(elt < x.elt) x.left = put(x.left, elt);
        else if(elt > x.elt) x.right = put(x.right, elt);
        else x.elt = elt;
        return x;
    }


    public static void main(String[] args){
        BSTSequences bst = new BSTSequences();
        bst.put(5);
        bst.put(3);
        bst.put(4);
        bst.put(8);
        bst.put(6);
        bst.put(2);
        bst.put(9);
        bst.put(7);
        bst.put(1);
        bst.printArraySequence();
    }
}
