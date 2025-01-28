package org.lambda.methodReference;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReference {
    public static void main(String[] args) {
        // ==== 정적(static) 메소드 참조 ==== //
        // Supplier -> 입력없음, 출력있음
        // 람다 표현식
        Function<String, Integer> lamParser = str -> Integer.parseInt(str);
        // 메소드 참조
        Function<String, Integer> methParser = Integer::parseInt;

        System.out.println(lamParser.apply("123"));
        System.out.println(methParser.apply("456"));

        System.out.println();

        // ==== 인스턴스 메소드 참조 ==== //
        String message = "instance method reference";
        // Supplier -> 입력없음, 출력있음
        // 람다 표현식
        Supplier<String> lamSupplier = () -> message.toUpperCase();

        // 메소드 참조
        Supplier<String> methSupplier = message::toUpperCase;

        System.out.println(lamSupplier.get());
        System.out.println(methSupplier.get());
        System.out.println();

        // ==== 특정 타입의 인스턴스 메소드 참조 ==== //
        // function 과 비슷 -> 입력있음, 출력있음
        // 람다 표현식
        BiPredicate<String, String> lamBiPredicate = (str1, str2) -> str1.equalsIgnoreCase(str2);

        // 메소드 참조
        BiPredicate<String, String> methBiPredicate = String::equalsIgnoreCase;

        System.out.println(lamBiPredicate.test("java", "JAVA"));
        System.out.println(methBiPredicate.test("hello", "HELLO"));
        System.out.println();

        // ==== 생성자 참조 ====
        // Supplier -> 입력없음, 출력있음
        // 람다 표현식
        Supplier<User> lamConstructor = () -> new User();
        User user1 = lamConstructor.get();

        // 생성자 참조
        Supplier<User> methConstructor = User::new;
        User user2 = methConstructor.get();

        System.out.println(user1.getName());
        System.out.println(user2.getName());
        
    }
}

class User {
    private String name;

    public User() {
        this.name = "default name";
    }

    public String getName() {
        return name;
    }
}