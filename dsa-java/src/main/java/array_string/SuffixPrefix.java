package array_string;

public class SuffixPrefix {
    public static void main(String[] args) {
        String input = "Aditya Bhambere";
        int suffixLen = 8;
        char[] suffixArr = new char[suffixLen];
        for(int i = 0; i < suffixLen; i++){
            suffixArr[i] = input.charAt(i+1);
        }
        String suffix = new String(suffixArr);
        System.out.println(suffix);
        String prefix = input.substring(0, input.length()-suffixLen);
        System.out.println(prefix);
    }
}
