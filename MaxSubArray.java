/**
 * Created by ousmane on 12/3/16.
 */
public class MaxSubArray {

    public void maxSumSubArray(int[] arr){
        int currentMax = Integer.MIN_VALUE;
        int currentMaxSum = Integer.MIN_VALUE;
        int start=0;
        int end= 0;
        int upperBound = 0;
        boolean flag = false;

        for(int i=0; i < arr.length; i++){
            if(currentMax < 0){
               currentMax = arr[i];
               start = i;
               end = i;
            }else{
                currentMax += arr[i];
            }
            if(currentMax > currentMaxSum) {
                currentMaxSum = currentMax;
                upperBound = i;
                flag = true;
            }
        }
        if(flag) end = upperBound;
        System.out.println("Start: " + start + " End: " + end);
        int sum = 0;
        for(int k=start; k<=end; k++){
            System.out.print(arr[k] + " ");
            sum+=arr[k];
        }
        System.out.println("\nThe maximum sum is: " + sum);
    }

    public static void main(String[] args){
        MaxSubArray msa = new MaxSubArray();
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        msa.maxSumSubArray(arr);
    }
}
