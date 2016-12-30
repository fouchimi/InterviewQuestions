/**
 * Created by ousmane on 12/20/16.
 */
public class SherklockArray {

    public void findSherkElt(int[] nums){
        int index=0, elt=0, leftSum, rightSum;
        for(int i=0; i < nums.length; i++){
            if(i == 0) {
                //Go Right
                rightSum = sumRight(nums, i+1);
                if(rightSum == nums[i]) {
                    index = i;
                    elt = nums[i];
                    break;
                }
            }
            else if(i==nums.length-1){
                //Go Left
                leftSum = sumLeft(nums, i-1);
                if(leftSum == nums[i]){
                    index = i;
                    elt = nums[i];
                    break;
                }
            }else {
                // Go both ways
                leftSum = sumLeft(nums, i-1);
                rightSum = sumRight(nums, i+1);
                if(leftSum == rightSum) {
                    index = i;
                    elt = nums[i];
                }
            }
        }
        if(elt != 0){
            System.out.println("YES");
            System.out.println("Index is: " + index + " and element is: " + elt);
        }else {
            System.out.println("NO");
            System.out.println("Index is: " + index + " and element is: " + elt);
        }
    }

    private int sumLeft(int[] nums, int start){
        int sum = 0;
        for(int i=start; i >=0; i--) {
            sum += nums[i];
        }
        return sum;
    }

    private int sumRight(int[] nums, int start){
        int sum = 0;
        for(int i=start; i < nums.length; i++){
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args){
        SherklockArray sherklockArray = new SherklockArray();
        int[] nums= {3, 1, 2, 3};
        sherklockArray.findSherkElt(nums);
        int[] vals = {1, 2, 3, 3};
        sherklockArray.findSherkElt(vals);
    }
}
