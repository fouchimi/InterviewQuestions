/**
 * Created by ousmane on 11/27/16.
 */
public class MaxRangeElts {

    public void maxNbrOfConsecNbrs(int[] arr){
        sort(arr);
        int i=0, j=1, startIndex=0, endIndex=0;
        boolean flag;
        while(i < arr.length){
            flag = false;
            while(j<arr.length &&  (arr[j]-arr[j-1] == 1)) {
                flag = true;
                j++;
            }
            if(flag){
                j--;
                if((j-i+1) > (endIndex-startIndex+1)){
                    startIndex = i;
                    endIndex = j;
                }
                i=j+1;
                j=i+1;
            }else {
                i=j;
                j=i+1;
            }
        }
        System.out.println("\n");
        for(int k=startIndex; k<=endIndex; k++){
            System.out.print(arr[k]+"  ");
        }
    }

    public void sort(int[] arr){
        quickSort(arr, 0, arr.length-1);
        print(arr);
    }
    private void quickSort(int[] arr, int start, int end){
        if(start >= end) return;
        int index = partition(arr, start, end);
        quickSort(arr, start, index-1);
        quickSort(arr, index+1, end);
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int pIndex = start;
        int temp = 0;
        for(int i= start; i <= (end-1); i++){
            if(arr[i] <= pivot){
                temp = arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex] = temp;
                pIndex++;
            }
        }

        temp = arr[pIndex];
        arr[pIndex] = arr[end];
        arr[end] = temp;

        return pIndex;

    }

    private void print(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args){
        MaxRangeElts mre = new MaxRangeElts();
        int[] arr = {1, 94, 93, 4, 1000, 2, 3, 92, 5, 1001};
        mre.maxNbrOfConsecNbrs(arr);
    }

}
