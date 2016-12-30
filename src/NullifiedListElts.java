import java.util.ArrayList;
import java.util.List;

/**
 * Created by ousmane on 11/27/16.
 */
public class NullifiedListElts {

    public void findNullifyElts(int[] arr){
        sort(arr);
        int firstIndex = findFirstPositiveIndex(arr);
        int i=0;
        String allList = "";
        List<Integer> usedElements = new ArrayList<>();
        List<Integer> nonUsedElements = new ArrayList<>();
        while(arr[i] < 0) {
            for(int j= firstIndex; j<arr.length;){
                String list = arr[i] +",";
                int complement = (-1)*arr[i] - arr[j];
                if(complement >= arr[j]) {
                    list += arr[j] +",";
                    if(!usedElements.contains(arr[j])){
                        usedElements.add(arr[j]);
                    }
                    boolean answer = search(arr, complement, j+1, arr.length-1);
                    if(answer){
                        list +=complement;
                        if(!usedElements.contains(complement)){
                            usedElements.add(complement);
                        }
                    }else  list = "";
                }else if(complement == 0){
                    list += arr[j];
                    if(!usedElements.contains(arr[j])){
                        usedElements.add(arr[j]);
                    }
                }else {
                    list = "";
                }
                if(!list.isEmpty()){
                    allList += list +"\n";
                }
                j++;
            }
            i++;
        }

        for(int k= firstIndex; k < arr.length; k++){
            if(!usedElements.contains(arr[k])){
                nonUsedElements.add(arr[k]);
            }
        }

        System.out.println("\n"+ allList);
        System.out.print("List of non used elements ");
        for(Integer item : nonUsedElements){
            System.out.print(item + " ");
        }
        System.out.println();
    }

    private boolean search(int[] arr, int key, int start, int end){
        if(start >= end) return false;
        int mid = (end+start)/2;
        if(arr[mid] == key) return true;
        else if(arr[mid] < key) return search(arr, key, start, mid-1);
        else return search(arr, key, mid+1, end);
    }

    private int findFirstPositiveIndex(int[] arr){

        for(int i=0; i<arr.length; i++){
            if(arr[i] > 0) return i;
        }
        return -1;
    }

    private void sort(int[] arr){
        quickSort(arr, 0, arr.length-1);
        printArray(arr);
    }

    private void quickSort(int[] arr, int start, int end){
        if(start >= end) return;
        int pIndex = partition(arr, start, end);
        quickSort(arr, start, pIndex-1);
        quickSort(arr, pIndex+1, end);
    }

    private int partition(int[] arr, int start, int end){
        int pivot = arr[end];
        int pIndex = start;
        for(int i= start; i<=(end-1); i++){
            if(arr[i] <= pivot){
                swap(arr, i, pIndex);
                pIndex++;
            }
        }
        swap(arr, pIndex, end);
        return pIndex;
    }

    private void swap(int[] arr, int p, int q){
        int temp= arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }

    private void printArray(int[] arr){
        for(int i=0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args){
        NullifiedListElts obj = new NullifiedListElts();
        int[] arr= {6, -6, 8, 4, -12, 9, 8, -8};
        obj.findNullifyElts(arr);
        int[] newArr = {4, 6, -10, 8, 9, 10, -19, 10, -18, 20, 25};
        obj.findNullifyElts(newArr);
    }
}
