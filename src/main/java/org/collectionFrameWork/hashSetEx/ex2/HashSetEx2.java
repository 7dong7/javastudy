package org.collectionFrameWork.hashSetEx.ex2;

import java.util.HashSet;

public class HashSetEx2 {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        set.add("abc");
        set.add("abc");
        set.add(new Person("David", 10));
        set.add(new Person("David", 10));

        System.out.println("set = " + set); // set = [abc, David : 10, David : 10]
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return name + " : " + age;
    }
}