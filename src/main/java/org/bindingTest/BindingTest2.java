package org.bindingTest;

public class BindingTest2 {
    // 부모 클래스에 멤버가 정의되고 자식 클래스에 아무것도 정의되지 않은 상태
    public static void main(String[] args) {
        Parent2 p = new Child2();
        Child2 c = new Child2();
        /**
         * 자식 클래스에서 선택할 멤버 x, method() 의 경우 선택의 여지 없이 부모의 것을 호출한다
         * 만약
         * 자식 클래스에서 중복 정의되어 있을 경우에는 변수는 컴파일 시점 참조변수타입에 따라서 선택되고
         * 메소드는 런타임시점 실제 인스터스의 타입에 따라서 결정된다
         */
        System.out.println("p.x = " + p.x);
        p.method();

        System.out.println("c.x = " + c.x);
        c.method();

        /** === 출력값 ===
         * p.x = 100
         * parent 의 메소드
         * c.x = 100
         * parent 의 메소드
         */
    }
}

class Parent2 {
    int x = 100;
    void method() {
        System.out.println("parent 의 메소드");
    }
}
// 자식 클래스에 아무것도 정의되지 않았다
class Child2 extends Parent2 { }