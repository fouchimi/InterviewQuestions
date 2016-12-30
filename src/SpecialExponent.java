import java.util.Scanner;
import java.util.Stack;

/**
 * Created by ousmane on 11/15/16.
 */
public class SpecialExponent {
    private static Stack<Integer> stack = new Stack<>();

    private static void printSpecialExponent(int num){
        int oldNum = num;
        while(num > 10){
            int remainder = num % 10;
            stack.push(remainder);
            num = (num - remainder) / 10;
        }
        stack.push(num);
        int value = 0;
        int size = stack.size();
        for(int i=1; i <= size; i++){
            int j = i;
            int result = 1, val = stack.pop();
            while(j>0){
                result *= val;
                j--;
            }
            value += result;
        }
        if(value == oldNum) {
            System.out.println(value);
        }
    }

    public static void getRange(int[] arr){
        for(int i=arr[0]; i<=arr[1]; i++){
            printSpecialExponent(i);
        }
    }

    public static void main(String[] args){
        System.out.print("Enter lower bound: ");
        Scanner input = new Scanner(System.in);
        int firstValue = input.nextInt();
        System.out.println(firstValue);
        System.out.print("Enter upper bound: ");
        int secondValue = input.nextInt();
        System.out.println(secondValue);
        int[] arr = new int[]{firstValue, secondValue};
        SpecialExponent.getRange(arr);
    }
}
