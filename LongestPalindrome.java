
/**
 * Created by ousmane on 12/5/16.
 */
public class LongestPalindrome {

    public String longestPalindrome(String s){
        String longest = "";
        for(int i=0; i < s.length(); i++){
            for(int j=i; j<s.length(); j++){
                if(isPalindrome(s.substring(i, j))){
                    System.out.println(s.substring(i, j));
                    if(s.substring(i, j).length() > longest.length()){
                        longest = s.substring(i, j);
                    }
                }
            }
        }
        return longest;
    }

    private boolean isPalindrome(String s){
        int i=0, j=s.length()-1;
        if(s.length() == 1) return false;
        if(s.length() == 2 && s.charAt(0) == s.charAt(1)) return true;
        else if(s.length() == 2 && s.charAt(0) != s.charAt(1)) return  false;
        else {
            for(; i <= j; i++, j--){
                if(s.charAt(i) != s.charAt(j)) return false;
            }
            return (s.length() % 2 != 0) && (s.charAt(i) == s.charAt(j));
        }
    }

    public static void main(String[] args){
        LongestPalindrome lp = new LongestPalindrome();
        System.out.println("The longest palindrome is: " + lp.longestPalindrome("babad"));
        System.out.println("The longest palindrome is: " + lp.longestPalindrome("cbbd"));
    }
}
