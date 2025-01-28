package org.stream.stream;

import java.util.*;
import java.util.List;

public class Stream {
    public static void main(String[] args) {
        // 스트림의 경우 배열과 리스트를 다루는 방식이 똑같다
        String[] strArr = {"aaa", "bbb", "ccc"};
        List<String> strList = Arrays.asList(strArr);

        java.util.stream.Stream<String> strStream1 = strList.stream(); // 리스트를 스트림으로
        java.util.stream.Stream<String> strStream2 = Arrays.stream(strArr); // 배열을 스트림으로

        strStream1.sorted().forEach(System.out::println);
        System.out.println();
        strStream2.sorted().forEach(System.out::println);
    }
}
