package org.stream.streamOperation;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFinalOperation {
    public static void main(String[] args) {

        List<Student> studentList = Arrays.asList(
                new Student("김김김", 80, 70, 60), // totalPoint = 210
                new Student("박박박", 90, 80, 85), // totalPoint = 255
                new Student("이이이", 40, 30, 40) // totalPoint = 110
        );

        // === match() ===
//        boolean b = studentStream.anyMatch(s -> s.getTotalPoint() >= 200);
//        System.out.println("b = " + b); // true




        // === find() ===
        Optional<Student> first = studentList.stream().filter(x -> x.getTotalPoint() >= 200)
                .findFirst();
        Student student = first.orElseGet(Student::new); // () -> new Student()
        System.out.println( student.getName() +": "+ student.getTotalPoint());



        
        System.out.println();
        // === reduce() ===
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // 첫번째 방식
        Optional<Integer> reduce = numbers.stream()
                .reduce(Integer::sum); // (x, y) -> x + y
        // 스트림의 첫번째요소와 두번째요소를 가지고 초기연산을 한다
        Integer i = reduce.get();
        System.out.println("i = " + i);
        
        // 두번째 방식
        Integer reduce1 = numbers.stream()
                .reduce(0, Integer::sum); // (x, y) -> x + y
        // 초기값을 지정하면 반환 타입이 초기값의 타입이 된다
            // 초기값을 지정했을 경우 스트림이 비어있으면 초기값을 반환해야 되기 때문에 초기값의 타입이 반환타입이 된다
        System.out.println("reduce1 = " + reduce1);

        // 최대값 최솟값
            // 최댓값 1
        Optional<Integer> reduce2 = numbers.stream()
                .reduce(Integer::max); // (x, y) -> Integer.max(x, y)
        System.out.println("reduce2.get() 최댓값 = " + reduce2.get());
            // 최대값 2
        Optional<Integer> reduce4 = numbers.stream()
                .reduce((x, y) -> x > y ? x : y);
        System.out.println("reduce4.get() 최댓값 = " + reduce4.get());

        // 최솟값
        Optional<Integer> reduce3 = numbers.stream()
                .reduce(Integer::min); // (x, y) -> Integer.min(x, y)
        System.out.println("reduce3.get() = " + reduce3.get());




        System.out.println();
        // ====== collect() ======

        // 객체 스트림 -> List<String> 으로 변환
        List<String> nameList = studentList.stream()
                .map(Student::getName)// x -> x.getName()
                .toList(); // collect(Collectors.toList()) = toList()
        System.out.println("nameList = " + nameList);

        ArrayList<String> arrayList = new ArrayList<>(nameList);
        /* nameList.stream()
                .collect(Collectors.toCollection(() -> new ArrayList<>())) */
        System.out.println("arrayList = " + arrayList);
        
        // 객체 -> map 으로 변환
        Map<Integer, String> studentMap = studentList.stream()
                .collect(Collectors.toMap(Student::getId, Student::getName)); // p -> p.getId(), p -> p.getName()

    }
}

class Student {
    int id;
    String name;
    int math;
    int english;
    int science;
    int totalPoint;

    static int sequence = 0;

    public Student() {
    }

    public Student(String name, int math, int english, int science) {
        this.name = name;
        this.math = math;
        this.english = english;
        this.science = science;
        this.totalPoint = math + english + science;
        this.id = sequence++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getScience() {
        return science;
    }

    public void setScience(int science) {
        this.science = science;
    }

    public int getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }

    public int getId() {
        return id;
    }
}
