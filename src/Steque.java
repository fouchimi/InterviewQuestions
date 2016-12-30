/**
 * Created by ousmane on 11/25/16.
 */
public class Steque {
    private int size;
    private Node header;

    public Steque(){
        size = 0;
        header = null;
    }
    private class Node {
        private int elt;
        private Node next;
        public Node(){}
        public Node(int elt,  Node next){
            this.elt = elt;
            this.next = next;
        }

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

    public int size(){
        return size;
    }

    public void push(int elt){
        push(header, elt);
    }

    private void push(Node n, int elt){
        if(n== null){
            header = new Node(elt, null);
        }else {
            Node newNode = new Node();
            newNode.setElt(elt);
            newNode.setNext(header);
            header = newNode;
        }
        size++;
    }

    public int pop(){
        return pop(header);
    }

    private int pop(Node n){
        if(size == 0 || n == null) throw new RuntimeException("Steque is empty ...");
        else {
            int val = n.getElt();
            header = n.getNext();
            size--;
            return val;
        }
    }

    public void enqueue(int elt){
        enqueue(header, elt);
    }

    private void enqueue(Node n, int elt){
        if(n == null || size == 0) header = new Node(elt, n);
        else if(size == 1) {
            Node newNode =  new Node(elt, null);
            header.setNext(newNode);
        }else {
            Node current = n;
            while(current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new Node(elt, null));
        }
        size++;
    }

    public void print(){
        Node current = header;
        if(current == null) {
            System.out.println("Steque is empty ...");
        }
        while(current != null){
            System.out.print(current.getElt()+ " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args){
        Steque obj = new Steque();
        obj.push(5);
        obj.push(4);
        obj.push(-1);
        obj.print();
        obj.pop();
        obj.print();
        System.out.println(obj.size());
        obj.pop();
        obj.pop();
        obj.print();
        obj.enqueue(10);
        obj.enqueue(25);
        obj.push(-5);
        obj.print();
        obj.enqueue(43);
        obj.print();
        System.out.println(obj.size());

    }
}
