package org.stream.streamOperation;

import java.util.stream.IntStream;

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
    }
}
