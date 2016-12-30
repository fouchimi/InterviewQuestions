/**
 * Created by ousmane on 12/16/16.
 */
public class MyBinaryTree {

    private TreeNode root;

    public MyBinaryTree(TreeNode root){
        this.root = root;
    }


    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(TreeNode root){
        if(root == null) return;
        System.out.print(root.getElt() + " ");
        inOrder(root.getLeft());
        inOrder(root.getRight());
    }


    public int rob(TreeNode root){
        return visitNode(root)[0];
    }

    private int[] visitNode(TreeNode root){
        if(root == null) {
            int[] res= {0,0};
            return res;
        }

        int[] left = visitNode(root.getLeft());
        int[] right = visitNode(root.getRight());
        int[] res = {Math.max(root.getElt() + left[1] + right[1], left[0]+right[0]), left[0]+right[0]};
        return res;
    }


    public static void main(String[] args){
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        n2.setRight(n1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(1);
        n3.setRight(n4);
        TreeNode n5 = new TreeNode(3);
        n5.setLeft(n2);
        n5.setRight(n3);
        MyBinaryTree bt = new MyBinaryTree(n5);
        bt.inOrder();

        System.out.println("\nThe maximum rob is: " + bt.rob(n5));
    }
}
