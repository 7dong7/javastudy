package org.lambda.lambdaEx2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LambdaEx2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        // list 안의 모든요소 출력
        System.out.println("list 안의 모든요소 출력");
        list.forEach( i -> System.out.println("i="+i));
        System.out.println();

        // list 안의 2의 배수, 3의 배수 제거
        System.out.println("list 안의 2의 배수, 3의 배수 제거");
        list.removeIf(x -> x % 2 == 0 || x % 3 == 0);
        System.out.println("list = " + list);
        System.out.println();

        // 리스트 안의 모든 요소에 10을 곱한다
        System.out.println("리스트 안의 모든 요소에 10을 곱한다");
        list.replaceAll(i -> i * 10);
        System.out.println("list = " + list);
        System.out.println();

        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");

        // 맵 안의 요소를 { k,v } 형태로 출력
        System.out.println("맵 안의 요소를 {k,v} 형태로 출력");
        map.forEach( (k,v) -> System.out.println( "{" + k + "," + v + "}"));
    }
}
