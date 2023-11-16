package array_string.StringOps;

public class SubString {
    //sub string search algorithms
    public static int bruteForce(String text,String pattern){
        int n = text.length();
        int m = pattern.length();
        for(int i = 0; i <= n-m-1; i++){//'i' is index of potential match between substring and text
            //i <= n-m means only the potential matches up to the point where
            //remaining characters are equal or greater than the length of the pattern(aka substring)
            //this is so that if there are lesser characters in the text than in the pattern
            //the -1 is to deal with whitespace
            int j;
            for(j = 0; j < m; j++){//this is to iterate over the pattern
                if(text.charAt(i+j) != pattern.charAt(j)){
                    //this loop runs for j's iterations for each value of i
                    //if i+j index of text is not a match to jth of substring
                    break;
                }
            }//if no mismatch is found
            if(j==m){
                return i;
            }
        }
        return -1;
    }
    //KMP Algorithm section
    public static int[] partialMatchTable(String pattern){
        int[] table = new int[pattern.length()];
        int i=0,j=1;
        //'i' is index of the character in the pattern that
        // we are currently comparing
        //and 'j' is index of the next character in the pattern
        while(j < pattern.length()){
            if(pattern.charAt(i) == pattern.charAt(j)){
                table[j] = i + 1;//if match we set i+1 as value of jth
                //indicating that prefix of length i+1 is also suffix of the string
                i++;
                j++;
            }else{
                if(i != 0 ){//if true then already some characters matched
                    i = table[i-1];//and we set i to previous value of i
                    //so that we don't have to perform unnecessary comparisons
                }else{//if i = 0 then we have no match so far
                    table[j] = 0;//and we set j to 0
                    //i.e. there is no partial match at this position and increment
                    //to j by 1
                    j++;
                }
            }
        }
        return table;
    }
    public static int search(String text,String pattern){
        int[] table = partialMatchTable(pattern);
        int i = 0,j = 0;//'i' is index of text and 'j' is index of pattern
        while(i < text.length()){
            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
                if(j == pattern.length()){//means complete match is found
                    return i - j;
                    //return starting index where we started finding the match
                }
            }else{//if no match
                if(j != 0){//if j not 0 means some match were found
                     j = table[j-1];//to skip unnecessary comparisons we go one index back
                }else{//if not
                    i++;//we just find increment i by 1
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String text = "Aditya Bhambere is a good man";
        String pattern = "good";
        String text2 = "ABAABAACAADAABAAAB";
        String pattern2 = "AABA";
        int index = bruteForce(text,pattern);
        if(index != -1){
            System.out.println("Pattern found at index: "+index);
        }else{
            System.out.println("Pattern not found");
        }
        int index2 = search(text2,pattern2);
        if(index2 != -1){
            System.out.println("Pattern found at index: "+index2);
        }else{
            System.out.println("Pattern not found");
        }
    }
}
