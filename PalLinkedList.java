/**
 * Created by ousmane on 12/28/16.
 */
public class PalLinkedList {
    private ListNode head;

    public boolean isPalindrome(){
        return isPalindrome(head);
    }

    public boolean isPalindrome(ListNode x){
        String first="";
        ListNode current = x;
        while(current != null){
            first += current.getVal();
            current = current.getNext();
        }
        x = reverseList(x);
        current = x;
        String second ="";
        while(current != null){
            second += current.getVal();
            current = current.getNext();
        }
        if(first.equals(second) && first.length() > 2) return true;
        return false;
    }

    private ListNode reverseList(ListNode x){
        ListNode prev=null, next = null;
        ListNode current = x;
        while(current != null){
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        return prev;
    }

    public void add(int elt){
        head = add(head, elt);
    }

    private ListNode add(ListNode x, int elt){
        if(x == null){
            return new ListNode(elt);
        }else {
            ListNode current = x;
            while(current.getNext() != null) current = current.getNext();
            ListNode newNode = new ListNode(elt);
            current.setNext(newNode);
        }
        return x;
    }

    public void print(){
        print(head);
    }

    private void print(ListNode x){
        ListNode current = x;
        while(current != null){
            System.out.print(current.getVal() +" ");
            current = current.getNext();
        }
    }

    public static void main(String[] args){
        PalLinkedList palLinkedList = new PalLinkedList();
        palLinkedList.add(1);
        palLinkedList.add(5);
        palLinkedList.add(4);
        palLinkedList.add(5);
        palLinkedList.add(1);
        palLinkedList.print();
        System.out.println("\n" + palLinkedList.isPalindrome());
    }
}
