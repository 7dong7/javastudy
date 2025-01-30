package org.generics.wildCard2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// 과일
class Fruit {
    String name;
    int weight;

    Fruit(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
    public String toString() {return name +" ( " + weight + " )";}
}
    // 사과
class Apple extends Fruit {
    Apple(String name, int weight) {
        super(name, weight);
    }
}
    // 포도
class Grape extends Fruit {
    Grape(String name, int weight) {
        super(name, weight);
    }
}

// 계산 클래스
class AppleComp implements Comparator<Apple> {
    public int compare(Apple o1, Apple o2) {
        return o2.weight - o1.weight;
    }
}

class GrapeComp implements Comparator<Grape> {
    public int compare(Grape o1, Grape o2) {
        return o2.weight - o1.weight;
    }
}

class FruitComp implements Comparator<Fruit> {
    public int compare(Fruit o1, Fruit o2) {
        return o1.weight - o2.weight;
    }
}

// 과일 상자
class FruitBox<T extends Fruit> extends Box<T> {}

// 상자
class Box<T> {
    ArrayList<T> list = new ArrayList<T>();
    void add(T item)               { list.add(item); }
    T get(int i)                { return list.get(i); }
    ArrayList<T> getList()      { return list; }
    int size()                  { return list.size(); }
    public String toString()    { return list.toString(); }
}


public class WildCard2 {
    public static void main(String[] args) {
        FruitBox<Apple> appleBox = new FruitBox<>();
        FruitBox<Grape> grapeBox = new FruitBox<>();

        appleBox.add(new Apple("GreenApple", 300));
        appleBox.add(new Apple("GreenApple", 100));
        appleBox.add(new Apple("GreenApple", 200));

        grapeBox.add(new Grape("GreenGrape", 400));
        grapeBox.add(new Grape("GreenGrape", 300));
        grapeBox.add(new Grape("GreenGrape", 200));

        Collections.sort(appleBox.getList(), new AppleComp());
        Collections.sort(grapeBox.getList(), new GrapeComp());
        System.out.println("appleBox = " + appleBox);
        System.out.println("grapeBox = " + grapeBox);
        System.out.println();
        Collections.sort(appleBox.getList(), new FruitComp());
        Collections.sort(grapeBox.getList(), new FruitComp());
        System.out.println("appleBox = " + appleBox);
        System.out.println("grapeBox = " + grapeBox);
    }
}
