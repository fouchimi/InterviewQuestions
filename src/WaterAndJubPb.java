import java.util.Stack;

/**
 * Created by ousmane on 12/27/16.
 */
public class WaterAndJubPb {

    public boolean canMeasureWater(int x, int y, int z){
        Stack<Integer> first = new Stack<>();
        Stack<Integer> second = new Stack<>();
        int min=0, max=0;
        if(x < y){
            min = x;
            max = y;
        }else {
            min = y;
            max = x;
        }
        while(sumBoth(first, second) < z){
            first.push(min);
            if(second.isEmpty()){
                second.push(first.peek());
                first.pop();
            }else if(!isFull(second, max)){
               if(sumSingle(first) + sumSingle(second) <= max){
                   second.push(first.peek());
                   first.pop();
               }else if(sumSingle(first) + sumSingle(second) > max){
                   int sum = sumSingle(second);
                   int remaining = max - sum;
                   second.push(remaining);
                   int rem = first.peek()-remaining;
                   if(rem <= min){
                       first.pop();
                       first.push(rem);
                       if(isFull(second, max)){
                           while(!second.isEmpty()){
                               second.pop();
                           }
                           second.push(first.peek());
                           first.pop();
                       }
                   }
               }
            }else if(isFull(first, min) && isFull(second, max)) {
                int sum = sumBoth(first, second);
                if(sum > z || sum < z) return false;
                return true;
            }
        }
        return sumBoth(first, second) == z;
    }

    private int sumBoth(Stack<Integer> first, Stack<Integer> second){
        int sum = 0;
        if(!first.isEmpty()){
            sum = sumSingle(first);
        }
        if(!second.isEmpty()){
            sum += sumSingle(second);
        }
        return sum;
    }

    private int sumSingle(Stack<Integer> first){
        int sum = 0;
        if(!first.isEmpty()){
            for(Integer val : first){
                sum += val;
            }
        }
        return sum;
    }

    private boolean isFull(Stack<Integer> stack, int capacity){
        return sumSingle(stack) >= capacity;
    }

    public static void main(String[] args){
        WaterAndJubPb waterAndJubPb = new WaterAndJubPb();
        System.out.println(waterAndJubPb.canMeasureWater(3, 5, 4));
        System.out.println(waterAndJubPb.canMeasureWater(2, 6, 5));
    }
}
