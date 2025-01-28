package org.stream.stream;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamArray {
    public static void main(String[] args) {
        Stream<String> strStream1 = Stream.of("a", "b", "c", "d");
        Stream<String> strStream2 = Stream.of(new String[]{"a", "b", "c", "d"});
        Stream<String> strStream3 = Arrays.stream(new String[]{"a", "b", "c", "d"});
        Stream<String> strStream4 = Arrays.stream(new String[]{"a", "b", "c", "d","e"}, 0, 3);

        strStream1.forEach(System.out::print);
        System.out.println();
        strStream2.forEach(System.out::print);
        System.out.println();
        strStream3.forEach(System.out::print);
        System.out.println();
        strStream4.forEach(System.out::print);
        System.out.println();

        IntStream intStream1 = IntStream.of(new int[]{1, 2, 3, 4, 5});
        IntStream intStream2 = Arrays.stream(new int[]{1, 2, 3, 4, 5});

        intStream1.forEach(System.out::print);
        System.out.println();
        intStream2.forEach(System.out::print);
        System.out.println();

        // 특정 범위 정수
        System.out.println("==== 특정 범위 정수 ====");
        IntStream rangeStream = IntStream.range(1, 5); // 1 2 3 4
        IntStream rangeClosedStream = IntStream.rangeClosed(1, 5); // 1 2 3 4 5

        rangeStream.forEach(System.out::print);
        System.out.println();
        rangeClosedStream.forEach(System.out::print);
        System.out.println();

        // 임의의 수
        System.out.println("=== 임의의 수 ===");
        IntStream randomIntStream = new Random().ints();
        randomIntStream.limit(5).forEach(System.out::println);
        // 혹은
        System.out.println();
        IntStream random5IntStream = new Random().ints(5);
        random5IntStream.forEach(System.out::println);
        
        // 스트림 연결        
        System.out.println("=== 스트림 연결 ===");
        String[] str1 = {"123", "456", "789"};
        String[] str2 = {"abc", "def", "ghi"};

        Stream<String> str1Stream = Stream.of(str1);
        Stream<String> str2Stream = Stream.of(str2);
        Stream<String> concatStream = Stream.concat(str1Stream, str2Stream);

        concatStream.forEach(System.out::println);
    }
}
