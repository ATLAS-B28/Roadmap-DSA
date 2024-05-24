package array_string;

public class CtCIArray {
    //Q1 - check whether all the characters are unique in a given string
    /*public static boolean isUniqueChar(String str){
        if(str.length() > 128){
            return false;
        }
        boolean[] char_set = new boolean[128];
        for(int i = 0; i < str.length(); i++){
            int val = str.charAt(i);
            if(char_set[val]) return false;
            char_set[val] = true;
        }
        return true;
    }*/

    /*
    * s Unique: Implement an algorithm to
    * determine if a string has all unique characters. What if you
    * cannot use additional data structures?
    * */
    public static boolean isUniqueChar(String str){
        if(str.length() > 26){
            return false;
        }
        int checker = 0;//keeps track of occurrences
        for(int i = 0; i < str.length(); i++){
            int val = str.charAt(i)-'a';//the ascii value of ith character - ascii value of 'a'
            //maps the characters from 0-25
            if(((checker) & (1 << val)) > 0) return false;
            //check if corresponding bit for that character is set ot checker
            //if so return false
            //here the comparison is with a bitwise AND operator
            //we shift 1 -> 00000001 to no. of positions defined in val
            //towards the left and create a bitmask
            //example: val = 3, then 1 is shifted by 3 positions and goes to 4th bit,
            //therefore, the new number is 00001000
            checker |= (1 << val);//if not, then the bit for character is set in a checker using
            //bitwise |= operator
            //here we set the value of checker to 1 essentially
        }
        return true;
    }
    public static void main(String[] args){
        String[] words = {"abc","def","hello","jkl","mno","pqr","stu","vwx","yz"};
        for(String word : words){
            System.out.println(word + ": " + isUniqueChar(word));
        }
    }
}
