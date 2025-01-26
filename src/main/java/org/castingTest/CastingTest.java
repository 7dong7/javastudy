package org.castingTest;

public class CastingTest {

    public static void main(String[] args) {
        Car car = null;
        FireEngine fe = new FireEngine();
        FireEngine fe2 = null;

        fe.water();
        car = fe;
//        car.water();
        fe2 = (FireEngine) car;
        fe2.water();

        Car c = new FireEngine();
        ((FireEngine) c).water();
    }
}


// 클래스
class Car {
    String color;
    int door;

    void drive() { // 운전 기능
        System.out.println("drive, brr");
    }

    void stop() {
        System.out.println("stop~!");
    }
}

class FireEngine extends Car {
    void water() {
        System.out.println("water shot~~!");
    }
}