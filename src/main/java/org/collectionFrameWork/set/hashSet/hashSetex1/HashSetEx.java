package org.collectionFrameWork.set.hashSet.hashSetex1;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx {
    public static void main(String[] args) {
        Object[] objArr = {"1", 1, "2", "2", "3", "3", "4", "4", "4"};
        Set set = new HashSet<>();

        for (int i = 0; i < objArr.length; i++) {
            set.add(objArr[i]); // HashSet 에 objArr 의 요소들을 저장
        }
        // HashSet 에 저장된 요소들을 출력한다
        System.out.println("set = " + set); // set = [1, 1, 2, 3, 4]
        // "1", 1 은 다르기 때문에 중복이 아니다
    }
}
