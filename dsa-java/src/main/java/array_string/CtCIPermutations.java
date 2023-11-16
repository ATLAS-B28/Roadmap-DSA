package array_string;

import java.util.Arrays;
public class CtCIPermutations {
    public static String sort(String str){
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }
    public static boolean permutations(String s,String t){
        return sort(s).equals(sort(t));
    }
    public static void main(String[] args){
        String[][] pairs = {
                {"apple","papel"},
                {"carrot","tarroc"},
                {"cat","act"},
        };
        for(String[] pair : pairs){
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = permutations(word1,word2);
            System.out.println(word1 + " and " + word2 + " are " + (anagram ? "anagrams" : "not anagrams"));
        }
    }
}
