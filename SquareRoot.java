import java.util.ArrayList;
import java.util.List;

/**
 * Created by ousmane on 12/27/16.
 */
public class SquareRoot {

    public int sqrt(int num){
        List<Integer> list = new ArrayList<>();
        for(int i=2; i <= num/2; i++){
            if(num%i == 0) list.add(i);
        }

        for(Integer divider : list){
            int count = 2;
            int val=1;
            while (count > 0){
                val *= divider;
                count--;
            }
            if(val == num) return divider;
        }
        return -1;
    }

    public static void main(String[] args){
        SquareRoot squareRoot = new SquareRoot();
        int num = 14;
        int squareValue = squareRoot.sqrt(num);
        if(squareValue != -1) {
            System.out.println("Square root of " + num +" is: " + squareValue);
        }else {
            System.out.println(num + " is not a perfect square");
        }
    }
}
