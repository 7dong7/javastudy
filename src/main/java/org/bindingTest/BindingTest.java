package org.bindingTest;

public class BindingTest {
    // 부모 클래스와 자식클래스에 같은 이름으로 멤버가 정의된 경우 호출 순서
    public static void main(String[] args) {
        Parent2 p = new Child2();
        Child2 c = new Child2();
        /**
         *  # 메소드의 경우
         *      런타임 시점에서 실제 인스터스의 타입에 따라서 결정된다
         *      현재 코드를 구동하면 실제 인스턴스의 타입인 child1 클래스의 method 메소드 호출된다
         *  # 멤버변수의 경우
         *      컴파일 시점에 참조변수의 타입에 따라서 결정된다
         *      현재 코드를 구동하기전 각 참조변수의 타입에 따라서 p(Parent1) c(Child1)의 x값이 각각 호출된다
         */
        System.out.println("p.x = " + p.x); 
        p.method();

        System.out.println("c.x = " + c.x);
        c.method();
    }
}

class Parent1 {
    int x = 100;
    void method() {
        System.out.println("parent 의 메소드");
    }
}

class Child1 extends Parent2 {
    int x = 200;
    void method() {
        System.out.println("child 의 메소드");
    }
}