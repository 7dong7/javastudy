package org.collectionFrameWork.map.hashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapEx {
    public static void main(String[] args) {
        Map<String, Integer> intMap = new HashMap<>();
        intMap.put("apple", 1000); intMap.put("orange", 2000);
        intMap.put("pear", 3000); intMap.put("pineapple", 4000);

        // 맵 안의 키-값 쌍 접근 entrySet()
        Set<Map.Entry<String, Integer>> entries = intMap.entrySet();
        intMap.put("greenApple", 1400); // 연결되어 있어서 여기서 추가해도 추가됨
        System.out.println("entries = " + entries); // [orange=2000, apple=1000, pear=3000, pineapple=4000]
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println("entry = " + entry); // orange=2000 ...
        }

        // 키 접근 - keySet(), 값 접근 - values()
        System.out.println("\n==== 키 접근 - keySet(), 값 접근 - values() ====");
        System.out.println("intMap.keySet() = " + intMap.keySet()); // [orange, apple, pear, pineapple, greenApple]
        System.out.println("intMap.values() = " + intMap.values()); // [2000, 1000, 3000, 4000, 1400]
        
        // 중복된 값 허용하지 않음
        System.out.println("\n=== 중복된 값 허용하지 않음 ===");
        intMap.put("box", 1200);
        intMap.put("box", 1500);
        System.out.println("intMap.get(\"box\") = " + intMap.get("box"));

    }
}
