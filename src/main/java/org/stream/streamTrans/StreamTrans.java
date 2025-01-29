package org.stream.streamTrans;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamTrans {
    public static void main(String[] args) {

        // 파일 이름 뽑기
        Stream<File> filesStream = Stream.of(new File("Ex1.java"),
                new File("Ex1"),
                new File("Ex1.bak"),
                new File("Ex2.java"),
                new File("Ex1.txt"));
        
        // === map 사용 file -> string 변환 ===
//        filesStream.map(File::getName).forEach(System.out::println);

//        filesStream.map(File::getName)                      // 파일 이름
//                .filter(s -> s.indexOf('.') != -1)          // 확장자 없는거 제외
//                .map(s -> s.substring(s.indexOf('.') + 1))  // String 형태 변환
//                .map(String::toUpperCase)                   // 대문자로 변환
//                .distinct()                                 // 중복제거
//                .forEach(System.out::print);              // 출력
        // JAVABAKTXT

        // === 조회 peek() 사용 ===
        filesStream.map(File::getName)                      // 파일 이름
                .filter(s -> s.indexOf('.') != -1)          // 확장자 없는거 제외
                .peek(s -> System.out.printf("filename=%s%n", s)) // 파일명 출력 peek()
                .map(s -> s.substring(s.indexOf('.') + 1))  // String 형태 변환
                .peek(s -> System.out.printf("extension=%s%n", s))
                .forEach(System.out::println);              // 출력

        System.out.println();
        // === flatMap() 사용 ===
        Stream<String[]> strArrStream = Stream.of(new String[]{"abc", "def", "ghi"},
                                                new String[]{"ABC", "GHI", "JKLMN"});

//        Stream<Stream<String>> streamStream = strArrStream.map(x -> Arrays.stream(x));
//        Stream<String> stringStream = strArrStream.flatMap(x -> Arrays.stream(x));

        String[] lineArr = {"Belive or not It is true", "Do or do not There is no try",};
        Stream<String> lineStream = Arrays.stream(lineArr);
        Stream<String> strStream = lineStream.flatMap(line -> Stream.of(line.split(" ")));
//        stringStream1.forEach(System.out::println);

        strStream.map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        System.out.println();
        Stream<String> strStream1 = Stream.of("AAA", "ABC", "bBb", "Dd");
        Stream<String> strStream2 = Stream.of("bbb", "aaa", "ccc", "dd");
        Stream<Stream<String>> strStrmStrm = Stream.of(strStream1, strStream2);
        Stream<String> stringStream = strStrmStrm.map(x -> x.toArray(String[]::new))
                                                 .flatMap(Arrays::stream);
        stringStream.map(String::toLowerCase)
                .distinct()
                .forEach(System.out::println);
    }
}
