package recursive;

public class Recursive {
    public static int factorail(int n){
        if(n==0){
            return 1;
        }else {
            return n * factorail(n - 1);
        }
    }
    public static void main(String[] args){
        System.out.println(factorail(5));
    }
}
