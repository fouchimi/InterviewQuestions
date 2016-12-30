/**
 * Created by ousmane on 12/27/16.
 */
public class ListNode {
    private int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public void setVal(int val){
        this.val = val;
    }

    public int getVal(){
        return this.val;
    }

    public void setNext(ListNode next){
        this.next = next;
    }

    public ListNode getNext(){
        return this.next;
    }
}
