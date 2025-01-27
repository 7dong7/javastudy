package org.interfaceStudy.defaultMethodTest;

public class DefaultMethodTest {
    public static void main(String[] args) {
        Child c = new Child();
        c.method1();                    // method1() in Child   (자식 메소드)
        c.method2();                    // method2() in Parent  (부모 메소드)
        MyInterface.staticMethod();     // staticMethod() in MyInterface (인터페이스 스태틱 메소드)
        MyInterface2.staticMethod();    // staticMethod() in MyInterface2 (인터페이스 스태틱 메소드)

        System.out.println("===============================");
        System.out.println("===============================");
        // 테스트 클래스
        TestClass t = new TestClass();
        t.method1();        // method1() in MyInterface2 (인터페이스 default 메소드)
        t.testMethod();     // testMethod() in MyInterface2 (인터페이스 default 메소드)
    }
}

// 자식 클래스
class Child extends Parent implements MyInterface, MyInterface2 {
    public void method1() {
        System.out.println("method1() in Child");
    }
}

// 부모 클래스
class Parent {
    public void method2() {
        System.out.println("method2() in Parent");
    }
}

// 인터페이스1
interface MyInterface {
    default void method1() {
        System.out.println("method1() in MyInterface");
    }
    default void method2() {
        System.out.println("method2() in MyInterface");
    }
    static void staticMethod() {
        System.out.println("staticMethod() in MyInterface");
    }
}
// 인터페이스2
interface MyInterface2 {
    default void method1() {
        System.out.println("method1() in MyInterface2");
    }
    static void staticMethod() {
        System.out.println("staticMethod() in MyInterface2");
    }

    // 추가 default test
    default void testMethod() {
        System.out.println("testMethod() in MyInterface2");
    }
}

// 테스트 클래스
class TestClass implements MyInterface2{

}