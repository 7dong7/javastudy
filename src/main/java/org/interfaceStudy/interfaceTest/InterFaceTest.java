package org.interfaceStudy.interfaceTest;

// 클래스A 와 클래스B 의 기본적인 상호작용
public class InterFaceTest {
    public static void main(String[] args) {
        AUser1 a = new AUser1();
        a.MethodA(new BProvider1());
    }
}

// 사용자
class AUser1 {
    public void MethodA(BProvider1 b) {
        b.methodB();
    }
}

// 제공자
class BProvider1 {
    public void methodB() {
        System.out.println("methodB() 호출");
    }
}
