package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();
        s1.setId(001);
        s1.setName("John");
        s1.setAge(28);

        System.out.println(s1.toString());


    }
}