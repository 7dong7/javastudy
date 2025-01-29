package org.stream.streamOperation;

import java.util.Optional;
import java.util.stream.Stream;

public class StreamFinalOperation {
    public static void main(String[] args) {

        Stream<Student> studentStream = Stream.of(
                new Student("김김김", 80, 70, 60), // 210
                new Student("박박박", 90, 80, 85), // 255
                new Student("이이이", 40, 30, 40) // 110
        );

        // === match() ===
//        boolean b = studentStream.anyMatch(s -> s.getTotalPoint() >= 200);
//        System.out.println("b = " + b); // true

        // === find() ===
        Optional<Student> first = studentStream.filter(x -> x.getTotalPoint() >= 200)
                .findFirst();
        Student student = first.orElseGet(() -> new Student());
        System.out.println( student.getName() +": "+ student.getTotalPoint());

    }
}

class Student {
    String name;
    int math;
    int english;
    int science;
    int totalPoint;

    public Student() {
    }

    public Student(String name, int math, int english, int science) {
        this.name = name;
        this.math = math;
        this.english = english;
        this.science = science;
        this.totalPoint = math + english + science;
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
}
