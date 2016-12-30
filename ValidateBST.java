
import java.util.LinkedList;

/**
 * Created by ousmane on 12/9/16.
 */
public class ValidateBST {
    private TreeNode root = null;
    private class TreeNode {
        private int elt;
        private TreeNode left, right;
        private int N;

        public TreeNode(int elt) {
            this.elt = elt;
            this.N = 1;
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

    public int size(){
        return size(root);
    }

    private int size(TreeNode x){
        if(x == null) return 0;
        int leftSize = size(x.left);
        int rightSize = size(x.right);
        return leftSize + rightSize + 1;
    }

    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(TreeNode x){
        if(x == null) return false;
        else {
            int leftSize = size(x.left);
            int rightSize = size(x.right);
            int max = Math.max(leftSize, rightSize);
            int diff = -1;
            if(max == leftSize) {
                diff = leftSize - rightSize;
            }else diff = rightSize - leftSize;
            if(diff > 1) return false;
            return true;
        }
    }

    public boolean validateBST() {
        return validateBST(root);
    }

    private boolean validateBST(TreeNode x) {
        if(x == null) return false;
        else {
            LinkedList<TreeNode> q = new LinkedList<>();
            q.add(x);
            while(!q.isEmpty()){
                TreeNode currentNode = q.peek();
                if(currentNode.left != null && currentNode.right != null){
                    if(currentNode.left.elt < currentNode.elt && currentNode.right.elt >= currentNode.elt){
                        q.add(currentNode.left);
                        q.add(currentNode.right);
                        q.pop();
                    }else return false;

                }else if(currentNode.left != null && currentNode.right == null){
                    if(currentNode.left.elt < currentNode.elt){
                        q.add(currentNode.left);
                        q.pop();
                    }else return false;
                }else if(currentNode.left == null && currentNode.right != null){
                    if(currentNode.right.elt >= currentNode.elt){
                        q.add(currentNode.right);
                        q.pop();
                    }else return false;
                }else {
                    q.pop();
                }
            }
            if(q.isEmpty()) return true;
            else return false;
        }
    }

    public void printBST(){
        printBST(root);
    }

    private void printBST(TreeNode x){
        if(x == null) return;
        printBST(x.left);
        System.out.print(x.elt + " ");
        printBST(x.right);
    }


    public static void main(String[] args){
        ValidateBST bst = new ValidateBST();
        bst.put(5);
        bst.put(3);
        bst.put(7);
        bst.put(6);
        bst.put(4);
        bst.put(-10);
        bst.put(12);
        bst.put(8);
        bst.put(1);
        bst.put(25);
        bst.put(45);
        bst.printBST();
        if(bst.validateBST()){
            System.out.println("\nThis is a valid binary tree");
        }
        System.out.println("The size of the binary tree is: " + bst.size());
        if(bst.isBalanced()){
            System.out.println("This is a balanced tree");
        }else {
            System.out.println("This is an unbalanced tree");
        }

    }
}
