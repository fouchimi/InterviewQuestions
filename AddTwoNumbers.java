/**
 * Created by ousmane on 12/5/16.
 */
public class AddTwoNumbers {

    public void buildList(){
        LinkedList<Number> l1 = new LinkedList<Number>();
        LinkedList<Number> l2 = new LinkedList<Number>();
        l1.add(2);
        l1.add(4);
        l1.add(3);
        print(l1);
        l2.add(5);
        l2.add(6);
        l2.add(4);
        print(l2);
        LinkedList<Number> result = addTwoNumbers(l1, l2);
        print(result);
    }

    private void print(LinkedList<Number> list){
        LinkedList.Node current = list.getCurrentNode(0);
        while (current != null){
            System.out.print(current.getElt() + " ");
            current=current.getNext();
        }
        System.out.println();
    }

    private LinkedList<Number> addTwoNumbers(LinkedList<Number> l1, LinkedList<Number> l2){
        LinkedList.Node first = l1.getCurrentNode(0);
        LinkedList.Node second = l2.getCurrentNode(0);
        LinkedList<Number> sumList = new LinkedList<Number>();
        int carryOver = 0;

        while (first != null){
            int firstElement = first.getElt();
            int secondElement = second.getElt();
            int sum = firstElement + secondElement;
            if(sum >= 10) {
                carryOver = sum/10;
                sum = sum%10;
            }
            sumList.add(sum);
            if(first.getNext() != null && carryOver > 0){
                int nextValue = first.getNext().getElt() + carryOver;
                first.getNext().setElt(nextValue);
            }
            first = first.getNext();
            second = second.getNext();
        }
        return sumList;
    }

    public static void main(String[] args){
        AddTwoNumbers add = new AddTwoNumbers();
        add.buildList();
    }
}
