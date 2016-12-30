/**
 * Created by ousmane on 12/20/16.
 */
public class CamelCase {

    public int countWords(String str){
        if(str.isEmpty()) return 0;
        else {
            int count = 1;
            for(int i=1; i < str.length(); i++){
                if((int) str.charAt(i) >= 65 && (int) str.charAt(i) <= 90){
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args){
        CamelCase camelCase = new CamelCase();
        System.out.println(camelCase.countWords("saveChangesInTheEditor"));
    }
}
