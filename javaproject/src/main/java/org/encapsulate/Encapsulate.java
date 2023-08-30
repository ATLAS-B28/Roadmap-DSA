package org.encapsulate;

class Student{
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;//setter as void then?
    }
}
public class Encapsulate {
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("Abhijeet");
        System.out.println(s.getName());
    }
}
