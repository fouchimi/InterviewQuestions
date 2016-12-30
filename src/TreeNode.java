/**
 * Created by ousmane on 12/16/16.
 */
public class TreeNode {

    private int elt;
    private TreeNode left, right;

    public TreeNode(int elt){
        this.elt = elt;
    }

    public int getElt() {
        return elt;
    }

    public void setElt(int elt) {
        this.elt = elt;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
