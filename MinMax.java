/**
 * Created by ousmane on 11/14/16.
 */
public class MinMax {
    private static final int MAX_VALUE = Integer.MAX_VALUE;
    private static final int MIN_VALUE = Integer.MIN_VALUE;

    private static int getMinValue(int[] arr){
        int minValue = MAX_VALUE;
        for(int i=0; i < arr.length; i++){
            if(arr[i] < minValue) minValue = arr[i];
        }
        return minValue;
    }

    private static int getMaxValue(int[] arr){
        int maxValue = MIN_VALUE;
        for(int i=0; i < arr.length; i++){
            if(arr[i]  > maxValue) maxValue = arr[i];
        }
        return maxValue;
    }

    private static void minMax(int[] arr){
        int min = getMinValue(arr);
        int max = getMaxValue(arr);
        System.out.println("{"+min+","+max+"}");
    }

    public static void main(String[] args){
        MinMax.minMax(new int[]{1,2,3,4,5});
        MinMax.minMax(new int[]{233454, 5});
        MinMax.minMax(new int[]{1});
    }
}
