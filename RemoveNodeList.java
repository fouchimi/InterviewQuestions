/**
 * Created by ousmane on 12/28/16.
 */
public class RemoveNodeList {
    private ListNode head;


    public void remove(int val){
        ListNode current = head;
        while (current != null){
            if(current.getNext() != null && current.getNext().getVal() == val){
                current.setNext(current.getNext().getNext());
            }
            current = current.getNext();
        }
        if(head.getVal() == val && head.getNext() != null) {
            head = head.getNext();
        }
    }

    public void add(int elt){
        head = add(head, elt);
    }

    private ListNode add(ListNode x, int elt){
        if(x == null) {
            head = new ListNode(elt);
        }else{
            ListNode current = x;
            while (current.getNext() != null) current = current.getNext();
            ListNode newNode = new ListNode(elt);
            current.setNext(newNode);
        }
        return head;
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
        RemoveNodeList list = new RemoveNodeList();
        list.add(1);
        list.add(2);
        list.add(6);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.print();
        list.remove(6);
        System.out.println();
        list.print();
    }
}
