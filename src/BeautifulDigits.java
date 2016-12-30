import java.util.Stack;

/**
 * Created by ousmane on 12/19/16.
 */
public class BeautifulDigits {

    public int countBeautiful(String str){
        int i=0, j=0, count = 0;
        boolean found = false;
        Stack<Character> stack = new Stack<>();
        for(; i < str.length(); ){
            if(str.charAt(i) == '0'){
                stack.push(str.charAt(i));
                for(j=i+1; j<=i+2 && j < str.length(); j++){
                    if(str.charAt(j) != stack.peek()){
                        found = true;
                        stack.push(str.charAt(j));
                    }else {
                        found = false;
                        emptyStack(stack);
                        break;
                    }
                }
                if(found){
                    i = j;
                    emptyStack(stack);
                    count++;
                }else i++;
            }else i++;
        }
        return count;
    }

    private void emptyStack(Stack<Character> stack){
        while(!stack.isEmpty()){
            stack.pop();
        }
    }

    public static void main(String[] args){
        BeautifulDigits bd = new BeautifulDigits();
        System.out.println("Count is: " + bd.countBeautiful("0101010"));
        System.out.println("Count is: " + bd.countBeautiful("01100"));
        System.out.println("Count is: " + bd.countBeautiful("0100101010"));
    }
}
