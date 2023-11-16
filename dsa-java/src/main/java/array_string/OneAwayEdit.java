package array_string;

public class OneAwayEdit {
    public static boolean oneEditAway(String first,String second){
        //check length
        if(Math.abs(first.length()-second.length())>1){
            return false;
        }
        //get the shorter one
        String shorter = first.length() < second.length() ? first : second;
        String longer = first.length() < second.length() ? second : first;
        int index1 = 0;
        int index2 = 0;
        boolean foundDiff = false;
        while(index1 < shorter.length() && index2 < longer.length() ){

            if(shorter.charAt(index1) != longer.charAt(index2)){

                if(foundDiff) return false;//ensure first difference found

                foundDiff = true;

                if(shorter.length() == longer.length()){
                    index1++;//replacement then move shorter pointer by 1
                }

            }else{
                index1++;//if match then move shorter pointer by 1
            }
            index2++;//always move the longer pointer
        }
        return true;
    }
    public static void main(String[] args) {
        String first = "pale";
        String second = "ple";
        System.out.println(first+", "+second+": "+oneEditAway(first,second));

        String c = "pale";
        String d = "pkle";
        boolean isOneEdit2 = oneEditAway(c, d);
        System.out.println(c + ", " + d + ": " + isOneEdit2);
    }
}
