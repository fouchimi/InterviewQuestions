/**
 * Created by ousmane on 12/22/16.
 */
public class ForestTree {

    private Node root = null;

    private static class Node {
        private int elt;
        private Node left, middle, right;

        public Node(int elt){
            this.elt = elt;
        }

        public void setLeft(Node left){
            this.left = left;
        }

        public void setRight(Node right){
            this.right = right;
        }

        public void setMiddle(Node middle){
            this.middle = middle;
        }
    }

    public int countPossibleForest(Node root){
        if(root == null) return 0;
        int count = 0;
        int leftSum = dfs(root.left);
        if(leftSum%2 == 0 && leftSum > 0 ){
            count++;
            countPossibleForest(root.left);
        }
        int middleSum = dfs(root.middle);
        if(middleSum%2 == 0 && middleSum > 0) {
            count++;
            countPossibleForest(root.middle);
        }
        int rightSum = dfs(root.right);
        if(rightSum%2 == 0 && rightSum > 0) {
            count++;
            countPossibleForest(root.right);
        }
        return count;
    }

    private int dfs(Node x){
        if(x == null) return 0;
        int count = 0;
        count += dfs(x.left) + dfs(x.middle) + dfs(x.right) + 1;
        return count;
    }

    private void setRoot(Node root){
        this.root = root;
    }

    public static void main(String[] args){
        ForestTree.Node tenth = new ForestTree.Node(10);
        ForestTree.Node ninth = new ForestTree.Node(9);
        ForestTree.Node eighth = new ForestTree.Node(8);
        eighth.setLeft(ninth);
        eighth.setRight(tenth);
        ForestTree.Node sixth = new ForestTree.Node(6);
        sixth.setLeft(eighth);
        ForestTree.Node seventh = new ForestTree.Node(7);
        ForestTree.Node fifth = new ForestTree.Node(5);
        ForestTree.Node second = new ForestTree.Node(2);
        second.setLeft(seventh);
        second.setRight(fifth);
        ForestTree.Node fourth = new ForestTree.Node(4);
        ForestTree.Node third = new ForestTree.Node(3);
        third.setLeft(fourth);
        ForestTree.Node first = new ForestTree.Node(1);
        first.setLeft(third);
        first.setMiddle(sixth);
        first.setRight(second);
        ForestTree ft = new ForestTree();
        ft.setRoot(first);

        System.out.println("The maximum number of: " + ft.countPossibleForest(first));
    }
}
