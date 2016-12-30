/**
 * Created by ousmane on 11/26/16.
 */
public class LinkedList<I extends Number> {

    private Node header;

    public LinkedList() {
    }

    protected class Node {
        private int elt;
        private Node next;

        public Node() {}

        public int getElt() {
            return elt;
        }

        public void setElt(int elt) {
            this.elt = elt;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public void add(int elt){
        add(header, elt);
    }
    public void push(int elt){
        push(header, elt);
    }

    private void push(Node n, int elt){
        if(n == null){
            header = new Node();
            header.setElt(elt);
            header.setNext(null);
        }else {
            Node newNode = new Node();
            newNode.setElt(elt);
            newNode.setNext(header);
            header = newNode;
        }
    }

    public Node getCurrentNode(int index){
        Node current = header;
        int i = 0;
        while (i < index) {
            current = current.getNext();
            i++;
        }
        return current;
    }



    private void add(Node node, int elt){
        if(node == null) {
            header = new Node();
            header.setElt(elt);
            header.setNext(null);
        }else {
            Node current  = header;
            while(current.getNext() != null) {
                current = current.getNext();
            }
            Node newNode = new Node();
            newNode.setElt(elt);
            current.setNext(newNode);
        }
    }
}
