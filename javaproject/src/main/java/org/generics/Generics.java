package org.generics;

/*class Box<T>{
    private T contents;
    public void setContents(T contents) {
      this.contents = contents;
    }
    public T getContents(){
        return contents;
    }
}

*/
class Box<T>{
    public T contents;
    public void setContents(T contents){
        this.contents = contents;
    }
    public T getContents(){
        return contents;
    }
}

public class Generics {
    public static void main(String[] args){
        Box<String> stringBox = new Box<>();
        stringBox.setContents("Abhijeet");
        String contents = stringBox.getContents();
        System.out.println(contents);

        Box<Integer> intBox = new Box<>();

        intBox.setContents(10);
        int content1 = intBox.getContents();
        System.out.println(content1);
    }
}
