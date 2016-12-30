import java.util.Stack;

/**
 * Created by ousmane on 12/14/16.
 */
public class FirstCommonAncestor {

    private TreeNode root = null;

    private class TreeNode {
        private int elt;
        private TreeNode left, right;

        public TreeNode(int elt){
            this.elt = elt;
        }
    }

    public void put(int elt){
        root = put(root, elt);
    }

    public void print(){
        print(root);
    }

    private void print(TreeNode x) {
        if(x == null) return;
        print(x.left);
        System.out.print(x.elt + " ");
        print(x.right);
    }

    public int firstCommonAncestor(int first, int second) {
        Stack<Integer> firstList = get(first);
        Stack<Integer> secondList = get(second);
        if(firstList.size() < secondList.size()) return firstList.peek();
        else if(firstList.size() > secondList.size()) return secondList.peek();
        else return firstList.peek();
    }

    private TreeNode put(TreeNode x, int elt){
        if(x == null) return new TreeNode(elt);
        if(elt < x.elt) x.left = put(x.left, elt);
        else if(elt > x.elt) x.right = put(x.right, elt);
        else x.elt = elt;
        return x;
    }

    public Stack<Integer> get(int elt){
        Stack<Integer> list = new Stack<>();
        list = get(root, elt, list);
        return list;
    }

    private Stack<Integer> get(TreeNode x, int elt, Stack<Integer> list){
        if(x == null) return null;
        if(elt < x.elt) {
            list.add(x.elt);
            return get(x.left, elt, list);
        }else if(elt > x.elt){
            list.add(x.elt);
            return get(x.right, elt, list);
        }else return list;
    }

    public static void main(String[] args){
        FirstCommonAncestor fca = new FirstCommonAncestor();
        fca.put(15);
        fca.put(9);
        fca.put(23);
        fca.put(6);
        fca.put(12);
        fca.put(10);
        fca.put(13);
        fca.put(14);
        fca.print();
        System.out.println("\nThe first common ancestor is: " + fca.firstCommonAncestor(14, 23));
        System.out.println("The first common ancestor is: " + fca.firstCommonAncestor(10, 23));
        System.out.println("The first common ancestor is: " + fca.firstCommonAncestor(10, 14));
    }

}
