package org.collectionFrameWork.hashSetEx.ex3;

import java.util.HashSet;

public class HashSetEx3 {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        set.add("abc");
        set.add("abc");
        set.add(new Person2("David", 10));
        set.add(new Person2("David", 10));

        System.out.println("set = " + set); // set = [abc, David : 10, David : 10]
    }
}

class Person2 {
    String name;
    int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person2) {
            Person2 tmp = (Person2) obj;
            return name.equals(tmp.name) && age == tmp.age;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (name + age).hashCode();
    }

    @Override
    public String toString() {
        return name + " : " + age;
    }
}