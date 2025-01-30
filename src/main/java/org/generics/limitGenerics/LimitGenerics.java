package org.generics.limitGenerics;

import java.util.ArrayList;

// 인터페이스
interface Eatable {}

class Fruit implements Eatable {
    public String toString() {
        return "Fruit";
    }
}
// 과일 정의
class Apple extends Fruit   { public String toString() { return "Apple"; }}
class Grape extends Fruit   { public String toString() { return "Grape"; }}
class Toy                   { public String toString() { return "Toy"; }}
class Mint implements Eatable { public String toString() { return "Mint"; }}

// 과일 상자
class FruitBox<T extends Fruit & Eatable> extends Box<T> {}

// 상자
class Box<T> {
    ArrayList<T> list = new ArrayList<T>();
    void add(T t)               { list.add(t); }
    T get(int i)                { return list.get(i); }
    int size()                  { return list.size(); }
    public String toString()    { return list.toString(); }
}

public class LimitGenerics {
    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
        FruitBox<Apple> appleBox = new FruitBox<Apple>();
        FruitBox<Grape> grapeBox = new FruitBox<Grape>();
//        FruitBox<Apple> grapeBox2 = new FruitBox<Grape>(); // 에러: 타입 불일치
//        FruitBox<Toy> toyBox = new FruitBox<Toy>(); // 에러: 사용불가 타입

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());
        fruitBox.add(new Grape());
        appleBox.add(new Apple());
//        appleBox.add(new Grape()); // 에러: Grape 는 Apple 의 자손이 아님
        grapeBox.add(new Grape());
//        fruitBox.add(new Mint()); // interface 구현이 아닌 Fruit 상속을 받아야함

        System.out.println("fruitBox = " + fruitBox);
        System.out.println("appleBox = " + appleBox);
        System.out.println("grapeBox = " + grapeBox);
    }
}