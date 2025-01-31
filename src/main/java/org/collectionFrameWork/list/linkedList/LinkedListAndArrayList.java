package org.collectionFrameWork.list.linkedList;


import java.util.*;

// 링크드 리스트에 대해서
public class LinkedListAndArrayList {
    public static void main(String[] args) {
        // 추가할 데이터의 개수를 고려하여 충분히 잡아야한다
        ArrayList<String> al = new ArrayList(2000000);
        LinkedList<String> ll = new LinkedList();

        System.out.println("==== 순차적으로 추가하기 ====");
        System.out.println("ArrayList: " + add1(al));  // ArrayList: 43 // 걸리는 시간 높은면 안좋음
        System.out.println("LinkedList: " + add1(ll)); // LinkedList: 108
        System.out.println();
        System.out.println("==== 중간에 추가하기 ====");
        System.out.println("ArrayList: " + add2(al)); // ArrayList: 1309
        System.out.println("LinkedList: " + add2(ll)); // LinkedList: 9
        System.out.println();
        System.out.println("==== 중간에 삭제하기 ====");
        System.out.println("ArrayList: " + remove2(al)); // ArrayList: 1306
        System.out.println("LinkedList: " + remove2(ll)); // LinkedList: 86
        System.out.println();
        System.out.println("==== 순차적 삭제하기 ====");
        System.out.println("ArrayList: " + remove1(al)); // ArrayList: 5
        System.out.println("LinkedList: " + remove1(ll)); // LinkedList: 17
    }

    public static Long add1(List list) { // 순차적 추가
        long start = System.currentTimeMillis(); // 시작 시간
        for (int i = 0; i < 1000000; i++) list.add(i+""); // 리스트에 요소 추가
        long end = System.currentTimeMillis(); // 끝 시간
        return end - start; // 시작 - 끝 = 걸린 시간
    }
    public static Long add2(List list) { // 중간 추가
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) list.add(500,"X"); // 해당 인덱스에 "X" 값 추가
        long end = System.currentTimeMillis();
        return end - start; // 걸린 시간
    }
    public static Long remove1(List list) { // 순차적 삭제
        long start = System.currentTimeMillis();
        for (int i = list.size()-1; i >= 0; i--) { list.remove(i);}
        long end = System.currentTimeMillis();
        return end - start;
    }
    public static Long remove2(List list) { // 중간 삭제
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) list.remove(i);
        long end = System.currentTimeMillis();
        return end - start;
    }
}
