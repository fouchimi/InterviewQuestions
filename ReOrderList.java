/**
 * Created by ousmane on 12/29/16.
 */
public class ReOrderList {
    private ListNode head = null;

    public void reOrderList(){
        head = reOrderList(head);
    }

    private ListNode reOrderList(ListNode x){
        ListNode cursor = x;
        ListNode second = x.getNext();
        if(x.getNext() == null) {
            second.setNext(cursor);
            cursor.setNext(null);
        }
        if(second.getNext() != null && second.getNext().getNext() == null){
            ListNode third = second.getNext();
            cursor.setNext(third);
            third.setNext(second);
            second.setNext(null);
            return x;
        }
        while(cursor.getNext() != null){
            ListNode current = cursor;
            ListNode temp = null;
            ListNode last = null;
            if(cursor.getNext().getNext() == null) break;
            while(current.getNext() != null){
                if(current.getNext().getNext() == null){
                    temp = current;
                    break;
                }
                current = current.getNext();
            }
            last = current.getNext();
            temp.setNext(null);
            cursor.setNext(last);
            last.setNext(second);
            cursor = second;
            second = second.getNext();
        }

        return x;
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
        System.out.println();
    }

    public static void main(String[] args){
        ReOrderList list = new ReOrderList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.print();
        list.reOrderList();
        list.print();
    }
}
