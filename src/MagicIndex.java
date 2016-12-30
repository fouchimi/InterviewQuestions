/**
 * Created by ousmane on 12/1/16.
 */
public class MagicIndex {

    public boolean findMagicIndex(int[] arr){
        return findMagicIndex(arr, 0, arr.length-1);
    }

    private boolean findMagicIndex(int[] arr, int start, int end){
        if(start > end) return false;
        int mid = start + (end-start)/2;
        if(arr[mid] == mid) return true;
        findMagicIndex(arr, start, mid-1);
        findMagicIndex(arr, mid+1, end);
        return false;
    }

    public static void main(String[] args){
        int[] arr = {-2, -1, 2, 7, 9, 15};
        MagicIndex obj = new MagicIndex();
        boolean answer = obj.findMagicIndex(arr);
        System.out.println(answer);
    }
}
