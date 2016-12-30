/**
 * Created by ousmane on 12/28/16.
 */
public class SwapNodePairs {
    private ListNode head;

    public void add(int elt){
        head = add(head, elt);
    }

    public void swapPairs(){
        head = swapPairs(head);
    }

    private ListNode swapPairs(ListNode head){
        ListNode current = head;
        ListNode first = null, second = null;
        ListNode newHead = null, next = null, newList = null;
        int N=1;
        while(current != null){
            if(N%2!=0) first = current;
            else second = current;
            if(N%2==0){
                next = second.getNext();
                newList = swap(first, second);
                if(newHead == null) {
                    newHead = newList;
                    first.setNext(null);
                }
                else {
                    newList.getNext().setNext(null);
                    ListNode cursor = newHead;
                    while(cursor.getNext() != null) cursor = cursor.getNext();
                    cursor.setNext(newList);
                }
            }
            if(N%2==0) current = next;
            else current = current.getNext();
            N++;
        }
        if(N%2==0) {
            ListNode cursor = newHead;
            while(cursor.getNext() != null) cursor = cursor.getNext();
            cursor.setNext(first);
        }
        return newHead;
    }

    private ListNode swap(ListNode first, ListNode second){
        second.setNext(first);
        return second;
    }

    private ListNode add(ListNode x, int elt){
        if(x == null) return new ListNode(elt);
        else {
            ListNode current = head;
            while(current.getNext() != null){
                current = current.getNext();
            }
            ListNode newNode = new ListNode(elt);
            current.setNext(newNode);
            return head;
        }
    }

    public void print(){
        print(head);
    }

    private void print(ListNode x){
        ListNode current = x;
        while(current != null){
            System.out.print(current.getVal() + " ");
            current = current.getNext();
        }
    }

    public static void main(String[] args){
        SwapNodePairs list = new SwapNodePairs();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.swapPairs();
        list.print();
    }
}
