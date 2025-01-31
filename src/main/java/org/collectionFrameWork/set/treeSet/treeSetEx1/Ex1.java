package org.collectionFrameWork.set.treeSet.treeSetEx1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

// tree set 범위 검색
public class Ex1 {
    public static void main(String[] args) {
        TreeSet set = new TreeSet<>();

        set.add(1); set.add(2); set.add(3); set.add(4); set.add(5); set.add(6);
        set.add(7); set.add(8); set.add(9); set.add(10); set.add(11); set.add(12);

        // 범위를 지정하면 시작 값과 끝 값 - 1 범위에서 set 값을 가져옵니다
        System.out.println("=== set subset()===");
        System.out.println(set);
        System.out.println("set.subset(4,10): " + set.subSet(4,10) + "\n"); // set.subset(4,10): [4, 5, 6, 7, 8, 9]

        TreeSet<Integer> set1 = new TreeSet<>();
        Integer[] score = {80, 90, 100, 120, 75, 30, 20, 50};
        set1.addAll(Arrays.asList(score));

        // 해당하는 값보다 작은 값의 객체들과 큰 값의 객체들을 얻을 수 있다
        System.out.println("=== set headSet(), tailSet() ===");
        System.out.println("set1 = " + set1);
        System.out.println("set1.headSet(50) = " + set1.headSet(50)); // [20, 30]
        System.out.println("set1.tailSet(50) = " + set1.tailSet(50)); // [50, 75, 80, 90, 100, 120]
    }
}
