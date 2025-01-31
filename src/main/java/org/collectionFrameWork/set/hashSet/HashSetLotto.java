package org.collectionFrameWork.set.hashSet;

import java.util.*;

public class HashSetLotto {
    public static void main(String[] args) {
        Set set = new HashSet<>();

        for ( int i = 0; set.size() < 6; i++ ) {
            int num = (int) (Math.random() * 45) + 1;
            set.add(num);
        }
        List list = new LinkedList<>(set); // Linked List( Collection c)
        Collections.sort(list);
        System.out.println("list = " + list); // list = [2, 9, 18, 26, 33, 35]
    }
}
