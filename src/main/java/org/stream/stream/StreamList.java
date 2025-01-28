package org.stream.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamList {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> intStream = list.stream(); // 리스트를 소스로 하는 컬렉션 생성

        intStream.forEach(System.out::println);
        // 해당 스트림을 다시 사용하려고 하면 에러    이미 위에서 스트림의 최종연산을해 스트림이 닫혔다
//        intStream.forEach(System.out::println);
    }
}
