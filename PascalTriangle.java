/**
 * Created by ousmane on 11/26/16.
 */
public class PascalTriangle {

    private LinkedList<Number> list;
    private int index;

    PascalTriangle(){
        list = new LinkedList<Number>();
        index = 2;
        for(int i=0; i <3; i++) {
            list.add(1);
        }
    }

    public void buildPascalTriangle(int N) {
        LinkedList.Node previous = list.getCurrentNode(1);
        LinkedList.Node next = list.getCurrentNode(2);

        while(index < N) {
            LinkedList<Number> newWList = new LinkedList<Number>();
            newWList.add(1);
            while(next != null) {
                newWList.add(previous.getElt() + next.getElt());
                previous = next;
                next = next.getNext();
            }
            newWList.add(1);
            previous = newWList.getCurrentNode(0);
            next = newWList.getCurrentNode(1);
            LinkedList.Node current = list.getCurrentNode(0);
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newWList.getCurrentNode(0));
            index++;
        }
    }

    public void printList(LinkedList<Number> list) {
        LinkedList.Node current = list.getCurrentNode(0);
        while (current != null) {
            System.out.print(current.getElt() + " ");
            current = current.getNext();
        }
    }

    public void printTriangle(int row, int col){
        LinkedList.Node current = list.getCurrentNode(0);
        int i = 1;
        int exp = 0;
        while(current != null) {
            for(int j = 0; j < i; j++) {
                System.out.print(current.getElt() + " ");
                if(i == row && j == col-1) {
                    exp = current.getElt();
                }
                current = current.getNext();
            }
            System.out.println();
            i++;
        }
        System.out.println("\nExponent elt: " + exp);
    }

    public static void main(String[] args) {
        PascalTriangle triangle = new PascalTriangle();
        triangle.buildPascalTriangle(6);
        triangle.printTriangle(4, 3);
    }
}
