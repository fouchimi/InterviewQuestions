/**
 * Created by ousmane on 12/27/16.
 */
public class KthLargestElement {

    private int size = 0;
    private int[] heap;

    public int kthLargest(int[] A, int k){
        heap = new int[A.length+1];
        for(int i=0; i < A.length; i++){
            add(A[i]);
        }
        for(int i=1; i <size; i++){
            System.out.print(heap[i] + " ");
        }
        int val = 0;
        while(k > 0){
            val = deleteMax();
            k--;
        }
        System.out.println();
        return val;
    }

    public void add(int val){
        if(size == 0) {
            size=1;
            heap[1] = val;
        }else{
            heap[size] = val;
        }
        maxHeapify(heap, size);
        size++;
    }

    private void maxHeapify(int[]A, int index){
        int parent = parent(index);
        if(parent > 0){
            if(A[parent] < A[index]){
                int temp = A[parent];
                A[parent] = A[index];
                A[index] = temp;
            }
            maxHeapify(A, parent);
        }
    }

    private int deleteMax(){
        int max = heap[1];
        size--;
        heap[1] = heap[size];
        swim(heap, 1);
        return max;
    }

    private void swim(int[]A, int index){
        int l= left(index);
        int r = right(index);
        int min = index;
        if(l <= size && A[l] > A[index]) min = l;
        if(r <= size && A[r] > A[min]) min = r;
        if(min != index){
            int temp = A[min];
            A[min] = A[index];
            A[index] = temp;
            swim(A, min);
        }
    }

    private int parent(int elt){
        return elt/2;
    }

    private int left(int index){
        return 2*index;
    }

    private int right(int index){
        return 2*index+1;
    }

    public static void main(String[] args){
        KthLargestElement kthLE = new KthLargestElement();
        int k = 2;
        int[] A = {3,2,1,5,6,4};
        System.out.println(kthLE.kthLargest(A, k));
    }

}
