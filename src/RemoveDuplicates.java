/**
 * Created by ousmane on 12/6/16.
 */
public class RemoveDuplicates {
    public int removeDups(int[] arr){
        int count =1;
        for(int i=1; i < arr.length; i++){
            if(arr[i-1] == arr[i])continue;
            else count++;
        }

        return count;
    }

    public static void main(String[] args){
        RemoveDuplicates rd = new RemoveDuplicates();
        int[] nums = {1,1,1,2, 2,2, 3, 3, 4, 5, 6, 6};
        System.out.println( " The size of new array without duplicates is: " + rd.removeDups(nums));
        int[] nums1 = {1,1,2};
        System.out.println( " The size of new array without duplicates is: " + rd.removeDups(nums1));
        int[] nums2 = {1,1,1,2,2, 3, 3, 4, 5, 6, 6,  7};
        System.out.println( " The size of new array without duplicates is: " + rd.removeDups(nums2));
    }
}
