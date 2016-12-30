import java.util.ArrayList;

/**
 * Created by ousmane on 12/3/16.
 */
public class ParensGenerator {

    public ArrayList<String> generateParens(int count){
        char[] str = new char[2*count];
        ArrayList<String> list = new ArrayList<>();
        generateParens(list, count, count, str, 0);
        return list;
    }

    private void generateParens(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index){
        if(leftRem < 0 || rightRem < leftRem) return;

        if(leftRem == 0 && rightRem == 0){
            list.add(String.copyValueOf(str));
        }else {
            str[index] = '(';
            generateParens(list, leftRem-1, rightRem, str, index+1);
            str[index] = ')';
            generateParens(list, leftRem, rightRem-1, str, index+1);
        }

    }

    public static void main(String[] args){
        ParensGenerator pg = new ParensGenerator();
        ArrayList<String> list = pg.generateParens(3);
        for(String str: list){
            System.out.print(str + " ");
        }
    }
}
