package org.generics.genericsEx.ex1;

public class Ex1 {
    public static void main(String[] args) {
        // 필드 타입이 오브젝트이면 형변환으로 받아야함
        Box box = new Box();
        box.content = "글씨 입력";

        // 꺼내온 값은 Object 타입
        Object content = box.content;
        // 필드 타입을 Object 로 할 경우 값을 꺼낼 때 마다 형변환이 필요
        String content1 = (String) box.content;

        box.content = 13;
        Object content2 = box.content;
        Integer content3 = (Integer) box.content;
        
        
        // 제네릭 사용
        GenericsBox<String> box1 = new GenericsBox<>();
        box1.content = "제네릭 글";

            // 형변환 없이 바로 꺼낼 수 있다   타입 안정성
        String content4 = box1.content;
        
        // 다른 타입 제네릭
        GenericsBox<Integer> box2 = new GenericsBox<>();
        box2.content = 13;
            // 형변환 없이 바로 꺼낼 수 있다
        Integer content5 = box2.content;

    }
}

// 제네릭 지정
class GenericsBox<T> {
    T content;
}

// 오브젝트 타입 박스
class Box {
    Object content;
}