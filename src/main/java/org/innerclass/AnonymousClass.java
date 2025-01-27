package org.innerclass;

public class AnonymousClass {
    public static void main(String[] args) {

        Greet greet = new Greet() {
            @Override
            public void sayHello() {
                System.out.println("hello");
            }
        };

        greet.sayHello();
    }
}

interface Greet {
    void sayHello();
}