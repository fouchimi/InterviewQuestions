/**
 * Created by ousmane on 11/25/16.
 */
public class BitonicSearch {

    private int findIndex(int[] arr){
        return findDelimiter(arr, 0, arr.length);
    }

    public int search(int[] arr, int key){
        int delimiter = findIndex(arr);
        if((arr[delimiter] > key && delimiter > 0 &&
                arr[delimiter-1] > arr[delimiter])
                || (arr[delimiter] < key)){
            return searchUpper(arr, key,  0, delimiter-1);
        }else if(arr[delimiter] > key) {
            return searchLower(arr, key, delimiter+1, arr.length-1);
        }else {
            return delimiter;
        }
    }

    private int searchUpper(int arr[], int key, int start, int end){
        int mid = (end+start)/2;
        if(arr[mid] == key) return mid;
        else if(arr[mid] < key) {
            return searchUpper(arr, key, mid+1, end);
        }else if(arr[mid] > key) {
            return searchUpper(arr, key, start, mid-1);
        }else return -1;
    }

    private int searchLower(int arr[], int key, int start, int end){
        int mid = (end+start)/2;
        if(arr[mid] == key) return mid;
        else if(arr[mid] < key) {
            return searchLower(arr, key, start, mid-1);
        }else if(arr[mid] > key){
            return searchLower(arr, key, mid+1, end);
        }else return -1;
    }

    private int findDelimiter(int[] arr, int low, int high){
        int mid = (low + (high-low)/2);
        if(low == high) return low;
        else if(arr[mid-1] > arr[mid] && arr[mid] > arr[mid+1]){
            return findDelimiter(arr, low, mid-1);
        }else return findDelimiter(arr, mid+1, high);
    }

    public static void main(String[] args){
        BitonicSearch obj = new BitonicSearch();
        int[] arr = {1, 3, 5, 7, 6, 5, 4, -1, -2, -4};
        System.out.println(obj.search(arr, 5));
    }
}
