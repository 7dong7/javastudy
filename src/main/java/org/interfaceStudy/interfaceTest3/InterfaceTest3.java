package org.interfaceStudy.interfaceTest3;

public class InterfaceTest3 {
    public static void main(String[] args) {
        A a = new A();
        a.methodA();
    }
}

// 인터페이스 I
interface I {
    public abstract void methodB();
}

// 제공자 B
class B implements I {
    @Override
    public void methodB() {
        System.out.println("methodB in B class");
    }

    public String toString() {
        return "class B";
    }
}

// 제 3자 클래스
class InstanceManager {
    public static I getInstance() {
        return new B();
    }
}

// 사용자 A
class A {
    void methodA() {
        I i = InstanceManager.getInstance();
        i.methodB();
        System.out.println(i.toString());
    }
}



