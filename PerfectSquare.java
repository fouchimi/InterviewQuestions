import java.util.ArrayList;
import java.util.List;

/**
 * Created by ousmane on 12/27/16.
 */
public class PerfectSquare {

    public boolean isPerfectSquare(int num){
        List<Integer> list = new ArrayList<>();
        for(int i=2; i <= num/2; i++){
            if(num%i == 0) list.add(i);
        }

        for(Integer divider: list){
            int count = 2;
            int val=1;
            while(count > 0){
                val *=divider;
                count--;
            }
            if(val == num) return true;
        }
        return false;
    }

    public static void main(String[] args){
        PerfectSquare perfectSquare = new PerfectSquare();
        System.out.println(perfectSquare.isPerfectSquare(16));
        System.out.println(perfectSquare.isPerfectSquare(14));
    }
}
