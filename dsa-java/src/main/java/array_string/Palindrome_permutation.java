package array_string;
//Palindrome Permutation for a string, check if it is a permutation of a palindrome
//for that we use a common class which has 2 methods -
//getCharNumber - gets the input character's numeric value
//buildCharFrequencyTable - creates a frequency table which is of the length
//of all the available lowercase characters and if the numeric value
//is there then it increments the count for that character in the table
class Common{
    public static int getCharNumber(Character c){
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');

        int val = Character.getNumericValue(c);
        if(a <= val && val <= z){
            return val - a;
        }
        return -1;//this is when we have an uppercase character
    }
    /*public static int[] buildCharFreqTable(String phrase){
        //table array - ascii of a to z + 1 to include all the 26 characters
        int[] table = new int[Character.getNumericValue('z')-Character.getNumericValue('a')+1];
        for(char c : phrase.toCharArray()){
            int x = getCharNumber(c);
            if(x != -1){
                table[x]++;
            }
        }
        return table;
    }*/
}
public class Palindrome_permutation {
    /*Toggle the ith bit in the integer*/
    public static int toggle(int bitVector, int index){
        if(index < 0){
            return bitVector;
        }
        int mask = 1 << index;
        if((bitVector & mask)==0){
            bitVector |= mask;//set to 1
            System.out.println("In if loop "+bitVector);
        }else{
            bitVector &= ~mask;//set to 0
            System.out.println("In else loop "+bitVector);
        }
        System.out.println("final bitvector is:"+ bitVector);
        return bitVector;
    }
    /*
    * Create bit vector for string. For each letter with value 'i' toggle the ith bit
    * */
    public static int createBitVector(String phrase){
        int bitVector = 0;
        for(char c: phrase.toCharArray()){
            int x = Common.getCharNumber(c);
            bitVector = toggle(bitVector,x);
            System.out.println("After toggle"+bitVector);
        }
        return bitVector;
    }
    /*
    * Check at least one is set to 1 by subtracting one from the integer
    * and ANDing with the original integer
    * */
    public static boolean checkAtMostOneBitSet(int bitVector){
        return (bitVector & (bitVector - 1)) == 0;
    }

    public static boolean isPalindromePermutation(String phrase){
        int bitVector = createBitVector(phrase);
        System.out.println("The created bit vector: "+ bitVector);
        return checkAtMostOneBitSet(bitVector);
    }
    public static void main(String[] args){
        String phrase = "Tact Coa";
        System.out.println(isPalindromePermutation(phrase));
    }
}
