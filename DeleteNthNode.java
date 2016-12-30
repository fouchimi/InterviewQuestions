/**
 * Created by ousmane on 12/29/16.
 */
public class DeleteNthNode {
    private ListNode head = null;

    public void add(int elt){
        head = add(head, elt);
    }

    private ListNode add(ListNode x, int elt){
        if(x == null) {
            x = new ListNode(elt);
            return x;
        }
        else{
            ListNode current = x;
            while(current.getNext() != null) current = current.getNext();
            ListNode newNode = new ListNode(elt);
            current.setNext(newNode);
            return x;
        }
    }
    public  void delete(int k){
        head = deletekthNode(head, k);
    }
    private ListNode deletekthNode(ListNode x, int k){
        int size = 0;
        ListNode current = x;
        while(current != null){
            size++;
            current = current.getNext();
        }
        size -=k;
        current = x;
        boolean flag = false;
        while(size > 1){
            flag = true;
            size--;
            current = current.getNext();
        }
        if(flag) current.setNext(current.getNext().getNext());
        return x;
    }

    public void print(){
        head = print(head);
    }

    private ListNode print(ListNode x){
        ListNode current = x;
        while(current != null){
            System.out.print(current.getVal() +" ");
            current = current.getNext();
        }
        System.out.println();
        return x;
    }

    public static void main(String[] args){
        DeleteNthNode dlt = new DeleteNthNode();
        dlt.add(1);
        dlt.add(2);
        dlt.add(3);
        dlt.add(4);
        dlt.add(5);
        dlt.print();
        dlt.delete(2);
        dlt.print();
    }
}
