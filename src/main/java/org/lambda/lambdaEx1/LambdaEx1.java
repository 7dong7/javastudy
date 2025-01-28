package org.lambda.lambdaEx1;

// 함수형 인터페이스 선언
@FunctionalInterface
interface MyFunction {
    void run(); // 미완성 메소드 run()
}

public class LambdaEx1 {

    // 함수형 인터페이스를 매개변수로 받고 그 안의 미완성 메소드를 실행 시켰다
    static void execute(MyFunction f) { // 매개변수가 MyFunction 인 경우
        f.run();
    }
    
    // 함수형 인터페이스의 추상 메소드를 람다식으로 구현하고, 구현된 인터페이스를 반환했다
    static MyFunction getMyFunction() { // 반환타입이 MyFunction 인 경우
        MyFunction f = () -> System.out.println("f3.run()");
        return f;
    }

    // 실행
    public static void main(String[] args) {
        // 람다식으로 MyFunction run() 구현
        MyFunction f1 = () -> System.out.println("f1.run()");

        // 익명 클래스를 통해서 MyFunction run() 구현
        MyFunction f2 = new MyFunction() {
            @Override
            public void run() {
                System.out.println("f2.run()");
            }
        };

        // static 으로 run() 구현
        MyFunction f3 = getMyFunction();
        
        f1.run();
        f2.run();
        f3.run();

        // 람다식이 구현된 매개변수를 넘겨줘서 그대로 사용
        execute(f1);
        // 람다식의 구현식을 매개변수로 넘겨줘서 그대로 사용
        execute( () -> System.out.println("run()"));
    }
}


