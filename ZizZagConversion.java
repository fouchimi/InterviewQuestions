/**
 * Created by ousmane on 12/5/16.
 */
public class ZizZagConversion {

    public String converZigZig(String s, int rows){
        int n = s.length();
        int firstIncrement = n/rows;
        int secondIncrement = n%rows;
        String result="";
        int i=0, count = 0;
        while(i < rows){
            while(count < n){
                if(i%2==0){
                    result += s.charAt(count) + " ";
                    count+=firstIncrement;
                }else{
                    result += s.charAt(count);
                    count +=secondIncrement;
                }
            }
            result +="\n";
            i++;
            count=i;
        }
        return result;
    }

    public static void main(String[] args){
        ZizZagConversion zizZag = new ZizZagConversion();
        System.out.print(zizZag.converZigZig("PAYPALISHIRING", 3));
    }
}
