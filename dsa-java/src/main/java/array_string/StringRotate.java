package array_string;

public class StringRotate {
    //isSubstring - big and small string and using indexOf() >= 0 for the small
    //string then it is there in the big string even though it is at 0th position or more
    public static boolean isSubstring(String big,String small){
        return big.contains(small);
    }
    public static boolean isRotation(String s1,String s2){
        int len = s1.length();
        //check for the s1 and s2 are equal and not empty
        if(len == s2.length() && len > 0){
            //concatenate s1 with itself and then call isSubstring
            String s1s1 = s1 + s1;
            return isSubstring(s1s1,s2);
        }
        return false;
    }
    public static void main(String[] args) {
        String[][] pairs = {
            {"apple","pleap"},
            {"carrot","ctaror"},
            {"cat","act"},
        };
        for(String[] pair : pairs){
            String word1 = pair[0];
            String word2 = pair[1];
            boolean is_rotation = isRotation(word1,word2);
            System.out.println(word1 + " and " + word2 + " are " + (is_rotation ? "anagrams" : "not anagrams"));
        }
    }
}
