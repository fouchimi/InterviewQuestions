/**
 * Created by ousmane on 12/19/16.
 */
public class ReducedString {

    public String reducedString(String str){
        if(str.isEmpty()) return "";
        else {
            String answer = "";
            int i=0, index = 0;
            while(i <str.length()-1){
                int count=1;
                boolean flag = false;
                for(; i<str.length()-1; i++){
                    if(str.charAt(i) == str.charAt(i+1)) count++;
                    else {
                        index = i+1;
                        flag = true;
                        break;
                    }
                }
                if(flag) i = index;
                if(count%2 != 0) answer+=str.charAt(i-1);
                if(flag && i==str.length()-1) answer+=str.charAt(i);
            }
            if(answer.equals(str)) return answer;
            else return reducedString(answer);
        }
    }

    public static void main(String[] args){
        ReducedString rs = new ReducedString();
        rs.reducedString("aaabccddd");
        rs.reducedString("abccddd");
        rs.reducedString("abddd");
        rs.reducedString("baab");
        if(!rs.reducedString("aaabccddd").isEmpty()){
            System.out.println(rs.reducedString("aaabccddd"));
        }
        if(!rs.reducedString("abccddd").isEmpty()){
            System.out.println(rs.reducedString("abccddd"));
        }
        if(!rs.reducedString("abddd").isEmpty()){
            System.out.println(rs.reducedString("abddd"));
        }
        if(!rs.reducedString("baab").isEmpty()){
            System.out.println(rs.reducedString("baab"));
        }else {
            System.out.println("Your String is empty ...");
        }
    }
}
