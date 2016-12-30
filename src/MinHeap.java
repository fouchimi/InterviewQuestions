/**
 * Created by ousmane on 12/25/16.
 */
public class MinHeap {

    private int[] heap;
    private int size = 0;

    public void buildHeap(int[] A){
        int N = A.length;
        heap = new int[N+1];
        size = N;
        for(int i=0; i < N; i++){
            heap[i+1] = A[i];
        }
        for(int i = heap.length/2; i >=0; i--){
            minHeapify(heap, i);
        }

    }

    private void minHeapify(int[] A, int index){
        int l = left(index);
        int r = right(index);
        int min = index;
        if(l <= size() && A[l] < A[index]) min = l;
        if(r <= size() && A[r] < A[min]) min = r;
        if(min != index){
            int temp = A[index];
            A[index] = A[min];
            A[min] = temp;
            minHeapify(A, min);
        }
    }

    private void printHeap(){
        if(!isEmpty()){
            for(int i=1; i <= size; i++){
                System.out.print(heap[i] + " ");
            }
        }
    }


    private int left(int index){
        return 2*index;
    }

    private int right(int index){
        return 2*index+1;
    }

    public void heapSort(){
        int N = size;
        for(int i=1; i <= N; i++){
            if(!isEmpty()){
                System.out.print(extractMin() + " ");
            }
        }
    }

    public void add(int elt){
        if(size < heap.length-1) {
            size++;
            if(size == 1){
                heap[size] = elt;
            }
            else {
                heap[size] = elt;
                swim(size);
            }
        }else {
            extractMin();
            size++;
            heap[size] = elt;
            swim(size);
        }
    }

    private void swim(int index){
        int pIndex = parent(index);
        int min = index;
        if(index > 0 && heap[pIndex] > heap[index]) min = pIndex;
        if(min != index){
            int temp = heap[index];
            heap[index] = heap[min];
            heap[min] = temp;
            swim(min);
        }
    }

    private int parent(int index){
        return index/2;
    }

    private boolean isEmpty(){
        return size == 0;
    }

    private int size(){
        return size;
    }

    private int extractMin(){
        int minHead = heap[1];
        heap[1] = heap[size];
        heap[size] = 0;
        size--;
        minHeapify(heap, 1);
        return minHead;
    }

    public static void main(String[] args){
        int[] A = {5, 13, 2, 25, 7, 17, 20, 8, 4};
        MinHeap minHeap = new MinHeap();
        minHeap.buildHeap(A);
        System.out.println();
        minHeap.heapSort();
        System.out.println();
        minHeap.add(25);
        minHeap.add(7);
        minHeap.add(3);
        minHeap.add(2);
        minHeap.add(13);
        minHeap.add(17);
        minHeap.add(8);
        minHeap.add(4);
        minHeap.add(5);
        minHeap.add(10);
        minHeap.printHeap();
        System.out.println();
        minHeap.heapSort();
    }
}
