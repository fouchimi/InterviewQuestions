/**
 * Created by ousmane on 12/26/16.
 */
public class DeleteBSTNode {

    private TreeNode root =  null;

    protected static class TreeNode {
        private TreeNode left, right;
        private int elt;

        TreeNode(int elt){
            this.elt = elt;
        }
    }

    public void put(int elt){
        root = put(root, elt);
    }

    private TreeNode put(TreeNode x, int elt){
        if(x == null) return new TreeNode(elt);
        if(elt < x.elt) x.left = put(x.left, elt);
        else if(elt > x.elt) x.right =  put(x.right, elt);
        else{
            x.elt = elt;
        }
        return  x;
    }

    public void delete(int elt){
        root = delete(root, elt);
    }

    private TreeNode delete(TreeNode x, int elt){
        if(x == null) return null;
        if(elt < x.elt) x.left = delete(x.left, elt);
        else if(elt > x.elt) x.right = delete(x.right, elt);
        else{
            if(x.left == null) return x.right;
            if(x.right == null) return x.left;
            TreeNode t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        return x;
    }

    private TreeNode min(TreeNode x){
        if(x.left == null) return x;
        return min(x.left);
    }

    private TreeNode deleteMin(TreeNode x){
        if(x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }

    public void printTree(){
        printTree(root);
    }

    private void printTree(TreeNode x){
        if(x == null) return;
        printTree(x.left);
        System.out.print(x.elt + " ");
        printTree(x.right);
    }

    public static void main(String[] args){
        DeleteBSTNode dbst = new DeleteBSTNode();
        dbst.put(5);
        dbst.put(3);
        dbst.put(6);
        dbst.put(2);
        dbst.put(4);
        dbst.put(7);
        dbst.printTree();
        System.out.println();
        dbst.delete(3);
        dbst.printTree();
    }


}
