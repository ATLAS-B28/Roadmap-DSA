package array_string;

public class URLify {
    public static String urlify(String str){
        char[] charArray = str.toCharArray();
        int spaceCount = 0;

        for (char value : charArray) {
            if (value == ' ') {
                spaceCount++;
            }
        }
        //calculate the new length of urlified string
        int newLength = str.length() + 2 * spaceCount;
        char[] urilifiedArray = new char[newLength];

        //copy the original string to the new array
        int urlifiedIndex = 0;
        for (char c : charArray) {
            if (c == ' ') {
                urilifiedArray[urlifiedIndex++] = '%';//assign the value of % to the new array and increment the index 
                urilifiedArray[urlifiedIndex++] = '2';
                urilifiedArray[urlifiedIndex++] = '0';
            } else {
                urilifiedArray[urlifiedIndex++] = c;
            }
        }
        return new String(urilifiedArray);
    }
    public static void main(String[] args){
        String str = "Mr John Smith    ";
        System.out.println(urlify(str));
    }
}
