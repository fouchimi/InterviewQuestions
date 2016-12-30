/**
 * Created by ousmane on 12/6/16.
 */
public class RotatedSortedArray {

    public int search(int[] nums, int target){
        return search(nums, target, 0, nums.length-1);
    }

    private int search(int[] nums, int target, int start, int end){
        if(start > end) return -1;
        int mid = start + (end-start)/2;
        if(nums[mid] == target) return mid;
        else if(nums[start] > nums[end] && nums[start] > target){
            return search(nums, target, mid+1, end);
        }else if(nums[start] <= target && nums[mid] > target){
            return search(nums, target, start, mid-1);
        }else {
            return search(nums, target, start, mid-1);
        }
    }

    public static void main(String[] args){
        RotatedSortedArray rsa = new RotatedSortedArray();
        int[] nums= {4, 5, 6, 7, 0, 1, 2};
        int target = 5;
        int index = rsa.search(nums, target);
        if(index >= 0)
            System.out.println("Index is: " + index + " Value is: " + nums[index]);
        else {
            System.out.println("Invalid index: " + index);
        }
    }
}
