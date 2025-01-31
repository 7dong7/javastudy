package org.interFace;

public class BuilderInterface {

    public static void main(String[] args) {
        Factory f = new Factory();
        int x = 10, y = 25;
        f.liftOff();
        f.move(x,y);
        f.stop();
        f.land();
    }
}

/**
 * builder 인터페이스를 사용해서 건물의 이동기능 메소드를 추가해 보자
 * 1. 건물 이동에 관련된 인터페이스 작성
 * 2. 해당 인터페이스에 대한 구현 클래스를 작성한다
 * 3. 작성 인터페이스를 상속시키고, 클래스 내부에 interface 의 impl 을 포함시킨다
 * 이렇게 작성함으로 건물 이동에 대한 기능을 클래스 내부가 아니라 클래스 외부에서 인터페이스의 구현으로 작성할 수 있게 되었다
 */


// 1. 건물 이동에 관련된 인터페이스 작성
interface Liftable {
    /* 건물을 들어 올린다 */
    void liftOff();
    /* 건물을 이동한다 */
    void move(int x, int y);
    /* 건물을 정지시킨다 */
    void land();
    /* 건물을 착륙한다*/
    void stop();
}

// 2. 해당 인터페이스에 대한 구현 클래스를 작성한다
class LiftableImpl implements Liftable {
    @Override
    public void liftOff() {
        System.out.println("건물 들어올리기");
    }
    @Override
    public void move(int x, int y) {
        System.out.println("건물 이동하기");
    }
    @Override
    public void land() {
        System.out.println("건물 착륙");
    }
    @Override
    public void stop() {
        System.out.println("건물 정지");
    }
}

// 3. 작성 인터페이스를 상속시키고, 클래스 내부에 interface 의 impl 을 포함시킨다
class Barrack implements Liftable {
    LiftableImpl l = new LiftableImpl();
    @Override
    public void liftOff() {
        l.liftOff();
    }
    @Override
    public void move(int x, int y) {
        l.move(x,y);
    }
    @Override
    public void land() {
        l.land();
    }
    @Override
    public void stop() {
        l.stop();
    }
}
class Factory implements Liftable {
    LiftableImpl l = new LiftableImpl();
    @Override
    public void liftOff() {
        l.liftOff();
    }
    @Override
    public void move(int x, int y) {
        l.move(x,y);
    }
    @Override
    public void land() {
        l.land();
    }
    @Override
    public void stop() {
        l.stop();
    }
}
