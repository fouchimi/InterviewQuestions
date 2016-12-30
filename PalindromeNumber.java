/**
 * Created by ousmane on 12/6/16.
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x){
        int[] arr = new int[1];
        int i=0;
        while(x > 0){
            int remainder = x%10;
            arr[i++] = remainder;
            arr = resizeArray(arr, i+1);
            x = x/10;
        }
        print(arr);
        int k=0, l= arr.length-2;
        for(; k <= l; k++, l--){
            if(arr[k] != arr[l]) return false;
        }
        if(arr[k] == arr[l] && arr.length-1 == 2) return true;
        else if((arr[k] == arr[l] && ((arr.length-1) % 2) != 0)){
            return true;
        }
        return false;
    }

    private void print(int[] arr){
        for(int i=0; i < arr.length-1; i++){
            System.out.print(arr[i] + " ");
        }
    }

    private int[] resizeArray(int[] arr, int n){
        int[] cloneCopy = new int[n];
        for(int i=0; i<arr.length; i++){
            cloneCopy[i] = arr[i];
        }
        arr = cloneCopy;
        return arr;
    }

    public static void main(String[] args){
        PalindromeNumber pn = new PalindromeNumber();
        System.out.println(pn.isPalindrome(121));
        System.out.println(pn.isPalindrome(55));
        System.out.println(pn.isPalindrome(1441));
        System.out.println(pn.isPalindrome(14241));
    }
}
