package org.collectionFrameWork.map.linkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapEx {
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();
        
        // 데이터 추가
        map.put("Apple", 100);
        map.put("Banana", 150);
        map.put("Orange", 200);
        map.put("Mango", 250);

        // 데이터 조회 get()
        System.out.println("==== 데이터 조회 ====");
        Set<String> strings = map.keySet();
        for (String string : strings) {
            Integer i = map.get(string);
            System.out.println("map.get("+string+") = " + i );
        }
        System.out.println();

        // 특정 키가 맵에 존재하는지 확인 containsKey()
        System.out.println("==== 특정 키가 맵에 존재하는지 확인 ====");
        boolean b = map.containsKey("Apple"); // Apple 이 map 에 키로 사용되었는지 확인 반환값 boolean 타입
        System.out.println("map.containsKey(\"Apple\") = " + b + "\n");

        // 특정 값이 맵에 존재하는지 확인 containsValue()
        System.out.println("==== 특정 값이 맵에 존재하는지 확인 ====");
        boolean b1 = map.containsValue(1);
        System.out.println("map.containsValue(1) = " + b1);
        boolean b2 = map.containsValue(100);
        System.out.println("map.containsValue(100) = " + b2 + "\n");

        // 데이터 삭제 remove()
        System.out.println("==== 데이터 삭제 ====");
        map.remove("Apple");
        System.out.println("map = " + map + "\n"); // {Banana=150, Orange=200, Mango=250}

        // 맵 크기 size()
        System.out.println("==== 맵 크기 ====");
        int size = map.size();
        System.out.println("mao.size() = " + size +"\n");
        
        // 맵 반복호출
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println("map = " + entry.getKey() + " = " + entry.getValue());
        }
        System.out.println();

        // 모든 항목 삭제
        map.clear();
        System.out.println("map = " + map);

    }
}
