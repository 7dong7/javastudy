package org.interFace.interfaceTest;

// 클래스A 와 클래스B 의 기본적인 상호작용
public class InterFaceTest {
    public static void main(String[] args) {
        A a = new A();
        a.MethodA(new B());
    }
}

// 사용자
class A {
    public void MethodA(B b) {
        b.methodB();
    }
}

// 제공자
class B {
    public void methodB() {
        System.out.println("methodB() 호출");
    }
}
