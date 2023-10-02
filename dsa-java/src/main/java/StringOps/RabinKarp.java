package StringOps;

public class RabinKarp {
    /*
    * In this code snippet, d is set to 256, which corresponds to the number of
    * possible ASCII characters. This is a common choice when working with ASCII
    * strings. However, in other contexts or when working with different character
    * encodings, the value of d may be different.
    * */
    public final static int d = 256;
    static void search(String pat,String text,int q){
        int M = pat.length();
        int N = text.length();
        int i,j;
        int p = 0;//hash value for pattern
        int t = 0;//hash value for text
        int h = 1;//multiplier used in rolling hash function

        for(i = 0; i < M -1; i++){
            h = (h * d) % q;//used in subsequent hashing operations
        }
        System.out.println(h);
        //calculate hash of pattern and 1st window of text
        for(i = 0; i < M; i++){
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
            System.out.println("Pattern's hash value is "+p+" and text's hash value is "+t+" at "+i);
        }
        //after the above loop we have the hash value of pattern and first window using the
        //rolling hash function
        //slide the pattern over text one by one
        for(i = 0; i <= N - M; i++){
              // Check the hash values of current window of
              // text and pattern. If the hash values match
              // then only check for characters one by one
            if(p == t){
                //check for characters one by one
                for(j = 0; j < M; j++){
                    if(text.charAt(i+j) != pat.charAt(j)){
                        break;
                    }
                }
                //if all characters are same
                if(j == M){
                    System.out.println(j+" and "+M);
                    System.out.println("Pattern found at index " + i);
                }
            }
            //calculate the hash value for next window of text and remove leading digit, and trailing digit
            if(i < N - M){
               t = (d * (t - text.charAt(i) * h) + text.charAt(i + M)) % q;
               System.out.println("Text's hash value in the subsequent window is "+t+" at "+i);
               //we might get t < 0 ,so we add q to it
               if(t < 0){
                   t = (t + q);
               }
            }
        }
    }
    public static void main(String[] args) {
        String text = "Aditya Bhambere is a good man";
        String pattern = "man";
        int q = 101;
        search(pattern,text,q);
    }
}