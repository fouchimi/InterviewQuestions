import java.util.HashSet;

/**
 * Created by ousmane on 12/20/16.
 */
public class Pangrams {

    public boolean isPangram(String sentence){
        HashSet<String> alphabets = new HashSet<>();
        String[] chars = sentence.toLowerCase().split("");
        for(int i=0; i < chars.length; i++){
            if(!chars[i].equals(" "))
                alphabets.add(chars[i]);
        }
        if(alphabets.size() == 26) return true;
        else return false;
    }


    public static void main(String[] args){
        Pangrams pangrams = new Pangrams();

        if(pangrams.isPangram("The quick brown fox jumps over the lazy dog")){
            System.out.println("Pangram");
        }else System.out.println("Is not pangram");
        if(pangrams.isPangram("We promptly judged antique ivory buckles for the next prize")){
            System.out.println("Pangram");
        }else System.out.println("Is not pangram");
        if(pangrams.isPangram("We promptly judged antique ivory buckles for the prize")){
            System.out.println("Pangram");
        }else System.out.println("Is not pangram");


    }
}
