package org.stream.streamOperation;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

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



        System.out.println();
        // ========= 통계 =========
        long count = studentList.stream()
                .count();
        /* studentList.size() */
        System.out.println("count = " + count);
        Long count2 = studentList.stream().collect(counting()); // static import
        System.out.println("count2 = " + count2);


        System.out.println();
        // ========= 문자열 결합 =========
        String collect = studentList.stream()
                .map(s -> s.getName())
                .collect(joining(", "));
        System.out.println("collect = " + collect); // collect = 김김김, 박박박, 이이이

        String collect1 = studentList.stream()
                .map(s -> s.getName())
                .collect(joining(", ", "[", "]"));
        System.out.println("collect1 = " + collect1); // [김김김, 박박박, 이이이]



        System.out.println();
        // ========== 그릅화와 분할 ===========
        List<Stu> stuList = Arrays.asList(
                new Stu("나자바", true, 1, 1, 300),
                new Stu("김자바", true, 2, 1, 200),
                new Stu("박자박", false, 3, 1, 100),
                new Stu("박자남", false, 1, 2, 130),
                new Stu("근대용", true, 2, 2, 330),

                new Stu("몰라용", false, 3, 2, 257),
                new Stu("안해요", false, 1, 3, 215),
                new Stu("이지미", true, 2, 3, 195),
                new Stu("나지미", true, 3, 3, 132),
                new Stu("오지미", false, 1, 3, 300),

                new Stu("김자바", true, 2, 3, 220),
                new Stu("박자바", false, 3, 3, 90)
        );
        // partitioningBy 분류
            // 1. 기본분할
        Map<Boolean, List<Stu>> collect2 = stuList.stream()
                .collect(partitioningBy(x -> x.isMale));

        List<Stu> stus = collect2.get(true);
        List<Stu> stus2 = collect2.get(false);
        System.out.println("남학생");
        for (Stu stu : stus) {
            System.out.println("stu = " + stu);
        }
        System.out.println("여학생");
        for (Stu stu : stus2) {
            System.out.println("stu = " + stu);
        }

            // 2. 기본분할 + 통계 정보
                // 성별 수
        Map<Boolean, Long> collect3 = stuList.stream()
                .collect(partitioningBy(Stu::isMale, counting()));
        System.out.println("남학생 수 = " + collect3.get(true));
        System.out.println("여학생 수 = " + collect3.get(false));
                // 성별 1등
        Map<Boolean, Optional<Stu>> topScoreBySex = stuList.stream()
                .collect(partitioningBy(Stu::isMale,
                        maxBy(comparingInt(x -> x.getScore())))
                );
        System.out.println("남학색 1등 = " + topScoreBySex.get(true));
        System.out.println("여학생 1등 = " + topScoreBySex.get(false));
                // 성적이 150 아래인 사람 불합격, 불합격자를 성별로 분류
        Map<Boolean, Map<Boolean, List<Stu>>> failedStuBySex = stuList.stream()
                .collect(
                        partitioningBy(Stu::isMale,
                                partitioningBy(s -> s.getScore() < 150)
                        )
                );
        List<Stu> failedMaleStu = failedStuBySex.get(true).get(true);
        List<Stu> failedFemaleStu = failedStuBySex.get(false).get(true);
        System.out.println("failedMaleStu = " + failedMaleStu);
        System.out.println("failedFemaleStu = " + failedFemaleStu);

        System.out.println();
        // groupingBy 분류
            // 학생의 반에 따라서 분류
        Map<Integer, List<Stu>> banStu = stuList.stream()
                .collect( groupingBy(Stu::getBan) );// x -> x.getBan() 반으로 분류
        System.out.println("1반");
        for (Stu stu : banStu.get(1)) {
            System.out.println("stu = " + stu);
        };
        System.out.println("2반");
        for (Stu stu : banStu.get(2)) {
            System.out.println("stu = " + stu);
        }
        System.out.println("3반");
        for (Stu stu : banStu.get(3)) {
            System.out.println("stu = " + stu);
        }

            // 학생의 등급에 따라서 학생 수 반환
        Map<Stu.Level, Long> stuByLevel = stuList.stream()
                .collect(
                        groupingBy(s -> {
                            if (s.getScore() >= 200) return Stu.Level.HIGH;
                            else if (s.getScore() >= 100) return Stu.Level.MID;
                            else return Stu.Level.LOW;
                        }, counting())
                );
        System.out.println("stuByLevel = " + stuByLevel);
        System.out.println();
        
            // 학년별로 그룹화, 반별로 그룹화
        Map<Integer, Map<Integer, List<Stu>>> stuByHakAndBan = stuList.stream()
                .collect(groupingBy(Stu::getHak,
                                groupingBy(Stu::getBan)
                        )
                );
        Set<Integer> integers = stuByHakAndBan.keySet();
        for (Integer integer : integers) {
            Set<Integer> keys = stuByHakAndBan.get(integer).keySet();
            for (Integer key : keys) {
                System.out.println("["+integer+"-"+key+"]"+stuByHakAndBan.get(integer).get(key));
            }
        }
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

class Stu {

    String name;
    boolean isMale;
    int hak;
    int ban;
    int score;

    public Stu(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return isMale;
    }

    public int getHak() {
        return hak;
    }

    public int getBan() {
        return ban;
    }

    public int getScore() {
        return score;
    }

    public String toString() {
        return String.format("[%s, %s, %d학년, %d반, %3d점]",
                name, isMale ? "남" : "녀", hak, ban, score);
    }
    enum Level {
        HIGH, MID, LOW
    }
}
