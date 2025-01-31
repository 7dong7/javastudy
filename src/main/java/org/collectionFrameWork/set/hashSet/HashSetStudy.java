package org.collectionFrameWork.set.hashSet;

import java.util.*;

public class HashSetStudy {
    public static void main(String[] args) {
        Object[] objArr = {"1", "2", "2", "3", "3", "4", "4", "4"};
        Object[] objArr2 = {"3", "4", "5", "6", "7", "8", "9"};
        List list = new ArrayList(Arrays.asList(objArr2));

        // set 생성하기
        System.out.println("==== HashSet 생성 ====");
            // 생성자에 파라미터로 컬렉션 넣기
        Set set1 = new HashSet(Arrays.asList(objArr));
        System.out.println("set1 = " + set1); // set1 = [1, 2, 3, 4]
            // 반복문으로 추가 add()
        HashSet set2 = new HashSet<>();
        for (Object o : objArr) {
            set2.add(o);
        }
        System.out.println("set2 = " + set2); // set2 = [1, 2, 3, 4]
            // 컬렉션 통으로 addAll()
        HashSet set3 = new HashSet();
        set3.addAll(Arrays.asList(objArr));
        System.out.println("set3 = " + set3); // set3 = [1, 2, 3, 4]

        HashSet set4 = new HashSet<>();
        set4.addAll(list); // 합집합
        System.out.println("set4 = " + set4); // set4 = [3, 4, 5, 6, 7, 8, 9]
        set4.addAll(set1);
        System.out.println("set4.addAll(set1) = " + set4 + "\n"); // set4.addAll(set1) = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        
        // 지정된 객체를 이미 포함하고 있는지 체크 contains(), containsAll()
        System.out.println("==== 지정된 객체를 포함하고 있는지 확인 contains(), containsAll() ====");
        boolean containCheck = set4.contains(set1);
        System.out.println("set1 = " + set1);
        System.out.println("set4 = " + set4);
        System.out.println("containCheck = " + containCheck); // false  객체가 아니라 컬렉션을 넣었다
        boolean containCheck2 = set4.contains("1");
        System.out.println("containCheck2 = " + containCheck2); // true
        boolean b = set4.containsAll(list);
        System.out.println("b = " + b); // true
        boolean b1 = set4.containsAll(set1);
        System.out.println("b1 = " + b1); // true
        
        // set 이 비어있는지 확인 isEmpty()
        System.out.println("\n=== set 이 비어있는지 확인 isEmpty() ===");
        HashSet set5 = new HashSet<>();
        boolean empty = set5.isEmpty();
        System.out.println("empty = " + empty); // true 비어있다
        boolean empty2 = set4.isEmpty();
        System.out.println("empty2 = " + empty2); // false 비어있지 않다

        // set 안에 해당하는 객체를 삭제 remove(), removeAll()
        System.out.println("\n==== set 안에 해당하는 객체를 삭제 remove(), removeAll() ====");
        set1.remove("1");
        System.out.println("set1 = " + set1); // set1 = [2, 3, 4]
        System.out.println("set4 = " + set4); // set4 = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        set4.removeAll(set1); // 차집합
        System.out.println("set4 = " + set4); // set4 = [1, 5, 6, 7, 8, 9]

        // set 에 컬렉션과 겹치는 것만 남김 (교집합) retainAll()
        System.out.println("==== set 교집합 retainAll() ====");
        set4.retainAll(set2);
        System.out.println("set4 = " + set4); // set4 = [1]
    }
}
