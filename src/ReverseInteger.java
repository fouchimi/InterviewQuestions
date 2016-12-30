import java.util.LinkedList;

/**
 * Created by ousmane on 12/5/16.
 */
public class ReverseInteger {
    public int reverse(int num){
        int answer = 0;
        int n = num;
        if(num < 0) n *=(-1);
        LinkedList<Integer> stack = new LinkedList<>();
        while(n > 0){
            stack.add(n%10);
            n=n/10;
        }
        while (!stack.isEmpty()){
            int factor = 1;
            int counter = 1;
            while(counter < stack.size()){
                factor *=10;
                counter++;
            }
            int current = stack.pop();
            int val = current * factor;
            answer +=val;
        }
        if(num < 0) answer *=(-1);
        if(Integer.MIN_VALUE >= answer || answer <= Integer.MAX_VALUE)
            return answer;
        return 0;
    }

    public static void main(String[] args){
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(123));
        System.out.println(ri.reverse(-123));
    }
}
