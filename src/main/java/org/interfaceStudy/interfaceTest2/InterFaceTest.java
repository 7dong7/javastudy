package org.interfaceStudy.interfaceTest2;

public class InterFaceTest {
    public static void main(String[] args) {
        A a = new A();
        a.methodA(new B());
        a.methodA(new C());
    }
}
// 인터페이스 I
interface I {
    public abstract void methodB();
}

// 사용자
class A {
    public void methodA(I i) {
        i.methodB();
    }
}

// 제공자
class B implements I{
    public void methodB() {
        System.out.println("methodB() 클래스 B에서 호출");
    }
}

class C implements I{
    public void methodB() {
        System.out.println("methodB() 클래스 C에서 호출");
    }
}
