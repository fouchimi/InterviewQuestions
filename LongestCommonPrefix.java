/**
 * Created by ousmane on 12/7/16.
 */
public class LongestCommonPrefix {

    private Node root = null;

    private class Node {
        String value;
        Node[] children = new Node[26];

    }

    public void put(String str){
        root = put(root, str, str, 0);
    }

    private Node put(Node x, String key, String value, int d){
        if(x == null) x = new Node();
        if(d == key.length()) {
            x.value = value;
            return  x;
        }
        char c = key.charAt(d);
        int index = c%26;
        x.children[index] = put(x.children[index], key, value, d+1);
        return x;
    }

    public String get(String key){
        return get(root, key, 0);
    }

    private String get(Node x, String key, int d){
        if(x == null) return null;
        if(d == key.length()) return x.value;
        char c = key.charAt(d);
        int index = c%26;
        return get(x.children[index], key, d+1);
    }

    public String longestPrefixLength(String[] strings){
        boolean flag = false;
        String currentIndex = "";
        String longest = "";
        int count= 0;
        for(String s : strings){
            longest = search(root, s,  0);
            if(flag == false) {
                currentIndex = longest;
                count++;
                flag = true;
            }
            else if(flag && longest.equals(currentIndex)){
                count++;
            }
        }
        if(count == strings.length) return longest;
        else return null;
    }

    private String search(Node x, String key, int d){
        if(x == null) return null;
        if(x.value != null){
            return x.value;
        }
        if(d == key.length()) return x.value;
        char c = key.charAt(d);
        int index = c%26;
        return search(x.children[index], key,d+1);
    }

    public static void main(String[] args){
        LongestCommonPrefix lcs = new LongestCommonPrefix();
        String[] strs = {"abc", "abcd", "abccdef"};
        for(String s : strs) {
            lcs.put(s);
        }
        if(lcs.longestPrefixLength(strs) != null) {
            System.out.println("The common prefix: " + lcs.longestPrefixLength(strs));
        }
    }

}
