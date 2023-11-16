package array_string;
import java.util.regex.*;
public class searchString {
    //pattern searching in text
    //first regex in java
    //use this to do pattern search
    /*public static void main(String[] args) {
        String input = "Hello, 20020 world!";
        //define the pattern
        String pattern = "\\d+";
        //compile the pattern
        Pattern regexPattern = Pattern.compile(pattern);
        //create Matcher object
        Matcher matcher = regexPattern.matcher(input);
        //find and print the occurrences of the pattern
        while(matcher.find()){
            String match = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            System.out.println(match + " found at start index at " + start + " and end index at " + end);
        }
    }*/
    /*
    * This class also defines methods for replacing matched subsequences with
    * new strings whose contents can, if desired, be computed from the match result.
    * The appendReplacement and appendTail methods can be used in tandem in order to
    * collect the result into an existing string buffer or string builder.
    * Alternatively, the more convenient replaceAll method can be used to create a
    * string in which every matching subsequence in the input sequence is replaced.
    * */
    //using the above two
    public static void main(String[] args){
        //here string builder is used allowing to do manipulations
        String input = "Hello, $name! How are you, $name?";
        String pattern = "\\$name";
        String replaceWith = "Aditya";
        Pattern matchPattern = Pattern.compile(pattern);
        Matcher matcher = matchPattern.matcher(input);
        //appendReplacement
        StringBuilder sb = new StringBuilder();
        while(matcher.find()){
            matcher.appendReplacement(sb,replaceWith);
        }
        //appendTail
        matcher.appendTail(sb);
        String modifiedStrong = sb.toString();
        System.out.println(modifiedStrong);
    }
}
