/**
 * Created by ousmane on 12/22/16.
 */
public class SimilarPair {

    private TreeNode root = null;

    protected static class TreeNode{
        private int elt;
        private TreeNode left, right;

        public TreeNode(TreeNode left, int elt, TreeNode right){
            this.left = left;
            this.elt = elt;
            this.right = right;
        }
    }

    public void setRoot(TreeNode n){
        root = n;
    }

    public int countPair(TreeNode root, int k){
        if(root == null) return 0;
        int countFromRoot = countPairFromNode(root, k, root.elt);
        int countFromLeftNode = countPair(root.left, k);
        int countFromRightNode = countPair(root.right, k);
        return countFromRoot + countFromLeftNode + countFromRightNode;
    }

    private int countPairFromNode(TreeNode n, int k, int elt){
        if(n == null) return 0;
        else {
            int count = 0;
            if(n.left != null){
                if((Math.abs(elt - n.left.elt)) <= k){
                    count += countPairFromNode(n.left, k, elt) + 1;
                }
            }

            if(n.right != null){
                if((Math.abs(elt - n.right.elt)) <= k){
                    count += countPairFromNode(n.right, k, elt) + 1;
                }
            }
            return count;
        }
    }

    public TreeNode getRoot(){
        return this.root;
    }



    public static void main(String[] args){
        SimilarPair pair = new SimilarPair();
        SimilarPair.TreeNode fifth = new SimilarPair.TreeNode(null, 5, null);
        SimilarPair.TreeNode fourth = new SimilarPair.TreeNode(null, 4, null);
        SimilarPair.TreeNode first = new SimilarPair.TreeNode(fourth, 1, fifth);
        SimilarPair.TreeNode second = new SimilarPair.TreeNode(null, 2, null);
        SimilarPair.TreeNode third = new SimilarPair.TreeNode(second, 3, first);
        pair.setRoot(third);
        System.out.println("The total number of similar pairs are: " + pair.countPair(pair.getRoot(), 2));
    }
}
