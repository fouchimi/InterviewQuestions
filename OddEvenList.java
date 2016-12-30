import java.util.List;

/**
 * Created by ousmane on 12/27/16.
 */
public class OddEvenList {
    private ListNode header;

    public OddEvenList(){
    }

    public void oddEvenList(){
        header = oddEvenList(header);
        System.out.println();
        print();
    }

    private ListNode oddEvenList(ListNode head){
        ListNode first = head;
        ListNode second = null;
        ListNode third = null;
        if(first.getNext() != null){
            second = first.getNext();
            if(second.getNext() != null)  third = second.getNext();
            if(third.getNext() == null) {
                first.setNext(third);
                first.getNext().setNext(second);
                return first;
            }
        }
        int N = 2;
        int evenListSize = 0;
        ListNode evenTail = third.getNext();
        while(third != null){
            first.setNext(third);
            third.setNext(second);
            second.setNext(evenTail);
            first = third;
            third = moveNSteps(second, N);
            if(third != null) {
                int M = evenListSize;
                ListNode current = evenTail;
                while (M>0){
                    current = current.getNext();
                    M--;
                }
                current.setNext(third.getNext());
            }
            N++;
            evenListSize++;
        }
        return head;
    }

    private ListNode moveNSteps(ListNode current, int n){
        int N = n;
        while(N > 0){
            if(current != null) current = current.getNext();
            else break;
            N--;
        }
        return current;
    }


    public void add(int elt){
       header = add(header, elt);
    }

    private ListNode add(ListNode x, int elt){
        if(x == null) return new ListNode(elt);
        else {
            ListNode current = header;
            while(current.getNext() != null){
                current = current.getNext();
            }
            ListNode newNode = new ListNode(elt);
            current.setNext(newNode);
            return header;
        }
    }

    public void print(){
        print(header);
    }

    private void print(ListNode x){
        ListNode current = x;
        while(current != null){
            System.out.print(current.getVal() + " ");
            current = current.getNext();
        }
    }

    public static void main(String[] args){
        OddEvenList list = new OddEvenList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.print();
        list.oddEvenList();
    }
}
