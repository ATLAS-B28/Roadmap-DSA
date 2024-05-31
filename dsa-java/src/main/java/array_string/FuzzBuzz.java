package array_string;

import java.util.ArrayList;
import java.util.List;

public class FuzzBuzz {
    public static List<String> FizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            if(i % 3 == 0 && i % 5 == 0) {
                result.add("FuzzBuzz");
            } else if(i % 3 == 0) {
                result.add("Fuzz");
            } else if(i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(i));
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int n = 20;

        List<String> result = FizzBuzz(n);

        for(String s: result) {
            System.out.println( s + " ");
        }
    }

}
