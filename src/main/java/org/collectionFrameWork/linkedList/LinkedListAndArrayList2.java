package org.collectionFrameWork.linkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// LinkedList 와 ArrayList 의 요소의 접근시간 차이
public class LinkedListAndArrayList2 {
    public static void main(String[] args) {
        ArrayList al = new ArrayList<>(1000000);
        LinkedList ll = new LinkedList<>();
        add(al);
        add(ll);

        System.out.println("==== 접근 시간 테스트 ====");
        System.out.println("ArrayList: " + access(al)); // ArrayList: 3
        System.out.println("LinkedList: " + access(ll)); // LinkedList: 3470
    }

    public static void add(List list) { // 리스트 요소 추가하기
        for (int i = 0; i < 100000; i++) list.add(i + "");
    }

    public static long access(List list) { // 리스트의 요소에 대한 접근 시간
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) list.get(i);
        long end = System.currentTimeMillis();
        return end - start;
    }
}
