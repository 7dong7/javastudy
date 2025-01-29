package org.stream.streamOperation;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMidOperation {
    public static void main(String[] args) {
        // 스트림 자르기 - skip(), limit()
        System.out.println("======== skip(), limit() ========");
        IntStream intStream = IntStream.rangeClosed(1, 10);
        intStream.skip(3).limit(5).forEach(System.out::print); // 45678

        System.out.println();
        // 스트림 요소 걸러내기 - filter(), distinct()
        System.out.println("======== filter(), distinct() ========");
        IntStream intStream1 = IntStream.of(1, 2, 2, 3, 3, 3, 4, 5, 5, 6);
        intStream1.distinct().forEach(System.out::print); // 123456  중복 제거

        System.out.println();
        IntStream intStream2 = IntStream.rangeClosed(1, 10);
        intStream2.filter(i -> i % 2 == 0).forEach(System.out::print); // 246810 짝수만 통과

        System.out.println();
        IntStream intStream3 = IntStream.rangeClosed(1, 10);
        intStream3.filter(i -> i % 2 == 0 && i % 3 == 0).forEach(System.out::print);

        System.out.println();
        // 정렬 - sorted()
        System.out.println("======== sorted() ========");
        Stream<String> strStream = Stream.of("dd","aaa","CC", "cc", "b");
        // 기본적인 정렬 
//        strStream.sorted().forEach(System.out::println); // 기본정렬 사전순 정렬로 정렬
//        strStream.sorted(Comparator.naturalOrder()).forEach(System.out::print);
//        strStream.sorted((s1, s2) -> s1.compareTo(s2)).forEach(System.out::print); // 람다식 사용
//        strStream.sorted(String::compareTo).forEach(System.out::print); // 메소드 참조
        // CCaaabccdd

//        strStream.sorted(Comparator.reverseOrder()).forEach(System.out::print);
        // ddccbaaaCC

//        strStream.sorted(String.CASE_INSENSITIVE_ORDER).forEach(System.out::print); // 대소문자 구분안함
        // aaabCCccdd
//        strStream.sorted(String.CASE_INSENSITIVE_ORDER.reversed()).forEach(System.out::print); // 대소문자 구분안함 반대로
        // ddCCccbaaa

        strStream.sorted(Comparator.comparing(String::length)).forEach(System.out::print); // 길이 순 정렬
        // bddCCccaaa

        
        
    }
}
