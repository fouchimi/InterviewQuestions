/**
 * Created by ousmane on 12/17/16.
 */
public class PathExists {

    private TreeNode root;

    public PathExists(TreeNode root){
        this.root = root;
    }

    public boolean pathExists(TreeNode root, int target){
        if(root == null) return false;
        String value = ""+target;
        return pathExists(root, value, 0, "") ||
                pathExists(root.getLeft(), target) ||
                pathExists(root.getRight(), target);
    }

    private boolean pathExists(TreeNode node, String target, int index, String path){
        if(node == null) return false;
        if(target.charAt(index) == Integer.toString(node.getElt()).charAt(0)) {
            index = index + 1;
        }
        path+=node.getElt();
        if(index == target.length() && path.equals(target)) {
            return true;
        }else {
            return pathExists(node.getLeft(), target, index, path) ||
            pathExists(node.getRight(), target, index, path);
        }
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

    public static void main(String[] args){
        TreeNode n6  = new TreeNode(9);
        TreeNode n5 = new TreeNode(8);
        TreeNode n2 = new TreeNode(5);
        n2.setLeft(n5);
        n2.setRight(n6);

        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(7);
        TreeNode n1 = new TreeNode(4);
        n1.setLeft(n3);
        n1.setRight(n4);

        TreeNode n0 = new TreeNode(3);
        n0.setLeft(n1);
        n0.setRight(n2);

        PathExists pe = new PathExists(n0);
        pe.inOrder();
        System.out.println("\n"+ pe.pathExists(n0, 359));
        System.out.println(pe.pathExists(n0, 38));
        System.out.println(pe.pathExists(n0, 47));
        System.out.println(pe.pathExists(n0, 6));
    }
}
