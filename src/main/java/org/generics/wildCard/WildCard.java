package org.generics.wildCard;

import java.util.ArrayList;

// 과일 정의
class Fruit                 { public String toString() { return "Fruit"; }}
class Apple extends Fruit   { public String toString() { return "Apple"; }}
class Grape extends Fruit   { public String toString() { return "Grape"; }}


// 과일 상자
class FruitBox<T extends Fruit> extends Box<T> {}

// 상자
class Box<T> {
    ArrayList<T> list = new ArrayList<T>();
    void add(T t)               { list.add(t); }
    T get(int i)                { return list.get(i); }
    ArrayList<T> getList()      { return list; }
    int size()                  { return list.size(); }
    public String toString()    { return list.toString(); }
}

// 쥬스 클래스
class Juice {
    String name;
    Juice(String name)          { this.name = name + "Juice"; }
    public String toString()    { return name; }
}

// 쥬스 만들기 스태틱 클래스
class Juicer {
    static Juice makeJuice(FruitBox<? extends Fruit> box) {
        String tmp = "";

        for (Fruit f : box.getList()) {
            tmp += f + " ";
        }
        return new Juice(tmp);
    }
}

public class WildCard {
    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<>();
        FruitBox<Apple> appleBox = new FruitBox<>();

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());

        System.out.println(Juicer.makeJuice(fruitBox));
        System.out.println(Juicer.makeJuice(appleBox));
    }
}